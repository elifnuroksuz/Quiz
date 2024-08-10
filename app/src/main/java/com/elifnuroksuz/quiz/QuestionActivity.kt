package com.elifnuroksuz.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuestionActivity : AppCompatActivity() {

    private var name: String? = null
    private var score: Int = 0
    private var currentPosition: Int = 1
    private var questionList: ArrayList<QuestionData>? = null
    private var selectedOption: Int = 0

    private lateinit var questionText: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var progressText: TextView
    private lateinit var opt1: TextView
    private lateinit var opt2: TextView
    private lateinit var opt3: TextView
    private lateinit var opt4: TextView
    private lateinit var submit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        name = intent.getStringExtra(setData.name)
        questionList = setData.getQuestion()

        questionText = findViewById(R.id.question_text)
        progressBar = findViewById(R.id.progress_bar)
        progressText = findViewById(R.id.progress_text)
        opt1 = findViewById(R.id.opt_1)
        opt2 = findViewById(R.id.opt_2)
        opt3 = findViewById(R.id.opt_3)
        opt4 = findViewById(R.id.opt_4)
        submit = findViewById(R.id.submit)

        setQuestion()

        opt1.setOnClickListener {
            selectedOptionStyle(opt1, 1)
        }
        opt2.setOnClickListener {
            selectedOptionStyle(opt2, 2)
        }
        opt3.setOnClickListener {
            selectedOptionStyle(opt3, 3)
        }
        opt4.setOnClickListener {
            selectedOptionStyle(opt4, 4)
        }

        submit.setOnClickListener {
            if (selectedOption != 0) {
                val question = questionList!![currentPosition - 1]
                if (selectedOption != question.correct_ans) {
                    setColor(selectedOption, R.drawable.wrong_question_option)
                } else {
                    score++
                }
                setColor(question.correct_ans, R.drawable.correct_question_option)

                if (currentPosition == questionList!!.size) {
                    submit.text = "FINISH"
                } else {
                    submit.text = "Go to Next"
                }
            } else {
                currentPosition++
                when {
                    currentPosition <= questionList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        val intent = Intent(this, Result::class.java)
                        intent.putExtra(setData.name, name)
                        intent.putExtra(setData.score, score.toString())
                        intent.putExtra("total size", questionList!!.size.toString())

                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectedOption = 0
        }
    }

    private fun setColor(opt: Int, color: Int) {
        when (opt) {
            1 -> opt1.background = ContextCompat.getDrawable(this, color)
            2 -> opt2.background = ContextCompat.getDrawable(this, color)
            3 -> opt3.background = ContextCompat.getDrawable(this, color)
            4 -> opt4.background = ContextCompat.getDrawable(this, color)
        }
    }

    private fun setQuestion() {
        val question = questionList!![currentPosition - 1]
        setOptionStyle()

        progressBar.progress = currentPosition
        progressBar.max = questionList!!.size
        progressText.text = "$currentPosition/${questionList!!.size}"
        questionText.text = question.question
        opt1.text = question.option_one
        opt2.text = question.option_two
        opt3.text = question.option_three
        opt4.text = question.option_four
    }

    private fun setOptionStyle() {
        val optionList = arrayListOf(opt1, opt2, opt3, opt4)
        for (op in optionList) {
            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this, R.drawable.question_option)
            op.typeface = Typeface.DEFAULT
        }
    }

    private fun selectedOptionStyle(view: TextView, opt: Int) {
        setOptionStyle()
        selectedOption = opt
        view.background = ContextCompat.getDrawable(this, R.drawable.select_question_option)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}
