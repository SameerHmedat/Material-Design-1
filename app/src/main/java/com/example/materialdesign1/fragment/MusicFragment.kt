package com.example.materialdesign1.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.materialdesign1.R
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_music.*

class MusicFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_music, container, false)

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        check_all.setOnClickListener{
            LinearView.visibility=View.VISIBLE
            //childFragmentManager
        }
        un_check_all.setOnClickListener{
            LinearView.visibility=View.INVISIBLE
        }

        firstMusic.setOnCheckedChangeListener { _, isChecked->
            if(isChecked){
                linkFirstMusic.visibility=View.VISIBLE
                linkFirstMusic.text="https://youtu.be/0K5vcO5uiGo"
            }
            else{linkFirstMusic.visibility=View.GONE }
        }

        linkFirstMusic.setOnClickListener{
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(linkFirstMusic.text.toString())
            startActivity(openURL)
        }

         secondMusic.setOnCheckedChangeListener { _, isChecked->
            if(isChecked){
                linkSecondMusic.visibility=View.VISIBLE
                linkSecondMusic.text="https://www.youtube.com/watch?v=w6DukrYK5wQ"
            }
            else{linkSecondMusic.visibility=View.GONE }
        }

        linkSecondMusic.setOnClickListener{
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(linkSecondMusic.text.toString())
            startActivity(openURL)
        }

         thirdMusic.setOnCheckedChangeListener { _, isChecked->
            if(isChecked){
                linkThirdMusic.visibility=View.VISIBLE
                linkThirdMusic.text="https://youtu.be/W9slkIAqKcU"
            }
            else{linkThirdMusic.visibility=View.GONE }
        }

        linkThirdMusic.setOnClickListener{
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(linkThirdMusic.text.toString())
            startActivity(openURL)
        }

         fourthMusic.setOnCheckedChangeListener { _, isChecked->
            if(isChecked){
                linkFourthMusic.visibility=View.VISIBLE
                linkFourthMusic.text="https://youtu.be/HhjHYkPQ8F0"
            }
            else{linkFourthMusic.visibility=View.GONE }
        }

        linkFourthMusic.setOnClickListener{
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(linkFourthMusic.text.toString())
            startActivity(openURL)
        }

         fifthMusic.setOnCheckedChangeListener { _, isChecked->
            if(isChecked){
                linkFifthMusic.visibility=View.VISIBLE
                linkFifthMusic.text="https://youtu.be/YaEG2aWJnZ8"
            }
            else{linkFifthMusic.visibility=View.GONE }
        }

        linkFifthMusic.setOnClickListener{
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(linkFifthMusic.text.toString())
            startActivity(openURL)
        }


         sixthMusic.setOnCheckedChangeListener { _, isChecked->
            if(isChecked){
                linkSixthMusic.visibility=View.VISIBLE
                linkSixthMusic.text="https://youtu.be/1dr5Gvo-ZAs"
            }
            else{linkSixthMusic.visibility=View.GONE }
        }

        linkSixthMusic.setOnClickListener{
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(linkSixthMusic.text.toString())
            startActivity(openURL)
        }



    }
}