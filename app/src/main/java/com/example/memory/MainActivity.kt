package com.example.memory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val listImageOchirYopiq = arrayOf(false, false, false, false, false, false,false, false, false, false, false, false)
    val imageIndex = arrayOfNulls<Int>(2)
    val rasmId = arrayOfNulls<Int>(2)
    var ochiqRasm = 0
    var animationDoing = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        image_1.setOnClickListener {
            imageClick(image_1, R.drawable.kotlin, 0)
        }
        image_2.setOnClickListener {
            imageClick(image_2, R.drawable.java, 1)
        }
        image_3.setOnClickListener {
            imageClick(image_3, R.drawable.cplus, 2)
        }
        image_4.setOnClickListener {
            imageClick(image_4, R.drawable.kotlin, 3)
        }
        image_5.setOnClickListener {
            imageClick(image_5, R.drawable.java, 4)
        }
        image_6.setOnClickListener {
            imageClick(image_6, R.drawable.cplus, 5)
        }

        image_7.setOnClickListener {
            imageClick(image_7,R.drawable.cshart,6)
        }
        image_8.setOnClickListener {
            imageClick(image_8,R.drawable.python_logo,7)
        }
        image_9.setOnClickListener {
            imageClick(image_9,R.drawable.js_logo,8)
        }
        image_10.setOnClickListener {
            imageClick(image_10,R.drawable.cshart,9)
        }
        image_11.setOnClickListener {
            imageClick(image_11,R.drawable.js_logo,10)
        }
        image_12.setOnClickListener {
            imageClick(image_12,R.drawable.python_logo,11)
        }

    }




    fun imageClick(imageView: ImageView, rasm: Int, index: Int) {
        if (!animationDoing) {
            if (listImageOchirYopiq[index] == false) {
                animationOchilish(imageView, rasm, index)
            } else {
                animationYopilish(imageView, rasm, index)
            }
        }
    }

    fun animationOchilish(imageView: ImageView, rasm: Int, index: Int) {
        val animation1 = AnimationUtils.loadAnimation(this, R.anim.anim_1)
        imageView.startAnimation(animation1)
        animation1.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                val animation2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim_2)
                imageView.startAnimation(animation2)
                imageView.setImageResource(rasm)
                animation2.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        listImageOchirYopiq[index] = true
                        //ozgarish
                        imageIndex[ochiqRasm] = index
                        rasmId[ochiqRasm] = rasm
                        ochiqRasm++
                        if (ochiqRasm == 2) {
                            if (rasmId[0] == rasmId[1]) {
                                imageViewAniqla(imageIndex[0]).visibility = View.INVISIBLE
                                ochiqRasm--
                                imageViewAniqla(imageIndex[1]).visibility = View.INVISIBLE
                                ochiqRasm--
                                animationDoing = true
                            } else {
                                animationYopilish(imageViewAniqla(imageIndex[0]), -1, imageIndex[0])
                                animationYopilish(imageViewAniqla(imageIndex[1]), -1, imageIndex[1])
                            }
                        }
                        animationDoing = false
                    }

                    override fun onAnimationRepeat(animation: Animation?) {

                    }

                })
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })

    }


    fun animationYopilish(imageView: ImageView, rasm: Int, index: Int?) {
        val animation1 = AnimationUtils.loadAnimation(this, R.anim.anim_1)
        imageView.startAnimation(animation1)
        animation1.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                animationDoing = false
            }

            override fun onAnimationEnd(animation: Animation?) {
                val animation2 = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim_2)
                imageView.startAnimation(animation2)
                imageView.setImageResource(R.drawable.qalqon_back)
                animation2.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        animationDoing = false
                    }

                    override fun onAnimationRepeat(animation: Animation?) {

                    }

                })
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })
        listImageOchirYopiq[index!!] = false
        ochiqRasm--
    }

    fun imageViewAniqla(index: Int?): ImageView {
        var imageView: ImageView? = null
        when (index) {
            0 -> imageView = image_1
            1 -> imageView = image_2
            2 -> imageView = image_3
            3 -> imageView = image_4
            4 -> imageView = image_5
            5 -> imageView = image_6
            6 -> imageView = image_7
            7 -> imageView = image_8
            8 -> imageView = image_9
            9 -> imageView = image_10
            10 -> imageView = image_11
            11 -> imageView = image_12

        }
        return imageView!!
    }

}