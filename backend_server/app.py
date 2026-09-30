"""
MentalCare AI - Flask AI REST API Server
MCA Project - CA1 Continuation & CA3 AI System
Team: Group 11 (Joylyn Princita Fernandes, Syed Faizan Pasha, Vishwajeet Singh)
Department of MCA, Jain (Deemed-to-be University)

Endpoints:
- GET  /health: Health check, team members, and metadata
- POST /predict: Predict stress level from check-in text (Standard ML format)
- POST /checkin: Alias for /predict
- POST /api/analyze_text: Full NLP analysis with indicators & recommendations
- POST /api/analyze_burnout: Multi-day trend burnout pattern analysis
"""

import os
from flask import Flask, request, jsonify
from flask_cors import CORS
from nlp_engine import NLPEngine
from chat_engine import ChatEngine

app = Flask(__name__)
CORS(app)

engine = NLPEngine()
chat_engine = ChatEngine()

@app.route('/health', methods=['GET'])
def health():
    return jsonify({
        "status": "OK",
        "app_name": "MentalCare AI",
        "tagline": "Understand. Relax. Thrive.",
        "team_members": [
            "Joylyn Princita Fernandes (25MCAR0099)",
            "Syed Faizan Pasha (25MCAR0138)",
            "Vishwajeet Singh (25MCAR0219)"
        ],
        "version": "2.0.0"
    })

@app.route('/predict', methods=['POST'])
@app.route('/checkin', methods=['POST'])
@app.route('/api/analyze_text', methods=['POST'])
def analyze_text():
    try:
        data = request.json or {}
        text = data.get("text", "") or data.get("journal", "")
        sleep_hrs = data.get("sleep_hrs", None)
        work_hrs = data.get("work_hrs", None)

        if not text or not str(text).strip():
            return jsonify({"error": "Text parameter is required and cannot be empty"}), 400

        result = engine.analyze(str(text).strip(), sleep_hrs=sleep_hrs, work_hrs=work_hrs)
        
        # Expose standard prediction response fields for /predict endpoint
        result["stress_level"] = result.get("stressLevel", result.get("stress_level", "LOW"))
        result["confidence"] = round(result.get("confidence", 90.0) / 100.0 if result.get("confidence", 90.0) > 1 else result.get("confidence", 0.90), 2)
        
        return jsonify(result)
    except Exception as e:
        return jsonify({
            "error": "Failed to analyze text",
            "details": str(e),
            "stress_level": "MODERATE",
            "confidence": 0.50
        }), 500

@app.route('/api/analyze_burnout', methods=['POST'])
def analyze_burnout():
    """
    Analyzes historical stress scores across days to identify multi-day burnout patterns.
    """
    data = request.json or {}
    scores = data.get("scores", [])
    
    if len(scores) < 3:
        return jsonify({
            "burnout_risk": "LOW",
            "is_burnout_pattern": False,
            "trend_message": "Insufficient check-in data to detect multi-day burnout pattern.",
            "average_score": round(sum(scores)/len(scores), 1) if scores else 0
        })

    recent = scores[-5:]
    is_increasing = all(recent[i] <= recent[i+1] for i in range(len(recent)-1))
    avg_score = sum(recent) / len(recent)
    
    is_burnout = (is_increasing and len(recent) >= 4 and avg_score > 58) or (avg_score >= 75)
    
    if is_burnout:
        risk = "HIGH"
        msg = f"Increasing Stress Pattern Detected! Your stress levels have risen consistently over the past {len(recent)} days (Avg {avg_score:.0f}%). Consider prioritizing rest and speaking with a trusted person."
        recs = [
            "Take 1-2 restorative rest days away from work/study responsibilities.",
            "Discuss workload adjustments with your manager or team.",
            "Schedule a session with your trusted contact or a wellness counselor."
        ]
    elif avg_score > 48:
        risk = "MODERATE"
        msg = f"Moderate stress trajectory (Avg {avg_score:.0f}%). Keep up daily wellness breaks."
        recs = [
            "Maintain consistent 7-8 hours sleep.",
            "Schedule daily 15-minute relaxation breaks."
        ]
    else:
        risk = "LOW"
        msg = f"Healthy stress trajectory (Avg {avg_score:.0f}%). Your emotional wellness pattern is stable."
        recs = ["Keep up your healthy daily wellness routine!"]

    return jsonify({
        "burnout_risk": risk,
        "is_burnout_pattern": is_burnout,
        "trend_message": msg,
        "average_score": round(avg_score, 1),
        "recent_scores": recent,
        "recommendations": recs
    })

@app.route('/chat', methods=['POST'])
@app.route('/api/chat', methods=['POST'])
def chat():
    """
    Empathetic AI Wellness Chatbot Endpoint
    Accepts: { "user_id": str, "message": str, "conversation_id": str, "current_stress_level": str }
    Returns: { "conversation_id": str, "reply": str, "is_crisis": bool, "recommendations": list }
    """
    try:
        data = request.json or {}
        message = data.get("message", "") or data.get("text", "")
        if not message or not str(message).strip():
            return jsonify({
                "error": "Empty message",
                "reply": "Please enter a message to share how you are feeling."
            }), 400

        user_id = data.get("user_id", "default_user")
        stress_level = data.get("current_stress_level", None) or data.get("stress_level", None)
        conversation_id = data.get("conversation_id", None)

        print(f"[POST /chat] user={user_id} conv={conversation_id} msg_len={len(str(message))}")

        response = chat_engine.respond(
            str(message).strip(),
            user_id=user_id,
            conversation_id=conversation_id,
            current_stress_level=stress_level
        )
        return jsonify(response), 200
    except Exception as e:
        print(f"[POST /chat] Error: {e}")
        return jsonify({
            "error": "Failed to process chat message",
            "details": str(e),
            "reply": "I encountered an issue processing your message. Please try sending it again in a moment.",
            "is_crisis": False
        }), 500

if __name__ == '__main__':
    port = int(os.environ.get('PORT', 5000))
    print(f"Starting MentalCare AI Backend Server on port {port}...")
    app.run(host='0.0.0.0', port=port, debug=False)
