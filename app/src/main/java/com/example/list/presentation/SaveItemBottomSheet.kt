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
import com.example.list.util.toEditable
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SaveItemBottomSheet(private val shopItem: ShopItem? = null) : BottomSheetDialogFragment() {

    companion object {
        const val TAG = "SaveItemBottomSheet"
    }

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
            etItemName.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(p0: Editable?) {}
                override fun onTextChanged(name: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    if (!name.isNullOrBlank()) {
                        tilItemName.isErrorEnabled = false
                        tilItemName.helperText = ""
                    } else {
                        tilItemName.isErrorEnabled = true
                        tilItemName.helperText = getString(R.string.invalid_name)
                    }
                }
            })
            etItemCount.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(p0: Editable?) {}
                override fun onTextChanged(count: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    if (!count.isNullOrBlank() && count.all { it.isDigit() }) {
                        tilItemName.isErrorEnabled = false
                        tilItemName.helperText = ""
                    } else {
                        tilItemName.isErrorEnabled = true
                        tilItemName.helperText = getString(R.string.invalid_name)
                    }
                }
            })
            etItemDesc.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(p0: Editable?) {}
                override fun onTextChanged(desc: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    if (!desc.isNullOrBlank()) {
                        tilItemName.isErrorEnabled = false
                        tilItemName.helperText = ""
                    } else {
                        tilItemName.isErrorEnabled = true
                        tilItemName.helperText = getString(R.string.invalid_name)
                    }
                }
            })
            btnSave.setOnClickListener {
                val name = etItemName.text.toString().trim()
                val count = etItemCount.text.toString()
                val desc = etItemDesc.text.toString().trim()
                if (isInputValid(name, count, desc)) {
                    val item = ShopItem(
                        name = name,
                        count = count.toInt(),
                        description = desc,
                        isActive = true
                    )
                    onSaveButtonClickListener?.invoke(item)
                    dismiss()
                    Toast.makeText(context, "${item.name} was saved", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Input is invalid!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

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