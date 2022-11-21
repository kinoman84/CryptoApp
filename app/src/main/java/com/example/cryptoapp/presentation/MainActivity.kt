package com.example.cryptoapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.example.cryptoapp.R
import com.example.cryptoapp.presentation.coininfo.CoinDetailsFragment
import com.example.cryptoapp.presentation.coinlist.CoinListFragment

class MainActivity : AppCompatActivity(), CoinListFragment.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openListFragment()
    }

    override fun onItemSelect(coinId: Int) {
        openDetailsFragment(coinId)
    }

    private fun openListFragment() {
        val containerId = if (isOnePane()) R.id.container else R.id.container_for_list
        val listFragment = supportFragmentManager.findFragmentByTag("list_fragment")
        if (listFragment != null) {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .remove(listFragment)
                .replace(containerId, CoinListFragment.newInstance(), "list_fragment")
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(containerId, CoinListFragment.newInstance(), "list_fragment")
                .commit()
        }
    }

    private fun openDetailsFragment(coinId: Int) {
        val containerId = if (isOnePane()) R.id.container else R.id.container_for_details

        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(containerId, CoinDetailsFragment.newInstance(coinId))
            .commit()
    }

    private fun isOnePane() : Boolean {
        val containerForDetails = findViewById<FragmentContainerView>(R.id.container_for_details)
        return containerForDetails == null
    }
}