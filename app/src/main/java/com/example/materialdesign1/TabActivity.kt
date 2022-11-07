package com.example.materialdesign1

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_tab.*

@Suppress("DEPRECATION")
class TabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

        setUpTabs()
    }

    private fun setUpTabs() {

        val adapter=ViewPagerAdapter(supportFragmentManager,lifecycle)
        viewPager2.adapter=adapter
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val tabIconColor = ContextCompat.getColor(this@TabActivity, android.R.color.holo_red_light)
                tab!!.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                val tabIconColor = ContextCompat.getColor(this@TabActivity, android.R.color.holo_red_light)
                tab!!.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val tabIconColor = ContextCompat.getColor(this@TabActivity, android.R.color.white)
                tab!!.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
            }
        })
        TabLayoutMediator(tab_layout,viewPager2){ tab ,position ->
            when(position){
                0 -> {
                    tab.text = "Favorites"
                    tab.setIcon(R.drawable.ic_baseline_favorite_24)
                    }
                1 ->{
                    tab.text="Music"
                    tab.setIcon(R.drawable.ic_baseline_music_note_24)
                }
                2 ->{
                    tab.text="Painter"
                    tab.setIcon(R.drawable.ic_baseline_color_lens_24)
                }
            }
        }.attach()
    }
}