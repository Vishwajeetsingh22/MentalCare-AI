# 🧠 MentalCare AI

## AI-Powered Stress & Burnout Detection Mobile Application

> **Understand. Relax. Thrive.**

MentalCare AI is an AI-powered mobile wellness application developed as an academic project to help users understand and monitor their stress levels through AI-assisted mental check-ins and journal entries.

The application uses **Natural Language Processing (NLP)** and **Machine Learning (ML)** to analyze user-provided text and classify the estimated stress level as **Low, Moderate, or High**. It also maintains stress history, analyzes trends, and provides wellness recommendations.

> ⚠️ **Disclaimer:** MentalCare AI is a wellness and early-warning support application. It is not a medical diagnostic system and should not replace professional medical, psychological, or emergency assistance.

---

## 📌 Project Information

| Detail | Information |
|---|---|
| **Project Name** | MentalCare AI |
| **Project Title** | AI MentalCare – Real-Time AI-Powered Stress & Burnout Detection Mobile Application |
| **Group Number** | 11 |
| **Department** | Master of Computer Applications (MCA) |
| **College** | Jain (Deemed-to-be University) |
| **Campus** | JGI Knowledge Campus, Jayanagar, Bengaluru |

---

## 🎯 Aim

The aim of MentalCare AI is to develop a mobile wellness application that uses AI, NLP, and Machine Learning to analyze users' written mental check-ins and provide an estimated stress level with useful wellness recommendations.

---

## ❗ Problem Statement

Students, employees, and professionals can experience stress due to academic pressure, workload, deadlines, long working hours, lack of sleep, and personal responsibilities.

Users may not always notice that their stress is increasing over time. MentalCare AI provides a simple platform for recording daily check-ins and using AI-assisted analysis to identify possible increasing stress patterns.

---

## 💡 Proposed Solution

MentalCare AI combines:

- 📱 Android mobile application
- 🤖 Artificial Intelligence
- 🧠 Natural Language Processing
- 📊 Machine Learning
- ☁️ Firebase
- 🔗 REST API
- 🔔 Notifications
- 📈 Stress history and trend analysis
- 💡 Wellness recommendations

### Basic Flow

```text
User Check-in
      ↓
Journal / Text Input
      ↓
REST API
      ↓
NLP Processing
      ↓
Machine Learning Model
      ↓
Stress Classification
      ↓
Low / Moderate / High
      ↓
Firebase
      ↓
History + Trend + Recommendation
```

---

# ✨ Key Features

### 🔐 User Authentication
- User registration
- User login
- Logout
- Firebase authentication

### 🏠 Home Dashboard
- Latest stress information
- Recent check-ins
- Quick access to AI check-in
- Recommendations
- Notifications

### 🧠 AI Mental Check-in
Users can enter their thoughts, feelings, or daily experiences.

### 🤖 AI Stress Analysis
The backend analyzes the submitted text using NLP and Machine Learning.

### 📊 Stress Classification

```text
🟢 Low
🟠 Moderate
🔴 High
```

### 📈 Stress History
Stores previous stress assessments and check-ins.

### 📉 Stress Trend
Tracks stress levels over multiple days and can identify increasing patterns.

### ⚠️ Increasing Stress Pattern
The application can display an early-warning message when stress indicators show a sustained increasing pattern.

### 💡 Personalized Recommendations
Provides general wellness suggestions based on the estimated stress level.

### 🔔 Notifications
Provides wellness reminders and relevant application notifications.

### 👤 Profile & Settings
Allows users to manage profile and application settings.

### 🆘 Trusted Support
Provides a section for trusted support/emergency contact information.

### 📱 Responsive UI
Designed for different Android screen sizes with flexible layouts and readable components.

---

# 🔄 Application Workflow

