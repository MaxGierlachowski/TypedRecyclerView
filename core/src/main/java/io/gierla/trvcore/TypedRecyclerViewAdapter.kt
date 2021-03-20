package io.gierla.trvcore

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListUpdateCallback
import androidx.recyclerview.widget.RecyclerView

open class TypedRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items = listOf<TypedRecyclerViewItem>()
        private set

    private val viewHolderTypes = hashMapOf<Int, TypedViewHolder>()

    fun registerViewHolderType(type: Int, typedViewHolder: TypedViewHolder) {
        viewHolderTypes[type] = typedViewHolder
    }

    var oldItems = mutableListOf<TypedRecyclerViewItem>()

    fun dispatchItems(typedItems: List<TypedRecyclerViewItem>) {
        items = mutableListOf<TypedRecyclerViewItem>().apply { addAll(typedItems) }
        DiffUtil.calculateDiff(DiffCallback(oldItems, items)).dispatchUpdatesTo(object : ListUpdateCallback {
            override fun onInserted(position: Int, count: Int) {
                notifyItemRangeInserted(position, count)
            }

            override fun onRemoved(position: Int, count: Int) {
                notifyItemRangeRemoved(position, count)
            }

            override fun onMoved(fromPosition: Int, toPosition: Int) {
                notifyItemMoved(fromPosition, toPosition)
            }

            override fun onChanged(position: Int, count: Int, payload: Any?) {
                notifyItemRangeChanged(position, count, true)
            }
        })
        oldItems.clear()
        oldItems.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolderType = viewHolderTypes[viewType]
        return viewHolderType?.onCreateViewHolder(parent) ?: throw Exception("No ViewHolderType found for type $viewType")
    }

    override fun getItemViewType(position: Int): Int = items[position].getItemType()

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolderType = viewHolderTypes[getItemViewType(position)]
        viewHolderType?.onBindViewHolder(items[position], holder)
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