package com.example.guessnumber

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.guessnumber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var secretNumber = 0
        var lives = 0

        binding.start.setOnClickListener {

            lives = 5
            binding.lives.text = "$lives"
            binding.start.setImageResource(R.drawable.startpic)
            binding.lives.visibility = View.VISIBLE
            binding.input.visibility = View.VISIBLE
            binding.guess.visibility = View.VISIBLE
            binding.message2.visibility = View.VISIBLE
            binding.start.isClickable = false
            binding.message.setText(R.string.play_message)
            binding.showNumber.visibility = View.INVISIBLE
            binding.message3.visibility = View.INVISIBLE

            secretNumber = (1..10).random()



        }

        binding.guess.setOnClickListener{
            val enteredText = binding.input.text.toString()
            val enteredNumber = enteredText.toIntOrNull()
            if((enteredNumber==null)||(enteredNumber<1)||(enteredNumber>10))
            {
                binding.message.setText(R.string.error_message)
            }
            else
            {
                if(enteredNumber==secretNumber)
                {
                    binding.message.setText(R.string.won_message)
                    binding.start.setImageResource(R.drawable.winpic)
                    binding.showNumber.text = "$secretNumber"
                    binding.showNumber.visibility = View.VISIBLE
                    binding.message3.visibility = View.VISIBLE
                    binding.lives.visibility = View.INVISIBLE
                    binding.message2.visibility = View.INVISIBLE
                    binding.input.visibility = View.INVISIBLE
                    binding.guess.visibility = View.INVISIBLE
                    binding.start.isClickable = true
                }
                else
                {
                    binding.message.setText(R.string.wrong_message)
                    binding.start.setImageResource(R.drawable.wrongpic)
                    lives--
                    binding.lives.text = "$lives"
                    if(lives == 0)
                    {
                        binding.start.setImageResource(R.drawable.losepic)
                        binding.lives.visibility = View.INVISIBLE
                        binding.message2.visibility = View.INVISIBLE
                        binding.input.visibility = View.INVISIBLE
                        binding.guess.visibility = View.INVISIBLE
                        binding.start.isClickable = true
                        binding.message.setText(R.string.game_over)
                        binding.showNumber.text = "$secretNumber"
                        binding.message3.visibility = View.VISIBLE
                        binding.showNumber.visibility = View.VISIBLE
                    }
                }
            }

        }



    }
}