```text
Launch Application
        ↓
Splash Screen
        ↓
Login / Registration
        ↓
Home Dashboard
        ↓
AI Mental Check-in
        ↓
Enter Journal / Feelings
        ↓
Submit for Analysis
        ↓
AI / NLP Processing
        ↓
Stress Prediction
        ↓
Low / Moderate / High
        ↓
Save Result
        ↓
Stress History
        ↓
Trend Analysis
        ↓
Wellness Recommendation
        ↓
Notification / Support
```

---

# 🏗️ System Architecture

```text
┌─────────────────────────────────────┐
│          Android Application        │
│                                     │
│       Kotlin + XML + Material       │
│                                     │
│ Login | Dashboard | Check-in        │
│ Result | History | Profile          │
└──────────────────┬──────────────────┘
                   │
                   │ HTTPS REST API
                   ▼
┌─────────────────────────────────────┐
│          Python Backend             │
│          Flask / FastAPI            │
│                                     │
│ API Handling | Validation           │
│ NLP Processing | ML Prediction      │
└──────────────────┬──────────────────┘
                   │
                   ▼
┌─────────────────────────────────────┐
│             AI / ML Layer           │
│                                     │
│ Text Preprocessing                  │
│ TF-IDF Feature Extraction           │
│ Machine Learning Model              │
│ Stress Classification               │
└──────────────────┬──────────────────┘
                   │
                   ▼
┌─────────────────────────────────────┐
│              Firebase               │
│                                     │
│ Authentication                      │
│ Firestore / Realtime Database       │
│ Cloud Messaging                     │
└─────────────────────────────────────┘
```

---

# 🤖 AI / ML Workflow

### 1. Text Input

The user enters a mental check-in.

Example:

```text
I have been working continuously for several days.
I am unable to sleep properly and I feel exhausted.
```

### 2. Text Preprocessing

The backend prepares the text for analysis using appropriate NLP preprocessing.

### 3. Feature Extraction

Text can be converted into numerical features using:

```text
TF-IDF
```

### 4. Machine Learning

A trained classification model analyzes the extracted features.

Possible models include:

```text
Logistic Regression
Support Vector Machine (SVM)
```

### 5. Prediction

The model returns an estimated stress category:

```text
Low
Moderate
High
```

### 6. Result

The result is returned to the Android application.

Example:

```json
{
  "stress_level": "High",
  "confidence": 0.87
}
```

---

# 🛠️ Technology Stack

## Frontend
- Android Studio
- Kotlin
- XML
- Material Design

## Backend
- Python
- Flask / FastAPI
- REST API

## AI / Machine Learning
- Natural Language Processing
- TF-IDF
- Scikit-learn
- Logistic Regression / SVM

## Cloud & Database
- Firebase Authentication
- Cloud Firestore / Realtime Database
- Firebase Cloud Messaging

## Development Tools
- Antigravity
- Git
- GitHub
- Android Studio

## Deployment
- Android APK / AAB
- Cloud-hosted Python backend
- Firebase

---

# 📱 Application Screens

The application includes:

1. Splash Screen
2. Login Screen
3. Registration Screen
4. Home Dashboard
5. AI Mental Check-in
6. Journal / Text Input
7. AI Analysis
8. Stress Result
9. Stress History
10. Stress Trend
11. Increasing Stress Pattern Warning
12. Personalized Recommendations
13. Notifications
14. Profile
15. Settings
16. Trusted Support

---

# 📸 Screenshots

> Place the actual application screenshots inside the `screenshots/` folder.  
> Replace the filenames below if your actual screenshot names are different.

## 1. Splash Screen

![Splash Screen](screenshots/splash.png)

## 2. Login Screen

![Login Screen](screenshots/login.png)

## 3. Registration Screen

![Registration Screen](screenshots/register.png)

## 4. Home Dashboard

![Home Dashboard](screenshots/dashboard.png)

## 5. AI Mental Check-in

![AI Mental Check-in](screenshots/checkin.png)

## 6. AI Analysis

![AI Analysis](screenshots/analysis.png)

## 7. Stress Result

![Stress Result](screenshots/stress-result.png)

## 8. Stress History

![Stress History](screenshots/history.png)

## 9. Stress Trend

