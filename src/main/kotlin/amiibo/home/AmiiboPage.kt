package amiibo.home

import amiibo.repository.model.Amiibo
import kotlinx.browser.document
import org.w3c.dom.HTMLDivElement

class AmiiboPage(private val presenter: AmiiboContract.Presenter) : AmiiboContract.View {

    private val loader = document.getElementById("load") as HTMLDivElement
    private val content = document.getElementById("root") as HTMLDivElement

    override fun showAmiibo(books: List<Amiibo>) {
    }

    override fun showLoader() {
        loader.style.visibility = "visible"
    }

    override fun hideLoader() {
        loader.style.visibility = "hidden"
    }
}