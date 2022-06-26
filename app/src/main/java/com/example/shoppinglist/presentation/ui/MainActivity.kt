package com.example.shoppinglist.presentation.ui

import android.os.Bundle
import com.example.shoppinglist.data.model.ShopItem
import com.example.shoppinglist.databinding.ActivityMainBinding
import com.example.shoppinglist.util.BindingActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BindingActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        val shopAdapter = ShopItemAdapter()
        binding.rv.adapter = shopAdapter
        mainViewModel.getShopList().observe(this) {
            shopAdapter.shopList = it
        }
        binding.btnAdd.setOnClickListener {
            mainViewModel.addShopItem(ShopItem(name = "Bread", count = 2, isEnabled = false))
        }
    }
}