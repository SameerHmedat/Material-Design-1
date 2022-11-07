package com.example.materialdesign1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.materialdesign1.fragment.FavoritesFragment
import com.example.materialdesign1.fragment.MusicFragment
import com.example.materialdesign1.fragment.SettingsFragment
import com.example.materialdesign1.fragment.PainterFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        badge(R.id.favoritesPage,7)
        badge(R.id.musicPage,0)
        badge(R.id.painter,8)
        badge(R.id.newsPage,23)
        bottomNavigationView.removeBadge(R.id.newsPage)
//        bottomNavigationView.selectedItemId=R.id.newsPage

        if (savedInstanceState == null) {
            // as soon as the application opens the first fragment should
            supportFragmentManager.beginTransaction().replace(R.id.containerFragment, FavoritesFragment()).commit()
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener)
    }

    private fun badge(id: Int,number:Int) {
        if(number>0){
        val generalBadge = bottomNavigationView.getOrCreateBadge(id)
        generalBadge.number = number}
        else{ bottomNavigationView.getOrCreateBadge(id) }

    }


    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        // By using switch we can easily get the selected fragment by using there id
        lateinit var selectedFragment: Fragment
        when (item.itemId) {
            R.id.favoritesPage -> {
                selectedFragment = FavoritesFragment()
            }
            R.id.musicPage -> {
                selectedFragment = MusicFragment()
            }
            R.id.painter -> {
                selectedFragment = PainterFragment()
            }

            R.id.newsPage -> {
                selectedFragment = SettingsFragment()
            }
        }
        // It will help to replace the one fragment to other.
        supportFragmentManager.beginTransaction().replace(R.id.containerFragment, selectedFragment)
            .commit()
        true
    }
}
