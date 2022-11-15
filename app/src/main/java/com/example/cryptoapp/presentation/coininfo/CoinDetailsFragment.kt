package com.example.cryptoapp.presentation.coininfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.R
import com.example.cryptoapp.domain.entity.CoinInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_coin_detail.*
import kotlinx.android.synthetic.main.fragment_coin_details.*
import kotlinx.android.synthetic.main.fragment_coin_details.ivLogoCoin
import kotlinx.android.synthetic.main.fragment_coin_details.tvFromSymbol
import kotlinx.android.synthetic.main.fragment_coin_details.tvLastMarket
import kotlinx.android.synthetic.main.fragment_coin_details.tvLastUpdate
import kotlinx.android.synthetic.main.fragment_coin_details.tvMaxPrice
import kotlinx.android.synthetic.main.fragment_coin_details.tvMinPrice
import kotlinx.android.synthetic.main.fragment_coin_details.tvPrice
import kotlinx.android.synthetic.main.fragment_coin_details.tvToSymbol

class CoinDetailsFragment : Fragment() {
    private var coinId: Int = 0
    private lateinit var viewModel: CoinDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            coinId = it.getInt(COIN_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coin_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CoinDetailsViewModel::class.java]
        viewModel.getCoinDetails(coinId).observe(viewLifecycleOwner, Observer { updateUi(it) })
    }

    private fun updateUi(coinInfo: CoinInfo) {
        with(coinInfo.priceInfo) {
            tvPrice.text = price
            tvMinPrice.text = lowDay
            tvMaxPrice.text = highDay
            tvLastMarket.text = lastMarket
            tvLastUpdate.text = getFormattedTime()
            tvFromSymbol.text = fromSymbol
            tvToSymbol.text = toSymbol
        }
        Picasso.get().load(coinInfo.getFullImageUrl()).into(ivLogoCoin)
    }

    companion object {
        private const val COIN_ID = "coin_id"

        fun newInstance(coinId: Int) =
            CoinDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(COIN_ID, coinId)
                }
            }

    }
}