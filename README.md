# TypedRecyclerView
A lot of Android Apps today have complicated lists with multiple different views. The way to go today is to use a RecyclerView but the setup of a RecyclerView with a Adapter with multiple view types is tedious and error-prone. 

I present to you TypedRecyclerView. A very small library to simplify the creation of multi-type RecyclerViews. 

## Setup

For every item type in your RecyclerView create a class that will represent the state of that item. This class has to implement the TypedRecyclerViewItem interface.

```
data class Item(
    val id: Long = 0L,
    val text: String = ""
) : TypedRecyclerViewItem {
    override fun getItemType(): Int {
        return 0
    }

    override fun isTheSameAs(other: TypedRecyclerViewItem): Boolean {
        return if (other is Item) {
            this.id == other.id
        } else {
            false
        }
    }

    override fun contentsAreTheSameAs(other: TypedRecyclerViewItem): Boolean {
        return if (other is Item) {
            this == other
        } else {
            false
        }
    }
}
```

Afterwards you just have to use TypedRecyclerViewAdapter as your RecyclerView Adapter.

Create a TypedViewHolder so that the RecyclerView knows how to handle your views:

```
class TypeOne : TypedViewHolder {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val viewOne = YourView(parent.context)
        viewOne.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        viewOne.id = ViewCompat.generateViewId()
        return ViewHolder(viewOne)
    }

    override fun onBindViewHolder(
        typedItem: TypedRecyclerViewItem?,
        holder: RecyclerView.ViewHolder
    ) {
        (holder as? ViewHolder)?.let { currentViewHolder ->
            (typedItem as? Item)?.let { currentItem ->
                currentViewHolder.view.text = currentItem.text
            }
        }
    }

    class ViewHolder(val view: YourView) : RecyclerView.ViewHolder(view)
}
```

Finally you have to register the different types of views:

```
adapter.registerViewHolderType(0, TypeOne())
```

Thats it, you can now use your RecyclerView as you are used to and use the function dispatchItems(items) on your adpter to update its data.

A full example can be found inside the repository under /sample.