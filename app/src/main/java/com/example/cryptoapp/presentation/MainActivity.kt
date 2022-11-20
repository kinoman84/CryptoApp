package com.example.cryptoapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cryptoapp.R
import com.example.cryptoapp.presentation.coininfo.CoinDetailsFragment
import com.example.cryptoapp.presentation.coinlist.CoinListFragment

class MainActivity : AppCompatActivity(), CoinListFragment.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            //TODO добавить горизонтальную вёрстку с двумя фрагментами
            openListFragment()
        }
    }

    override fun onItemSelect(coinId: Int) {
        openDetailsFragment(coinId)
    }

    private fun openListFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container , CoinListFragment.newInstance())
            .commit()
    }

    private fun openDetailsFragment(coinId: Int) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, CoinDetailsFragment.newInstance(coinId))
            .commit()
    }
}