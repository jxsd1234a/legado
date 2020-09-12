package io.legado.app.ui.book.searchContent


import android.app.Application
import io.legado.app.App
import io.legado.app.base.BaseViewModel
import io.legado.app.data.entities.Book

class SearchListViewModel(application: Application) : BaseViewModel(application) {
    var bookUrl: String = ""
    var book: Book? = null
    var searchCallBack: SearchListCallBack? = null

    fun initBook(bookUrl: String, success: () -> Unit) {
        this.bookUrl = bookUrl
        execute {
            book = App.db.bookDao().getBook(bookUrl)
        }.onSuccess {
            success.invoke()
        }
    }

    fun startContentSearch(newText: String?) {
        searchCallBack?.startContentSearch(newText)
    }


    interface SearchListCallBack {
        fun startContentSearch(newText: String?)
    }

}