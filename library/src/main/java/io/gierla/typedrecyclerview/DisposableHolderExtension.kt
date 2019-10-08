package io.gierla.typedrecyclerview

import io.reactivex.disposables.Disposable

fun Disposable.addTo(disposableHolder: DisposableHolder) {
    disposableHolder.add(this)
}