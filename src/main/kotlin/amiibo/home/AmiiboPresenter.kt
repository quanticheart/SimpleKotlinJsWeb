package amiibo.home

import amiibo.repository.API_URL
import amiibo.repository.model.AmiiboResponse
import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.*
import org.w3c.xhr.XMLHttpRequest

class AmiiboPresenter : AmiiboContract.Presenter {
    private lateinit var view: AmiiboContract.View

    override fun attach(view: AmiiboContract.View) {
        this.view = view
    }

    override fun loadAmiibo() {
        CoroutineScope(Dispatchers.Main).launch {
            view.showLoader()
            val response = getAsync2(API_URL)
            view.showAmiibo(response.amiibo)
            view.hideLoader()
        }
    }

    private val TIME_OUT = 60_000

    private suspend fun getAsync2(url: String): AmiiboResponse {
        val client = HttpClient(Js) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })

//                engine {
//                    connectTimeout = TIME_OUT
//                    socketTimeout = TIME_OUT
//                }
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        console.log("Logger Ktor =>", message)
                    }
                }
                level = LogLevel.ALL
            }

            install(ResponseObserver) {
                onResponse { response ->
                    console.log("HTTP status:", "${response.status.value}")
                }
            }
            install(DefaultRequest) {
//                header(HttpHeaders.ContentType, ContentType.Application.Json)
//                header(HttpHeaders.Accept, "text/html")
//                header(HttpHeaders.Authorization, "token")
//                header(HttpHeaders.UserAgent, "ktor client")
            }
        }

        return client.request(url) {
            method = HttpMethod.Get
//            parameter("price", "asc")
//            headers {
//            }
//            cookie(
//                name = "user_name", value = "jetbrains", expires = GMTDate(
//                    seconds = 0,
//                    minutes = 0,
//                    hours = 10,
//                    dayOfMonth = 1,
//                    month = Month.APRIL,
//                    year = 2022
//                )
//            )
        }
    }
}