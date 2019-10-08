package io.gierla.typedrecyclerview

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class DisposableHolder {

    val compositeDisposable = CompositeDisposable()

    fun clear() {
        compositeDisposable.clear()
    }

    fun add(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

}