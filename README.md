# MentalCare AI – Real-Time AI-Powered Stress & Burnout Detector

> *"Understand. Relax. Thrive."*

---

## 👥 Academic Project Information & Team Members
* **Project Name:** MentalCare AI
* **Full Title:** AI MentalCare – Real-Time AI-Powered Stress & Burnout Detection Mobile Application
* **Course:** Mobile Application Development (MCA) – Continuous Assessment (CA1 & CA3)
* **Department:** Department of Master of Computer Applications (MCA)
* **Institution:** Jain (Deemed-to-be University)
* **Group:** Group 11
* **Team Members:**
  1. **Joylyn Princita Fernandes** – USN: `25MCAR0099`
  2. **Syed Faizan Pasha** – USN: `25MCAR0138`
  3. **Vishwajeet Singh** – USN: `25MCAR0219`

---

## ℹ️ Important Wellness Disclaimer & Responsible AI
**MentalCare AI** is engineered strictly as an **assistive wellness and early-warning support application**, not a clinical medical diagnostic tool. It does NOT diagnose clinical depression, anxiety disorders, PTSD, or psychiatric illnesses. The AI estimates stress trends to encourage mindful lifestyle balance, stress awareness, healthy habits, and timely referral to trusted friends or qualified healthcare professionals.

---

## 🌟 Major Features (Comprehensive Master Implementation)

### 1. 🚀 Personalized Onboarding Flow (8 Screens)
* Multi-step structured onboarding storing user preferences per account:
  * **Screen 1 — Welcome:** *"Understand. Relax. Thrive."* with `[Get Started]` and `[I Already Have an Account]`.
  * **Screen 2 — Personalization:** Preferred name, age range (18-24, 25-34, 35-44, 45+), occupation (Student, Working, Other).
  * **Screen 3 — Wellness Goals:** Multi-select chips (Understand stress, Improve focus, Productivity, Sleep better, Feel calmer, Healthier relationships, Motivation, Manage pressure, Healthy habits, Balance + custom goal).
  * **Screen 4 — Current Challenges:** Multi-select chips (Academic pressure, Work pressure, Deadlines, Relationships, Financial, Sleep problems, Overthinking, Focus, Social media, Procrastination, Feeling overwhelmed).
  * **Screen 5 — Habits to Improve:** Sleep, Exercise, Screen time, Relaxation, Morning routine, Time management, Study pacing.
  * **Screen 6 — Sleep Wellbeing:** Selectable patterns (Restorative sleep, Waking tired, Waking during night, Racing mind, Irregular schedule).
  * **Screen 7 — Daily Commitment:** 5 min, 10 min, 15 min, 20+ min per day.
  * **Screen 8 — Generated Personalized Plan:** Tailored daily wellness routine automatically generated from user selections and seeded into Room DB.
* Smart Routing: Returning users skip directly to the Home Dashboard without repeating onboarding.

### 2. 📋 Daily 10-Question Check-in Questionnaire
* Structured 10-question wellness check-in:
  1. Energy level today (1–5 scale)
  2. Overthinking frequency (1–5 scale)
  3. Distraction / concentration level (1–5 scale)
  4. Emotional balance / mood changes (1–5 scale)
  5. Overall feeling overwhelmed (1–5 scale)
  6. Ease of expressing emotions (1–5 scale)
  7. Decision-making clarity (1–5 scale)
  8. Motivation level (1–5 scale)
  9. Productivity output (1–5 scale)
  10. Sleep quality last night (1–5 scale)
* Real-time progress indicator (`Question X of 10`), interactive rating buttons with emoji cues, and immediate stress score calculation.
* Automatically updates today's Daily Plan and consistency streaks upon completion.

### 3. ✍️ Wellness Journal with Optional AI Analysis
* Dedicated private journal section:
  * Create, edit, search, and delete entries.
  * Date/time stamps and mood tag chips (🌿 Calm, 😊 Happy, 😐 Neutral, 😟 Stressed, 😴 Tired).
  * **[✨ Analyze with AI]:** Explicit user-triggered AI analysis using the NLP model to estimate stress level (LOW/MODERATE/HIGH) and actionable wellness recommendations without diagnostic claims.
  * User data isolation ensures private reflections remain strictly per-user.

