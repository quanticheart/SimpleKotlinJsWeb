package amiibo.home

import amiibo.repository.model.Amiibo

interface AmiiboContract {
    interface View {
        fun showAmiibo(books: List<Amiibo>) // 1
        fun showLoader() // 2
        fun hideLoader() // 3
    }

    interface Presenter {
        fun attach(view: View) // 4
        fun loadAmiibo() // 5
    }
}