package com.example.cryptoapp.presentation.coinlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.domain.entity.CoinInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_coin_info.view.*

class CoinListAdapter(private val context: Context) :
    RecyclerView.Adapter<CoinListAdapter.CoinItemViewHolder>() {

    var coinList: List<CoinInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onItemClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_coin_info, parent, false)
        return CoinItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinItemViewHolder, position: Int) {
        val coin = coinList[position]
        holder.bind(coin)
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

    inner class CoinItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(coinInfo: CoinInfo) {
            val symbolsTemplate = context.resources.getString(R.string.symbols_template)
            val lastUpdateTemplate = context.resources.getString(R.string.last_update_template)
            with(coinInfo) {
                itemView.tvSymbols.text =
                    String.format(symbolsTemplate, priceInfo.fromSymbol, priceInfo.toSymbol)
                itemView.tvPrice.text = priceInfo.price
                itemView.tvLastUpdate.text =
                    String.format(lastUpdateTemplate, priceInfo.getFormattedTime())
                Picasso.get().load(getFullImageUrl()).into(itemView.ivLogoCoin)
                itemView.setOnClickListener {
                    onItemClickListener?.invoke(coinInfo.id)
                }
            }
        }
    }
}