### 4. 🧠 NLP Stress & Burnout AI Models (Preserved Pipeline)
* Python Machine Learning pipeline:
  * TF-IDF feature extraction with Logistic Regression / Linear SVM trained model (`stress_pipeline_model.joblib`).
  * Classifies input into LOW, MODERATE, HIGH stress levels with confidence scores and indicator extraction.
  * On-device Kotlin NLP engine (`LocalNLPEngine.kt`) guarantees offline continuity without server dependency.

### 5. 💡 Personalized Insights & Real Consistency Streaks
* Strictly backed by real Room SQLite data—**Zero Fabricated Statistics**:
  * **Consistency Streaks:** Consecutive days check-in streak calculation from actual timestamps (e.g. `3 Day Streak`).
  * Total check-ins logged and journal entries count.
  * Recent stress trend (Improving, Stable, Increasing) based on historical scores.
  * Sleep & energy patterns derived from lifestyle records.
  * If insufficient data exists, shows: *"Complete more check-ins to unlock personalized insights."*

### 6. 📈 Custom Canvas Stress Trend Curve
* Custom Android Canvas view (`StressChartView`):
  * Renders real historical stress scores across days with dynamic bezier curves and day/night contrast.
  * 7-day average percentage calculation.
  * Multi-day burnout risk pattern detector with automatic notification alerts.

### 7. 🎯 Wellness Goals
* Goal management interface:
  * Add goal with custom description and category (Sleep, Focus, Mindfulness, Habits, Routine).
  * Mark goals complete with strike-through feedback.
  * Active vs completed goals counter.
  * Delete goals with confirmation prompt.

### 8. 🗓️ Today's Wellness Plan
* Structured daily wellness checklist:
  * 1. Complete mental check-in
  * 2. 5-minute breathing activity
  * 3. Write one journal entry
  * 4. Take a short break
  * 5. Complete evening reflection
* Progress tracker: `X / 5 completed` with auto-check on database events.

### 9. ✨ Wellness Activities Catalog (8 Categories)
* Catalog of evidence-informed exercises:
  1. **Breathing:** 5-Minute Box Breathing
  2. **Relaxation:** 5-4-3-2-1 Sensory Grounding
  3. **Focus:** 25-Minute Pomodoro Focus Block
  4. **Journaling:** Reflective Gratitude Journal
  5. **Sleep Routine:** Evening Screen Wind-down
  6. **Mindfulness:** Gentle Body Scan Meditation
  7. **Productivity:** Top-3 Priority Task Triage
  8. **Healthy Habits:** Hydration & Posture Reset
* Interactive countdown timer modal with start, pause, and completion tracking.

### 10. 💬 Context-Aware AI Chatbot (Multi-Turn Conversational Assistant)
* **Real Conversational AI Architecture:**
  * Multi-turn conversation memory with context sliding window.
  * Understands context across turns:
    * Exam stress -> Exams tomorrow -> Mathematics preparation (Test 1).
    * Sleep difficulty -> Happens almost every night (Test 2).
    * Study plan requests with Pomodoro breakdown (Test 3).
    * 5-minute relaxation requests with guided breathwork (Test 4).
  * `[+ New Chat]` button creates a fresh conversation ID without mixing previous context.
  * `[History]` drawer allows reopening past conversation threads.
  * Typing indicator (*"AI is thinking..."*).
  * **Crisis Safety Guardrails:** Immediately detects self-harm ideation, flags `is_crisis = True`, provides compassionate de-escalation, recommends the 988 Crisis Lifeline, and displays a **`[📞 Call Emergency Contact]`** button with explicit confirmation before dialing.
  * **Medical Boundary Enforcement:** Disclaims clinical authority and refers to licensed doctors.
  * Dual-Engine Execution: Native support for Google Gemini API (`GEMINI_API_KEY`) and OpenAI (`OPENAI_API_KEY`) on the backend, plus intelligent contextual stateful dialog manager when operating locally, and on-device `LocalChatEngine.kt` when offline.

### 11. 👥 Emergency Contacts & 🆘 SOS Settings
* User-isolated emergency contacts list (Name, Phone, Relationship).
* Safe calling protocol: confirmation dialogs before initiating phone calls or deleting contacts.
* Editable SOS number with phone number validation.

### 12. 🌓 Complete Light / Dark / System Theme Switching
* High-contrast day/night switching across all activities and fragments.
* Persistent theme storage in `MentalCarePrefs`.

