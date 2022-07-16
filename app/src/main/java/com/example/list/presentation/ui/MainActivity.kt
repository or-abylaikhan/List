package com.example.list.presentation.ui

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
        mainViewModel.getShopList().observe(this) { list ->
            adapter?.submitList(list.sortedByDescending { it.isActive })
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
                    val item = it.currentList[viewHolder.adapterPosition]
                    mainViewModel.deleteShopItem(item)
                    Toast.makeText(baseContext, "${item.name} item was deleted", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        ItemTouchHelper(simpleCallback).attachToRecyclerView(binding.rv)
        adapter?.onShopItemLongClickListener = {
            mainViewModel.changedEnabledState(it)
            Toast.makeText(
                baseContext,
                "${it.name} item was ${if (it.isActive) "disabled" else "enabled"}",
                Toast.LENGTH_SHORT
            ).show()
        }
        adapter?.onShopItemClickListener = { shopItem ->
            val bottomSheet = SaveItemBottomSheet(shopItem)
            bottomSheet.onSaveButtonClickListener = {
                mainViewModel.editShopItem(it)
                Toast.makeText(baseContext, "${it.name} item was updated", Toast.LENGTH_SHORT)
                    .show()
            }
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }
        binding.btnAdd.setOnClickListener {
            val bottomSheet = SaveItemBottomSheet()
            bottomSheet.onSaveButtonClickListener = {
                mainViewModel.addShopItem(it)
                Toast.makeText(baseContext, "${it.name} item was added", Toast.LENGTH_SHORT).show()
            }
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }
    }
}