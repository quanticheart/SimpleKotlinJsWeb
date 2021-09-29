package amiibo.home.adapter

import amiibo.repository.model.Amiibo
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.dom.addClass
import kotlinx.html.dom.create
import org.w3c.dom.*

class AmiiboItem {
    fun build(amiibo: Amiibo): HTMLElement {
        // 1
        val containerElement = document.createElement("div") as HTMLDivElement
        val imageElement = document.createElement("img") as HTMLImageElement
        val titleElement = document.createElement("div") as HTMLDivElement
        val priceElement = document.createElement("div") as HTMLDivElement
        val descriptionElement = document.createElement("div") as HTMLDivElement
        val viewDetailsButtonElement = document.createElement("button") as HTMLButtonElement

        // 2
        bind(
            amiibo = amiibo,
            imageElement = imageElement,
            titleElement = titleElement,
            priceElement = priceElement,
            descriptionElement = descriptionElement,
            viewDetailsButtonElement = viewDetailsButtonElement
        )

        // 3
        applyStyle(
            containerElement,
            imageElement = imageElement,
            titleElement = titleElement,
            priceElement = priceElement,
            descriptionElement = descriptionElement,
            viewDetailsButtonElement = viewDetailsButtonElement
        )

        // 4
        containerElement
            .appendChild(
                imageElement,
                titleElement,
                descriptionElement,
                priceElement,
                viewDetailsButtonElement
            )
        // 5
        return containerElement
    }

    // 6
    private fun Element.appendChild(vararg elements: Element) {
        elements.forEach {
            this.appendChild(it)
        }
    }

    private fun bind(
        amiibo: Amiibo,
        imageElement: HTMLImageElement,
        titleElement: HTMLDivElement,
        priceElement: HTMLDivElement,
        descriptionElement: HTMLDivElement,
        viewDetailsButtonElement: HTMLButtonElement
    ) {

        // 1
        imageElement.src = amiibo.character

        // 2
        titleElement.innerHTML = amiibo.character
//        priceElement.innerHTML = book.price
//        descriptionElement.innerHTML = book.description
//        viewDetailsButtonElement.innerHTML = "view details"
//
//        // 3
//        viewDetailsButtonElement.addEventListener("click", {
//            window.open(book.url)
//        })
    }

    private fun applyStyle(
        containerElement: HTMLDivElement,
        imageElement: HTMLImageElement,
        titleElement: HTMLDivElement,
        priceElement: HTMLDivElement,
        descriptionElement: HTMLDivElement,
        viewDetailsButtonElement: HTMLButtonElement
    ) {
        containerElement.addClass("card", "card-shadow", "col-6")
        imageElement.addClass("cover-image")
        titleElement.addClass("text-title", "float-left")
        descriptionElement.addClass("text-description", "float-left")
        priceElement.addClass("text-price", "float-left")
        viewDetailsButtonElement.addClass("view-details", "ripple", "float-right")
    }
}