---

## 🌐 External AI Provider Configuration (Part 26)

If an external AI provider (such as Google Gemini) is used:

1. **AI Provider:** **Google Gemini API** (Recommended: model `gemini-1.5-flash`).
2. **Where to Create Key:** Google AI Studio: [https://aistudio.google.com/app/apikey](https://aistudio.google.com/app/apikey)
3. **Where to Place Key:** On your backend server only in:
   `backend_server/.env`
   ```env
   GEMINI_API_KEY=AIzaSyYourActualKeyHere
   ```
4. **Environment Variable:** `GEMINI_API_KEY` (or `OPENAI_API_KEY`).
5. **How to Test:**
   ```powershell
   py backend_server/test_chat.py
   ```
*Security Guarantee:* The API key is **never** embedded inside the Android application. Android communicates exclusively with the backend via `POST /chat`.

---

## 📸 Demonstration Screenshots Catalog

| Screen # | Screen Title | Filename | Key Visual Elements Shown |
|:---:|:---|:---|:---|
| **01** | Welcome & Onboarding | `01_onboarding_welcome.png` | MentalCare AI logo, slogan *"Understand. Relax. Thrive."*, Get Started |
| **02** | Personalization | `02_onboarding_personalize.png` | Name, age range chips, student/working role selection |
| **03** | Wellness Goals | `03_onboarding_goals.png` | Multi-select goals chips and custom goal input |
| **04** | Challenges & Sleep | `04_onboarding_challenges.png` | Academic pressure, deadlines, sleep pattern selector |
| **05** | Generated Plan | `05_onboarding_plan.png` | Tailored daily routine generated from user answers |
| **06** | Home Dashboard | `06_home_dashboard.png` | Greeting, mood selector, AI Check-in, Chat, Insights, Today's Plan, Goals |
| **07** | Daily 10-Q Check-in | `07_daily_checkin_flow.png` | 10 wellness questions with 1-5 scale, progress counter, emojis |
| **08** | Check-in Result | `08_checkin_result.png` | Stress level badge (LOW/MODERATE/HIGH), score, recommendations |
| **09** | Wellness Journal | `09_wellness_journal.png` | List of entries, mood tags, search bar, + New Entry dialog |
| **10** | Journal AI Analysis | `10_journal_ai_analysis.png` | [Analyze with AI] result badge with estimated stress & advice |
| **11** | Insights & Streaks | `11_insights_streaks.png` | Real check-in streak, total counts, personalized trend insights |
| **12** | Stress Trend Chart | `12_stress_trend_chart.png` | Custom canvas curve, 7-day average, burnout risk detector |
| **13** | Today's Plan | `13_todays_plan.png` | 5 daily tasks checklist, completion counter (e.g. 3/5 completed) |
| **14** | Wellness Activities | `14_wellness_activities.png` | 8 exercise categories with countdown timer modal |
| **15** | AI Wellness Chatbot | `15_ai_chatbot_dialog.png` | Multi-turn conversational flow, user/AI bubbles, typing indicator |
| **16** | Chat Crisis Safety | `16_chat_crisis_safety.png` | 988 lifeline, de-escalation response, [Call Emergency Contact] button |
| **17** | Emergency Contacts | `17_emergency_contacts.png` | Contact list per user, safe call confirmation prompt |
| **18** | Settings & Themes | `18_settings_screen.png` | Light / Dark / System mode toggle, Account, Safety, About |

---

## 🚀 How to Run the Project

### 1. Launch Android Application in Android Studio
1. Open **Android Studio**.
2. Click **Open** and select:
   `C:\Users\admin\.gemini\antigravity\scratch\AIMentalCare\AIMentalCareApp`
3. Connect an Android Emulator or device.
4. Press **Run (Shift + F10)**.

### 2. Start Python AI Backend REST API
In a PowerShell or Command Prompt terminal:
```powershell
cd C:\Users\admin\.gemini\antigravity\scratch\AIMentalCare\backend_server
py app.py
```
*(Server listens on port 5000: `http://localhost:5000/`)*

### 3. Run Automated Multi-Turn Chatbot Tests
```powershell
cd C:\Users\admin\.gemini\antigravity\scratch\AIMentalCare\backend_server
py test_chat.py
```
