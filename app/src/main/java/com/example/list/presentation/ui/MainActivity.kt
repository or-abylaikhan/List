package com.example.list.presentation.ui

import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.list.databinding.ActivityMainBinding
import com.example.list.util.BindingActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BindingActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var adapter: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setupListeners()
        setupObservers()
    }

    private fun initViews() {
        binding.rv.adapter = ShopListAdapter(
            onShopItemClickListener = { shopItem ->
                val bottomSheet = SaveItemBottomSheet({ mainViewModel.editShopItem(it) }, shopItem)
                bottomSheet.show(supportFragmentManager, bottomSheet.tag)
            },
            onShopItemLongClickListener = { mainViewModel.changedEnabledState(it) }
        )
    }

    private fun setupListeners() {
        val simpleCallback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.START or ItemTouchHelper.END) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ) = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                mainViewModel.deleteShopItem(adapter.currentList[viewHolder.adapterPosition])
            }
        }
        ItemTouchHelper(simpleCallback).attachToRecyclerView(binding.rv)
        binding.btnAdd.setOnClickListener {
            val bottomSheet = SaveItemBottomSheet({ mainViewModel.addShopItem(it) })
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }
    }

    private fun setupObservers() =
        mainViewModel.getShopList().observe(this) { adapter.submitList(it) }
}