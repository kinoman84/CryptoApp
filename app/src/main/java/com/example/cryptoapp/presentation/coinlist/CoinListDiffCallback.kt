package com.example.cryptoapp.presentation.coinlist

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptoapp.domain.entity.CoinInfo

class CoinListDiffCallback : DiffUtil.ItemCallback<CoinInfo>() {

    override fun areItemsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem == newItem
    }
}