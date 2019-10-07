package io.gierla.typedrecyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class CompositeViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val disposable = CompositeDisposable()
}