package com.example.list.presentation

import android.os.Bundle
import android.widget.Toast
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
    }

    private fun initViews() {
        adapter = ShopListAdapter()
        binding.rv.adapter = adapter
        mainViewModel.getShopList().observe(this) {
            adapter?.submitList(it)
        }
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
                adapter?.let {
                    mainViewModel.deleteShopItem(it.currentList[viewHolder.adapterPosition])
                    Toast.makeText(baseContext, "Shop item was deleted", Toast.LENGTH_SHORT).show()
                }
            }
        }
        ItemTouchHelper(simpleCallback).attachToRecyclerView(binding.rv)
        adapter?.onShopItemLongClickListener = {
            mainViewModel.changedEnabledState(it)
        }
        adapter?.onShopItemClickListener = {

        }
        binding.btnAdd.setOnClickListener {
            val bottomSheet = SaveItemBottomSheet()
            bottomSheet.onSaveButtonClickListener = {
                mainViewModel.addShopItem(it)
            }
            bottomSheet.show(supportFragmentManager, SaveItemBottomSheet::class.java.name)
        }
    }
}