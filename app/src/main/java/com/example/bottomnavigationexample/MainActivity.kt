package com.example.bottomnavigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.bottomnavigationexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        changeFragmentInView(secondFragment)

        activityMainBinding.bnv.setOnItemSelectedListener {
            when(it.itemId){
                R.id.settings -> changeFragmentInView(firstFragment)
                R.id.contacts -> changeFragmentInView(secondFragment)
                R.id.messages -> changeFragmentInView(thirdFragment)
            }
            true
        }


        //To see a number badge near menu item use this:
        activityMainBinding.bnv.getOrCreateBadge(R.id.contacts).apply {
            number = 10
            isVisible = true
        }
    }

    private fun changeFragmentInView(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(activityMainBinding.flForFragment.id, fragment)
            commit()
        }
    }
}