package com.example.materialdesign1.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialdesign1.R
import kotlinx.android.synthetic.main.fragment_painter.*
import java.text.NumberFormat


@Suppress("DEPRECATION")
class PainterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_painter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        slider.setLabelFormatter { value: Float ->
            val format = NumberFormat.getInstance()
            //  val format = NumberFormat.getCurrencyInstance()
            format.maximumFractionDigits = 0
            //format.currency = Currency.getInstance("USD")
            val newValue = format.format(value.toDouble()).toString()
            valueNow.text = newValue

            val compareValue = newValue.toInt()
            changeColor(compareValue)


            format.format(value.toDouble())
        }
        slider.addOnChangeListener { slider, value, fromUser ->
            //valueNow.text=value.toInt().toString()

            Log.d("Slider is ", value.toInt().toString())
        }

//        val checkedRadioButtonId =
//            radioGroup.checkedRadioButtonId // Returns View.NO_ID if nothing is checked.
//        radioGroup.setOnCheckedChangeListener { group, checkedId ->
//            when (checkedId) {
//                R.id.radio_button_1 ->
//                    AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
//
//                R.id.radio_button_2 ->
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//
//                R.id.radio_button_3 ->
//                    AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM)
//
//            }

    }

    private fun changeColor(compareValue: Int) {
        when (compareValue) {
            0 -> {
                LinearLayoutChangingColor.setBackgroundColor(resources.getColor(R.color.materialPrimaryColor))
            }
            10 -> {
                LinearLayoutChangingColor.setBackgroundColor(resources.getColor(R.color.tomato))
            }
            20 -> {
                LinearLayoutChangingColor.setBackgroundColor(resources.getColor(R.color.gold))
            }
            30 -> {
                LinearLayoutChangingColor.setBackgroundColor(resources.getColor(R.color.deeppink))
            }
            40 -> {
                LinearLayoutChangingColor.setBackgroundColor(resources.getColor(R.color.burlywood))
            }
            50 -> {
                LinearLayoutChangingColor.setBackgroundColor(resources.getColor(R.color.plum))
            }
            60 -> {
                LinearLayoutChangingColor.setBackgroundColor(resources.getColor(R.color.olivedrab))
            }
            70 -> {
                LinearLayoutChangingColor.setBackgroundColor(resources.getColor(R.color.Red))
            }
            80 -> {
                LinearLayoutChangingColor.setBackgroundColor(resources.getColor(R.color.dimgray))
            }
            90 -> {
                LinearLayoutChangingColor.setBackgroundColor(resources.getColor(R.color.mediumaquamarine))
            }
            100 -> {
                LinearLayoutChangingColor.setBackgroundColor(resources.getColor(R.color.sky))
            }
            else -> {
                LinearLayoutChangingColor.setBackgroundColor(resources.getColor(R.color.materialPrimaryColor))
            }
        }
    }
}

