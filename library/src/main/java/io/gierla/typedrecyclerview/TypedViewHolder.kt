package io.gierla.typedrecyclerview

import android.view.ViewGroup
import io.reactivex.disposables.CompositeDisposable

interface TypedViewHolder {
    fun onCreateViewHolder(parent: ViewGroup): CompositeViewHolder
    fun onBindViewHolder(typedItem: TypedRecyclerViewItem?, holder: CompositeViewHolder, lifecycleDisposable: CompositeDisposable)
}