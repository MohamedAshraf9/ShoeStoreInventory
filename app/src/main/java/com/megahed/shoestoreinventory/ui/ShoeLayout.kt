package com.megahed.shoestoreinventory.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.megahed.shoestoreinventory.R
import com.megahed.shoestoreinventory.databinding.ShoeItemBinding
import com.megahed.shoestoreinventory.models.Shoe


class ShoeLayout: LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val binding: ShoeItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.shoe_item, this, false)
    fun loadShoe(shoe: Shoe) {
        binding.apply {
            addView(this.root)
            shoeName.text = shoe.name
            company.text = shoe.company
            size.text = shoe.size.toString()
            description.text = shoe.description
        }
    }
}