![Stress Trend](screenshots/trend.png)

## 10. Recommendations

![Recommendations](screenshots/recommendations.png)

## 11. Notifications

![Notifications](screenshots/notifications.png)

## 12. Profile

![Profile](screenshots/profile.png)

---

# 🔥 Firebase Integration

Firebase can be used for:

### Authentication
- Registration
- Login
- User authentication
- Account management

### Database
- User information
- Mental check-ins
- Stress results
- Stress history
- Trend information

### Cloud Messaging
- Wellness reminders
- Application notifications
- Relevant alerts

---

# 🔗 Backend API

The Android application communicates with the Python backend through REST APIs.

## Health Check

```http
GET /health
```

Example response:

```json
{
  "status": "ok"
}
```

## Stress Prediction

```http
POST /predict
```

Example request:

```json
{
  "text": "I feel exhausted and stressed because of continuous work."
}
```

Example response:

```json
{
  "stress_level": "High",
  "confidence": 0.87
}
```

## Check-in

```http
POST /checkin
```

This endpoint can be used to process and store a user's check-in.

---

# 🚀 Installation

## Prerequisites

Install:

- Android Studio
- JDK
- Android SDK
- Git
- Python 3.x
- Firebase account

---

## 📥 Clone Repository

```bash
git clone https://github.com/Vishwajeetsingh22/MentalCare-AI.git
```

Navigate into the project:

```bash
cd MentalCare-AI
```

Open the project in Android Studio and allow Gradle synchronization to complete.

---

# 📱 Android Setup

1. Open Android Studio.
2. Select **Open Project**.
3. Select the `MentalCare-AI` directory.
4. Allow Gradle to sync.
5. Install required SDK components.
6. Connect an Android device or start an emulator.
7. Run the application.

---

# 🐍 Backend Setup

If the project contains a backend directory:

```bash
cd backend
```

Create a virtual environment:

```bash
python -m venv venv
```

For Windows:

```bash
venv\Scripts\activate
```

Install dependencies:

```bash
pip install -r requirements.txt
```

Run the backend:

```bash
python app.py
```

---

# ⚙️ Environment Configuration

Sensitive configuration should not be hard-coded.

Example:

```text
API_URL=
FIREBASE_PROJECT_ID=
FIREBASE_CLIENT_EMAIL=
FIREBASE_PRIVATE_KEY=
```

Use environment variables or secure configuration methods for sensitive values.

> Never upload private service-account keys, passwords, or secret credentials to GitHub.

---

# ☁️ Deployment

The intended deployment architecture is:

```text
Android Application
        ↓
      HTTPS
        ↓
Python AI Backend
        ↓
 NLP + ML Model
        ↓
     Firebase
        ↓
Authentication / Database / Notifications
```

### Android Application

Generate a release APK/AAB from Android Studio for demonstration and testing.

### AI Backend

The Python Flask/FastAPI backend can be deployed to a cloud hosting platform such as Render.

### Firebase

Firebase provides cloud services such as:

- Authentication
- Database
- Real-time synchronization
- Notifications

---

# 🧪 Testing

## Authentication
- [ ] Registration
- [ ] Login
- [ ] Logout
- [ ] Invalid credentials
- [ ] Authentication errors

## AI Check-in
- [ ] Text input
- [ ] Empty input
- [ ] Low stress example
- [ ] Moderate stress example
- [ ] High stress example
- [ ] Long input

## Backend
- [ ] API connection
- [ ] API response
- [ ] Invalid request
- [ ] Server unavailable
- [ ] Network timeout

## Firebase
- [ ] Authentication
- [ ] Data storage
- [ ] Data retrieval
- [ ] Real-time updates
- [ ] Notifications

## Application
- [ ] Navigation
- [ ] Back button
- [ ] Loading states
- [ ] Error states
- [ ] Responsive layouts
- [ ] Different Android screen sizes

---

# 🔒 Security

The project follows basic security practices:

