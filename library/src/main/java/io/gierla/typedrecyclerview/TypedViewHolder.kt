package io.gierla.typedrecyclerview

import android.view.ViewGroup

interface TypedViewHolder {
    fun onCreateViewHolder(parent: ViewGroup): CompositeViewHolder
    fun onBindViewHolder(typedItem: TypedRecyclerViewItem?, holder: CompositeViewHolder, lifecycleDisposable: DisposableHolder)
}