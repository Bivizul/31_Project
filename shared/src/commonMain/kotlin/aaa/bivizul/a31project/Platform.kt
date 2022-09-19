package aaa.bivizul.a31project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform