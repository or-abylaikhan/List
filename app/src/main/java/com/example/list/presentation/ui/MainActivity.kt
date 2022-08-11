package com.example.list.presentation.ui

import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.list.databinding.ActivityMainBinding
import com.example.list.util.BindingActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BindingActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val mainViewModel: MainViewModel by viewModel()
    private var adapter: ShopListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setupListeners()
        setupObservers()
    }

    private fun initViews() {
        adapter = ShopListAdapter(
            onShopItemLongClickListener = { mainViewModel.changedEnabledState(it) },
            onShopItemClickListener = { shopItem ->
                SaveItemBottomSheet({ mainViewModel.editShopItem(it) }, shopItem).show(
                    supportFragmentManager,
                    SaveItemBottomSheet.TAG
                )
            }
        )
        binding.rv.adapter = adapter
    }

    private fun setupListeners() {
        ItemTouchHelper(object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.START or ItemTouchHelper.END) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ) = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter?.let { mainViewModel.deleteShopItem(it.currentList[viewHolder.adapterPosition]) }
            }
        }).attachToRecyclerView(binding.rv)
        binding.btnAdd.setOnClickListener {
            SaveItemBottomSheet(onSaveButtonClickListener = { mainViewModel.addShopItem(it) }).show(
                supportFragmentManager,
                SaveItemBottomSheet.TAG
            )
        }
    }

    private fun setupObservers() =
        mainViewModel.getShopList().observe(this) { adapter?.submitList(it) }
}