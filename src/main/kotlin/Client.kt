import amiibo.home.AmiiboPage
import amiibo.home.AmiiboPresenter
import kotlinx.html.div
import kotlinx.html.dom.append
import org.w3c.dom.Node
import kotlinx.browser.document
import kotlinx.browser.window

fun main() {
    window.onload = { document.body?.sayHello() }

    val bookStorePresenter = AmiiboPresenter()
    val bookStorePage = AmiiboPage(bookStorePresenter)
    bookStorePresenter.attach(bookStorePage)
    bookStorePresenter.loadAmiibo()
}

fun Node.sayHello() {
    append {
        div {
            +"Hello from JS"
        }
    }
}