- Do not hard-code passwords.
- Do not commit private API keys.
- Do not upload Firebase service-account private keys.
- Use environment variables for backend secrets.
- Validate API input.
- Use HTTPS for production API communication.
- Configure appropriate Firebase security rules.
- Store only necessary user information.

---

# ⚠️ Limitations

1. AI predictions depend on the quality of the training dataset.
2. Text-based analysis cannot completely understand a person's mental state.
3. Stress classification is an AI-based estimate.
4. The system does not provide a medical diagnosis.
5. Increasing-stress indicators are pattern-based and should not be treated as a clinical burnout assessment.
6. Cloud-based AI analysis may require internet connectivity.
7. Model performance may vary across writing styles and languages.

---

# 🔮 Future Enhancements

- 🎙️ Voice-based emotional analysis
- 😊 Advanced emotion detection
- 🌍 Multilingual support
- 💬 AI wellness chatbot
- ⌚ Wearable device integration
- ❤️ Heart-rate based stress indicators
- 🧠 Deep-learning models
- 📊 Advanced analytics dashboard
- 🔔 Personalized notifications
- 🧘 Personalized wellness plans
- 📱 Improved accessibility
- ☁️ Advanced cloud model management

---

# 📂 Project Structure

The exact structure may vary depending on the final implementation.

```text
MentalCare-AI/
│
├── app/
│   ├── src/
│   └── build.gradle
│
├── backend/
│   ├── app.py
│   ├── requirements.txt
│   ├── model/
│   └── ...
│
├── screenshots/
│   ├── splash.png
│   ├── login.png
│   ├── register.png
│   ├── dashboard.png
│   ├── checkin.png
│   ├── analysis.png
│   ├── stress-result.png
│   ├── history.png
│   ├── trend.png
│   ├── recommendations.png
│   ├── notifications.png
│   └── profile.png
│
├── .gitignore
├── README.md
└── ...
```

---

# 📋 Review 5 – Final Demonstration Flow

```text
Launch Application
        ↓
Login / Registration
        ↓
Home Dashboard
        ↓
AI Mental Check-in
        ↓
Enter Sample Text
        ↓
AI Analysis
        ↓
Show Stress Result
        ↓
Save Result
        ↓
Stress History
        ↓
Stress Trend
        ↓
Increasing Stress Pattern
        ↓
Recommendation
        ↓
Notification
        ↓
Profile / Settings
```

---

# 🎥 Final Demonstration

The final demonstration can cover:

- Android application
- User authentication
- AI mental check-in
- NLP/ML stress analysis
- Low / Moderate / High classification
- Stress history
- Stress trend
- Wellness recommendations
- Firebase integration
- Notifications
- Backend API
- Deployment
- Responsive UI

---

# 👨‍💻 Authors

## Group 11

### 1. Joylyn Princita Fernandes
**USN:** `25MCAR0099`

### 2. Syed Faizan Pasha
**USN:** `25MCAR0138`

### 3. Vishwajeet Singh
**USN:** `25MCAR0219`

---

# 🎓 College Information

**Jain (Deemed-to-be University)**  
**JGI Knowledge Campus, Jayanagar, Bengaluru**  
**Department of Master of Computer Applications (MCA)**

---

# 📚 Academic Information

**Course:** Mobile Application Development (MAD)  
**Project:** MentalCare AI  
**Group:** 11  
**Academic Year:** 2026  
**Project Type:** Academic / College Project

---

# 🔗 GitHub Repository

**MentalCare AI**

https://github.com/Vishwajeetsingh22/MentalCare-AI

---

# ⚖️ Disclaimer

MentalCare AI is developed as an academic project for educational and wellness-support purposes.

The application's AI-generated stress classification and recommendations are not medical advice and should not be considered a diagnosis of stress, anxiety, depression, burnout, or any other mental-health condition.

Users experiencing serious or emergency concerns should seek appropriate professional or emergency assistance.

---

# 📄 License

This project is developed for **academic and educational purposes**.

© 2026 MentalCare AI – Group 11
