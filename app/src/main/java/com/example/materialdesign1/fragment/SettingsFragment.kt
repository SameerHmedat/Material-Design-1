package com.example.materialdesign1.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.icu.util.Calendar
import android.os.Bundle
import android.provider.AlarmClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.fragment.app.Fragment
import com.example.materialdesign1.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.BaseTransientBottomBar.ANIMATION_MODE_FADE
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import kotlinx.android.synthetic.main.fragment_settings.*
import java.text.DateFormat
import java.text.SimpleDateFormat

@Suppress("DEPRECATION")
class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        FloatingActionAlarm.setOnClickListener {

            val picker =
                MaterialTimePicker.Builder()
                    .setTimeFormat(TimeFormat.CLOCK_24H)
                    .setHour(21)
                    .setMinute(10)
                    .setTitleText("Select Alarm time")
                    //.setInputMode(INPUT_MODE_KEYBOARD)
                    .build()
            fragmentManager?.let { it1 -> picker.show(it1, "tag") }
            picker.addOnNegativeButtonClickListener {
                if (txtTime.text == "") {
                    Snackbar.make(
                        SettingsLayoutFrag,
                        "Your alarm hasn't yet been set",
                        Snackbar.LENGTH_LONG
                    )
                        .setAction("Default") {
                            setTime()
                        }
                        .setAnimationMode(ANIMATION_MODE_FADE)
                        .setActionTextColor(resources.getColor(R.color.Red))
                        .setAnchorView(R.id.FloatingActionAlarm)
                        .show()

                    AlarmTextView.visibility=View.VISIBLE
                    AlarmImage.visibility=View.VISIBLE

                }


            }

            picker.addOnPositiveButtonClickListener {

                val minutes = if (picker.minute < 10) { "0" + picker.minute.toString() }
                              else { picker.minute.toString() }

                val hour = if (picker.hour==0) { "12" }
                           else { picker.hour.toString() }

                val selector = if (picker.hour < 12) { "AM" }
                               else { "PM" }
                txtTime.text = "$hour:$minutes $selector"

                val days = ArrayList<Int>()
                days.add(Calendar.SUNDAY)

                val intent=Intent(AlarmClock.ACTION_SET_ALARM)
                intent.putExtra(AlarmClock.EXTRA_HOUR,picker.hour)
                intent.putExtra(AlarmClock.EXTRA_MINUTES,picker.minute)
                intent.putExtra(AlarmClock.EXTRA_MESSAGE,"Alarm Android")
                intent.putExtra(AlarmClock.EXTRA_DAYS,days)
                startActivity(intent)

                AlarmTextView.visibility=View.VISIBLE
                AlarmImage.visibility=View.VISIBLE


            }
        }

        val isNightModeOn =
            Configuration.UI_MODE_NIGHT_YES == (context?.resources?.configuration?.uiMode?.and(
                Configuration.UI_MODE_NIGHT_MASK
            ))

        switchDarkMode.isChecked = isNightModeOn
        if (isNightModeOn) {
            switchDarkMode.text = "Dark Mode"
        } else {
            switchDarkMode.text = "Light Mode"
        }

        switchDarkMode.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
                switchDarkMode.text = "Dark Mode"
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                switchDarkMode.text = "Light Mode"
            }
        }


        val items = arrayOf("Android ", "Implementation ", "Design ")
        val checkedItem = booleanArrayOf(false, false, false)
        val checkedNames = ArrayList<String>()

        fun checkingResult(which: Int, checked: Boolean) {
            if (checked) {
                checkedNames.add(items[which])
            } else {
                checkedNames.remove(items[which])
            }
        }
        btnTitleDialog.setOnClickListener {
            checkedNames.clear()
            context?.let {
                MaterialAlertDialogBuilder(
                    it
                ).setCancelable(false)
                    .setMultiChoiceItems(items, checkedItem) { dialog, which, checked ->
                        // Respond to item chosen
                        checkingResult(which, checked)
                        checkedItem[which]=false
                    }
                    .setTitle("Choose your title ")
                    .setNegativeButton(resources.getString(R.string.cancel)) { dialog, which ->
                        if (txtTitleSettings.text.isEmpty()) {
                            Snackbar.make(
                                SettingsLayoutFrag,
                                "Your title is still Empty !!",
                                Snackbar.LENGTH_LONG
                            )
                                .setAction("make default") {
                                    txtTitleSettings.text = "Android"
                                }
                                .setAnimationMode(ANIMATION_MODE_FADE)
                                .setActionTextColor(resources.getColor(R.color.Red))
                                .setAnchorView(R.id.FloatingActionAlarm)
                                .show()
                        }
                    }
                    .setPositiveButton(resources.getString(R.string.accept)) { dialog, which ->
                        for (i in 0 until checkedNames.size) {
                            txtTitleSettings.text = checkedNames[i]
                        }

                        if (txtTitleSettings.text.isEmpty()) {
                            Snackbar.make(
                                SettingsLayoutFrag,
                                "Your title hasn't been changed",
                                Snackbar.LENGTH_LONG
                            )
                                .setAction("make default") {
                                    txtTitleSettings.text = "Android"
                                }
                                .setAnimationMode(ANIMATION_MODE_FADE)
                                .setActionTextColor(resources.getColor(R.color.Red))
                                .setAnchorView(R.id.FloatingActionAlarm)
                                .show()
                        } else if(txtTitleSettings.text.isNotEmpty())  {}
                        else{
                            Snackbar.make(
                                SettingsLayoutFrag,
                                "Your title has been changed",
                                Snackbar.LENGTH_LONG
                            )
                                .setAnchorView(R.id.FloatingActionAlarm)
                                .setAnimationMode(ANIMATION_MODE_FADE)
                                .show()
                        }

                    }
                    .show()
            }
        }
    }

    private fun setTime() {
        val df: DateFormat = SimpleDateFormat("h:mm a")
        val date: String = df.format(Calendar.getInstance().time)
        txtTime.text = "$date"
    }
}