package aaa.bivizul.a31project.especdata.especmodel

import kotlinx.serialization.Serializable

@Serializable
data class Espec(
    val especmm: String,
    val especsim: String,
    val especid: String,
    val especl: String,
    val espect: String,
)