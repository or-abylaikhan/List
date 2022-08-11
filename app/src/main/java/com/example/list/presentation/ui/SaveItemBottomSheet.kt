package com.example.list.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.list.R
import com.example.list.databinding.BottomSheetShopItemBinding
import com.example.list.domain.model.ShopItem
import com.example.list.util.toEditable
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SaveItemBottomSheet(
    private var onSaveButtonClickListener: ((ShopItem) -> Unit),
    private val shopItem: ShopItem? = null
) : BottomSheetDialogFragment() {

    companion object {
        private fun isInputValid(name: String, count: String, desc: String): Boolean {
            var nameIsValid = false
            var countIsValid = false
            var descIsValid = false
            if (name != "null" && name.isNotBlank())
                nameIsValid = true
            if (count != "null" && count.isNotEmpty() && count.all { it.isDigit() })
                countIsValid = true
            if (desc != "null" && desc.isNotBlank())
                descIsValid = true
            return nameIsValid && countIsValid && descIsValid
        }
    }

    private var binding: BottomSheetShopItemBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetShopItemBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun getTheme() = R.style.CustomBottomSheetDialogTheme

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shopItem?.let {
            binding?.apply {
                etItemName.text = shopItem.name.toEditable()
                etItemCount.text = shopItem.count.toString().toEditable()
                etItemDesc.text = shopItem.description.toEditable()
            }
        }
        setupListeners()
    }

    private fun setupListeners() {
        binding?.apply {
            btnCancel.setOnClickListener { dismiss() }
            btnSave.setOnClickListener {
                val name = etItemName.text.toString().trim()
                val count = etItemCount.text.toString().toInt()
                val desc = etItemDesc.text.toString().trim()
                if (isInputValid(name, count.toString(), desc)) {
                    val item: ShopItem =
                        if (shopItem != null)
                            ShopItem(shopItem.id, name, count, desc, shopItem.isActive)
                        else
                            ShopItem(name = name, count = count, description = desc)
                    onSaveButtonClickListener(item)
                    dismiss()
                } else
                    Toast.makeText(context, "Input is invalid!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}