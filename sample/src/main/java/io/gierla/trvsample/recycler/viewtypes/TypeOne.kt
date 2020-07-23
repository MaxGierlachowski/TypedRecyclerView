package io.gierla.trvsample.recycler.viewtypes

import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import io.gierla.trvcore.TypedRecyclerViewItem
import io.gierla.trvcore.TypedViewHolder
import io.gierla.trvsample.data_items.ItemOne
import io.gierla.trvsample.test_views.ViewOne

class TypeOne : TypedViewHolder {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val viewOne = ViewOne(parent.context)
        viewOne.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        viewOne.id = ViewCompat.generateViewId()
        return ViewHolder(viewOne)
    }

    override fun onBindViewHolder(
        typedItem: TypedRecyclerViewItem?,
        holder: RecyclerView.ViewHolder
    ) {
        (holder as? ViewHolder)?.let { currentViewHolder ->
            (typedItem as? ItemOne)?.let { currentItem ->
                currentViewHolder.view.text = currentItem.text
            }
        }
    }

    class ViewHolder(val view: ViewOne) : RecyclerView.ViewHolder(view)
}