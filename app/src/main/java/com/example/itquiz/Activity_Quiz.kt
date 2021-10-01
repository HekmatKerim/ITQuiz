package com.example.itquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class Activity_Quiz : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition:Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        mUserName = intent.getStringExtra(Constans.USER_NAME)

        mQuestionList = Constans.getQuestions()

        setQuestion()

        var optionOne = findViewById<TextView>(R.id.tv_option_one)
        var optionTwo = findViewById<TextView>(R.id.tv_option_two)
        var optionThree = findViewById<TextView>(R.id.tv_option_three)
        var btn_submit = findViewById<Button>(R.id.btn_submit)

        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion(){

        defaultOptionView()

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val tv_progress = findViewById<TextView>(R.id.tv_progress)
        val tv_question = findViewById<TextView>(R.id.tv_question)
        val optionOne = findViewById<TextView>(R.id.tv_option_one)
        val optionTwo = findViewById<TextView>(R.id.tv_option_two)
        val optionThree = findViewById<TextView>(R.id.tv_option_three)
        val btn_submit = findViewById<Button>(R.id.btn_submit)

        val question = mQuestionList!![mCurrentPosition -1]

        defaultOptionView()
        if (mCurrentPosition == mQuestionList!!.size){
            btn_submit.text = "Finish"
        }else{
            btn_submit.text = "Submit"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max
        tv_question.text = question!!.question
        optionOne.text = question.optionone
        optionTwo.text = question.optiontwo
        optionThree.text = question.optionthree

    }

    private fun defaultOptionView(){

        val optionOne = findViewById<TextView>(R.id.tv_option_one)
        val optionTwo = findViewById<TextView>(R.id.tv_option_two)
        val optionThree = findViewById<TextView>(R.id.tv_option_three)

        val options = ArrayList<TextView>()
        options.add(0, optionOne)
        options.add(1, optionTwo)
        options.add(2, optionThree)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.defalut_option_border_bg
            )
        }


    }

    override fun onClick(v: View?) {
        var optionOne = findViewById<TextView>(R.id.tv_option_one)
        var optionTwo = findViewById<TextView>(R.id.tv_option_two)
        var optionThree = findViewById<TextView>(R.id.tv_option_three)
        var btn_submit = findViewById<Button>(R.id.btn_submit)


        when(v?.id){
            R.id.tv_option_one ->{
                selectedOptionView(optionOne,1)
            }
            R.id.tv_option_two ->{
                selectedOptionView(optionTwo,2)
            }
            R.id.tv_option_three ->{
                selectedOptionView(optionThree,3)
            }
            R.id.btn_submit ->{
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                    when{mCurrentPosition <= mQuestionList!!.size -> {
                        setQuestion()
                        }else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constans.USER_NAME, mUserName)
                            intent.putExtra(Constans.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constans.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    if (question!!.correctanswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.incorrect_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctanswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size){
                        btn_submit.text = "Finish!"
                    }else{
                        btn_submit.text = "Go to next Question"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }

    }

    private fun answerView(answer: Int, drawableView: Int){
        val optionOne = findViewById<TextView>(R.id.tv_option_one)
        val optionTwo = findViewById<TextView>(R.id.tv_option_two)
        val optionThree = findViewById<TextView>(R.id.tv_option_three)
        when(answer){
            1 -> {
                optionOne.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                optionTwo.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                optionThree.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int){

        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNumber
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }

}
