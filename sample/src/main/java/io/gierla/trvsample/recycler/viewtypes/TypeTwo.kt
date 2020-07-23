package io.gierla.trvsample.recycler.viewtypes

import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import io.gierla.trvcore.TypedRecyclerViewItem
import io.gierla.trvcore.TypedViewHolder
import io.gierla.trvsample.data_items.ItemOne
import io.gierla.trvsample.data_items.ItemTwo
import io.gierla.trvsample.test_views.ViewOne
import io.gierla.trvsample.test_views.ViewTwo

class TypeTwo : TypedViewHolder {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val viewTwo = ViewTwo(parent.context)
        viewTwo.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        viewTwo.id = ViewCompat.generateViewId()
        return ViewHolder(viewTwo)
    }

    override fun onBindViewHolder(
        typedItem: TypedRecyclerViewItem?,
        holder: RecyclerView.ViewHolder
    ) {
        (holder as? ViewHolder)?.let { currentViewHolder ->
            (typedItem as? ItemTwo)?.let { currentItem ->
                currentViewHolder.view.text = currentItem.text
            }
        }
    }

    class ViewHolder(val view: ViewTwo) : RecyclerView.ViewHolder(view)
}