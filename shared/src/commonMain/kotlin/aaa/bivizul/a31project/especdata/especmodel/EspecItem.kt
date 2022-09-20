package aaa.bivizul.a31project.especdata.especmodel

@kotlinx.serialization.Serializable
data class EspecItem(
    val id: Int,
    val espectitle: String,
    val especdescription: String,
    val impacts: List<Impact>,
)