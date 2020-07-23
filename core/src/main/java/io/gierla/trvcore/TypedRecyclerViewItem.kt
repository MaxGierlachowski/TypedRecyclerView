package io.gierla.trvcore

interface TypedRecyclerViewItem {
    fun getItemType(): Int
    fun isTheSameAs(other: TypedRecyclerViewItem): Boolean
    fun contentsAreTheSameAs(other: TypedRecyclerViewItem): Boolean
}