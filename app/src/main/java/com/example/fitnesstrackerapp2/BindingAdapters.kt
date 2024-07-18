package com.example.fitnesstrackerapp2

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("items")
fun setItems(recyclerView: RecyclerView, items: List<HistoryItem>?) {
    items?.let {
        (recyclerView.adapter as? HistoryAdapter)?.submitList(items)
    }
}
