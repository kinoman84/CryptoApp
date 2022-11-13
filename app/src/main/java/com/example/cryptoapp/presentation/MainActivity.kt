package com.example.cryptoapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cryptoapp.R
import com.example.cryptoapp.presentation.coinlist.CoinListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            openListFragment()
        }
    }

    private fun openListFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container , CoinListFragment.newInstance())
            .commit()
    }
}