package io.gierla.typedrecyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface TypedViewHolder {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(typedItem: TypedRecyclerViewItem?, holder: RecyclerView.ViewHolder)
}