package io.github.tbib.koingeneratorapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform