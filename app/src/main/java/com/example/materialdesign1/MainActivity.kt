package com.example.materialdesign1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.BaseTransientBottomBar.ANIMATION_MODE_SLIDE
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        img_date.setOnClickListener {
            // val picker= MaterialDatePicker.Builder.dateRangePicker()
            val picker = MaterialDatePicker.Builder.datePicker()
                //.setSelection( Pair( MaterialDatePicker.thisMonthInUtcMilliseconds(),MaterialDatePicker.todayInUtcMilliseconds()))
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .setNegativeButtonText("Cancel").setPositiveButtonText("ok")
                .setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
                .setTitleText("Select your favorite date please")
                .build()

            picker.show(supportFragmentManager, "tag")
            picker.addOnPositiveButtonClickListener {
                txtName.text = "Favorite date is " + picker.headerText.toString()
            }
        }

        MainFloatingAction.setOnClickListener {
            val snackbar = Snackbar.make(MainLayout, "Snackbar Over BottomAppBar", Snackbar.LENGTH_SHORT)
            snackbar.setTextColor(getColor(R.color.white))
            snackbar.animationMode = ANIMATION_MODE_SLIDE
            snackbar.anchorView=it
            snackbar.show()
        }



            val bottomSheetBehavior = BottomSheetBehavior.from(navigationView)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN


            bottomAppBar.setNavigationOnClickListener {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }

            navigationView.setNavigationItemSelectedListener { menuItem ->
                // Handle menu item selected
                menuItem.isChecked = true
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
                true
            }

            scrim.setOnClickListener {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            }


        bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search -> {
                    // Handle search icon press
                    startActivity(Intent(this, SecondActivity::class.java))
                    true
                }
                R.id.travel -> {
                    startActivity(Intent(this@MainActivity,TabActivity::class.java))

                    // Handle more item (inside overflow menu) press
                    true
                }
                else -> false
            }
        }



        val items = listOf(
            "happiness",
            "love",
            "relief",
            "contentment",
            "amusement",
            "joy",
            "pride",
            "excitement",
            "peace",
            "satisfaction"
        )

        adapter = ArrayAdapter(this, R.layout.dropdown_item, items)
        AutoText.setAdapter(adapter)

        AutoText.setOnItemClickListener { _: AdapterView<*>, _: View, i: Int, _: Long ->
            Toast.makeText(this, items[i], Toast.LENGTH_SHORT).show()
        }


        TextInputEditTextUserName.doOnTextChanged { text, _, _, _ ->
            if (text!!.length > 9) {
                TextInputLayoutUserName.error = "No More !!!"
            } else {
                TextInputLayoutUserName.error = null
            }
        }

    }
}
