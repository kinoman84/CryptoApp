package com.example.cryptoapp.presentation.coinlist

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import kotlinx.android.synthetic.main.activity_coin_prce_list.*
import kotlinx.android.synthetic.main.fragment_coin_list.*

class CoinListFragment : Fragment() {

    private lateinit var viewModel: CoinListViewModel
    private lateinit var adapter: CoinListAdapter
    private lateinit var onItemSelectedListener: OnItemSelectedListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnItemSelectedListener) {
            onItemSelectedListener = context
        } else {
            throw RuntimeException("Must implements OnItemSelectedListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coin_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CoinListViewModel::class.java]
        adapter = CoinListAdapter(requireContext())
        adapter.onItemClickListener = {
            onItemSelectedListener.onItemSelect(it)
        }
        rv_coin_price_list.adapter = adapter

        viewModel.coinList.observe(viewLifecycleOwner, Observer { adapter.coinList = it } )
    }

    interface OnItemSelectedListener {
        fun onItemSelect(coinId: Int)
    }

    companion object {

        fun newInstance() =
            CoinListFragment()
    }
}