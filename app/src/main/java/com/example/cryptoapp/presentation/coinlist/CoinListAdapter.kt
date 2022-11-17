package com.example.cryptoapp.presentation.coinlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ItemCoinInfoBinding
import com.example.cryptoapp.domain.entity.CoinInfo
import com.squareup.picasso.Picasso

class CoinListAdapter(private val context: Context) :
    RecyclerView.Adapter<CoinListAdapter.CoinItemViewHolder>() {

    var coinList: List<CoinInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onItemClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinItemViewHolder {
        val binding =
            ItemCoinInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinItemViewHolder, position: Int) {
        val coin = coinList[position]
        holder.bind(coin)
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

    inner class CoinItemViewHolder(private val binding: ItemCoinInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(coinInfo: CoinInfo) {
            val symbolsTemplate = context.resources.getString(R.string.symbols_template)
            val lastUpdateTemplate = context.resources.getString(R.string.last_update_template)
            with(coinInfo) {
                binding.tvSymbols.text =
                    String.format(symbolsTemplate, priceInfo.fromSymbol, priceInfo.toSymbol)
                binding.tvPrice.text = priceInfo.price
                binding.tvLastUpdate.text =
                    String.format(lastUpdateTemplate, priceInfo.getFormattedTime())
                Picasso.get().load(getFullImageUrl()).into(binding.ivLogoCoin)
                binding.root.setOnClickListener {
                    onItemClickListener?.invoke(coinInfo.id)
                }
            }
        }
    }
}