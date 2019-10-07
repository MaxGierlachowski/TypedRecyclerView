package io.gierla.typedrecyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class TypedRecyclerViewAdapter : RecyclerView.Adapter<CompositeViewHolder>() {

    var items = listOf<TypedRecyclerViewItem>()
        private set

    val lifecycleDisposable = CompositeDisposable()

    private val viewHolderTypes = hashMapOf<Int, TypedViewHolder>()

    fun registerViewHolderType(type: Int, typedViewHolder: TypedViewHolder) {
        viewHolderTypes[type] = typedViewHolder
    }

    fun dispatchItems(typedItems: List<TypedRecyclerViewItem>) {
        val newItems = listOf(*typedItems.toTypedArray())
        DiffUtil.calculateDiff(DiffCallback(this.items, newItems)).dispatchUpdatesTo(this)
        this.items = newItems
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompositeViewHolder {
        val viewHolderType = viewHolderTypes[viewType]
        return viewHolderType?.onCreateViewHolder(parent) ?: throw Exception("No ViewHolderType found for type $viewType")
    }

    override fun getItemViewType(position: Int): Int = items[position].getItemType()

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CompositeViewHolder, position: Int) {
        holder.disposable.clear()
        val viewHolderType = viewHolderTypes[getItemViewType(position)]
        viewHolderType?.onBindViewHolder(items[position], holder, lifecycleDisposable)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        lifecycleDisposable.clear()
        super.onDetachedFromRecyclerView(recyclerView)
    }

    private class DiffCallback(private val oldList: List<TypedRecyclerViewItem>, private val newList: List<TypedRecyclerViewItem>) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].isTheSameAs(newList[newItemPosition])
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].contentsAreTheSameAs(newList[newItemPosition])
        }

    }

}