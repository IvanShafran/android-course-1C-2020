package com.github.ivanshafran.kotlin

fun main() {
    val a = 2
    if (a > 1) {

    } else {

    }

    for (i in 0..3) {

    }

    for (i in 0 until 10) {

    }

    val t = listOf(1, 2, 3)
    for (i in t.indices) {

    }

    for (i in 0 until t.size) {

    }

    val b: Any = 0
    when (b) {
        is Int -> print("int")
        is String -> print("string")
        in 0..3 -> print("0 < < 3")
        4 -> print("x")
    }

    // smart cast
    if (b is String) {
        val c: String = b
    }
}
