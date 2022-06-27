package com.example.list.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.list.R
import com.example.list.databinding.BottomSheetShopItemBinding
import com.example.list.domain.ShopItem
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SaveItemBottomSheet : BottomSheetDialogFragment() {

    private var binding: BottomSheetShopItemBinding? = null
    var onSaveButtonClickListener: ((ShopItem) -> Unit)? = null

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
        setupListeners()
    }

    private fun setupListeners() {
        binding?.apply {
            btnCancel.setOnClickListener { dismiss() }
            etItemName.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(p0: Editable?) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            })
            btnSave.setOnClickListener {
                onSaveButtonClickListener?.invoke(
                    ShopItem(
                        name = etItemName.text.toString(),
                        count = etItemCount.text.toString().toInt(),
                        description = etItemDesc.text.toString(),
                        isActive = true
                    )
                )
                dismiss()
                Toast.makeText(context, "Item was saved", Toast.LENGTH_SHORT).show()
            }
        }
    }
}