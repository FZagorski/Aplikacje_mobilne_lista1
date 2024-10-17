package com.example.zad1_zagorski

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private val quizData = Answers()

    private var questionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val questionTextView: TextView = findViewById(R.id.questionTextView)
        val answersRadioGroup: RadioGroup = findViewById(R.id.answersRadioGroup)
        val answer1: RadioButton = findViewById(R.id.answer1)
        val answer2: RadioButton = findViewById(R.id.answer2)
        val answer3: RadioButton = findViewById(R.id.answer3)
        val answer4: RadioButton = findViewById(R.id.answer4)
        val nextQuestionButton: Button = findViewById(R.id.nextQuestionButton)
        val questionCounterTextView: TextView = findViewById(R.id.questionCounter)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)


        progressBar.max = quizData.questions.size
        progressBar.progress = questionIndex + 1

        fun loadQuestion() {
            val question = quizData.questions[questionIndex]
            val answers = quizData.answersArray[questionIndex]

            questionTextView.text = question
            answer1.text = answers[0]
            answer2.text = answers[1]
            answer3.text = answers[2]
            answer4.text = answers[3]

            questionCounterTextView.text = "Pytanie ${questionIndex + 1}/${quizData.questions.size}"
            progressBar.progress = questionIndex + 1
            answersRadioGroup.clearCheck()
        }

        loadQuestion()
        nextQuestionButton.setOnClickListener {
            val selectedId = answersRadioGroup.checkedRadioButtonId
            if (selectedId != -1) {
                val selectedAnswer: RadioButton = findViewById(selectedId)
                if (selectedAnswer.text == quizData.correctAnswers[questionIndex]) {
                    score++
                }
                questionIndex++
                if (questionIndex < quizData.questions.size) {
                    loadQuestion()
                }
                else{
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
                }
            } else {
                Toast.makeText(this, "Proszę wybrać odpowiedź", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
