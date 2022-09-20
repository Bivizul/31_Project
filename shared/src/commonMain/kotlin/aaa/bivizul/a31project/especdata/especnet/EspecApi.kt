package aaa.bivizul.a31project.especdata.especnet

import aaa.bivizul.a31project.especdata.especmodel.Espec
import aaa.bivizul.a31project.especdata.especmodel.EspecItem
import aaa.bivizul.a31project.especdata.especmodel.Getespec
import aaa.bivizul.a31project.especdata.especutil.Especcon.ESPECBASEURL
import aaa.bivizul.a31project.especdata.especutil.Especcon.ESPECITEMURL
import aaa.bivizul.a31project.especdata.especutil.Especcon.GETESPECURL
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class EspecApi {

    val ecspechc = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
        install(HttpTimeout) {
            val timeout = 30000L
            connectTimeoutMillis = timeout
            requestTimeoutMillis = timeout
            socketTimeoutMillis = timeout
        }
    }

    private fun HttpRequestBuilder.base(path: String) {
        url {
            takeFrom(ESPECBASEURL)
            encodedPath = path
        }
    }

    suspend fun getEspecItem(): List<EspecItem> {
        val getescpecitemurl = ESPECITEMURL
        val espechr = ecspechc.get { base(getescpecitemurl) }
        val getescpecitembody = espechr.body<List<EspecItem>>()
        return getescpecitembody
    }

    suspend fun getGetespec(espec: Espec): Getespec {
        val getespecurl = GETESPECURL
        val espechr = ecspechc.post {
            base(getespecurl)
            contentType(ContentType.Application.Json)
            setBody(espec)
        }
        val getespecbody = espechr.body<Getespec>()
        return getespecbody
    }

}