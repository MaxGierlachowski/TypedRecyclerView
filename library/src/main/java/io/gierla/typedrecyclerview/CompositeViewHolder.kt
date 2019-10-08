package io.gierla.typedrecyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class CompositeViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val disposable = DisposableHolder()
}