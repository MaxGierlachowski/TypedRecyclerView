package io.gierla.trvsample.recycler

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.gierla.trvcore.TypedRecyclerViewAdapter
import io.gierla.trvsample.recycler.viewtypes.TypeOne
import io.gierla.trvsample.recycler.viewtypes.TypeTwo

class MyRecyclerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : RecyclerView(context, attrs, defStyleAttr) {

    val viewAdapter = MyRecyclerViewAdapter()

    init {
        layoutManager = LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        registerTypes(viewAdapter)
        adapter = viewAdapter

        isNestedScrollingEnabled = false
    }

    private fun registerTypes(adapter: TypedRecyclerViewAdapter) {

        adapter.registerViewHolderType(0, TypeOne())
        adapter.registerViewHolderType(1, TypeTwo())

    }

}