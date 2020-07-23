package io.gierla.trvsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.gierla.trvcore.TypedRecyclerViewItem
import io.gierla.trvsample.data_items.ItemOne
import io.gierla.trvsample.data_items.ItemTwo
import kotlinx.android.synthetic.main.activity_main.*

class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items: MutableList<TypedRecyclerViewItem> = mutableListOf()
        for(i in 0..100) {
            if(i % 2 == 0) {
                items.add(ItemOne(i.toLong(), "$i"))
            } else {
                items.add(ItemTwo(i.toLong(), "$i"))
            }
        }

        recycler_view.viewAdapter.dispatchItems(items)
    }
}
