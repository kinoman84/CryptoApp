package com.example.cryptoapp.presentation.coininfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.databinding.FragmentCoinDetailsBinding
import com.example.cryptoapp.domain.entity.CoinInfo
import com.squareup.picasso.Picasso

class CoinDetailsFragment : Fragment() {
    private var coinId: Int = 0
    private lateinit var viewModel: CoinDetailsViewModel

    private var _binding: FragmentCoinDetailsBinding? = null
    private val binding: FragmentCoinDetailsBinding
        get() = _binding ?: throw RuntimeException("FragmentCoinDetailsBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            coinId = it.getInt(COIN_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CoinDetailsViewModel::class.java]
        viewModel.getCoinDetails(coinId).observe(viewLifecycleOwner) { updateUi(it) }
    }

    private fun updateUi(coinInfo: CoinInfo) {
        with(coinInfo.priceInfo) {
            binding.tvPrice.text = price
            binding.tvMinPrice.text = lowDay
            binding.tvMaxPrice.text = highDay
            binding.tvLLastMarket.text = lastMarket
            binding.tvLastUpdate.text = getFormattedTime()
            binding.tvFromSymbol.text = fromSymbol
            binding.tvToSymbol.text = toSymbol
            Picasso.get().load(coinInfo.getFullImageUrl()).into(binding.ivLogoCoin)
        }
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