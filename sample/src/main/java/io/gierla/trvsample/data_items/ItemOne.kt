package io.gierla.trvsample.data_items

import io.gierla.trvcore.TypedRecyclerViewItem

data class ItemOne(
    val id: Long = 0L,
    val text: String = ""
) : TypedRecyclerViewItem {
    override fun getItemType(): Int {
        return 0
    }

    override fun isTheSameAs(other: TypedRecyclerViewItem): Boolean {
        return if (other is ItemOne) {
            this.id == other.id
        } else {
            false
        }
    }

    override fun contentsAreTheSameAs(other: TypedRecyclerViewItem): Boolean {
        return if (other is ItemOne) {
            this == other
        } else {
            false
        }
    }
}