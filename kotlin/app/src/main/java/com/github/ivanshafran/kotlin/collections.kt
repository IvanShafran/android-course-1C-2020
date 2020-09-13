package com.github.ivanshafran.kotlin

fun main() {
    val list = listOf(1, 2, 3)
    list.get(0)
    list[0]

    val list2 = mutableListOf<Int>()
    list2.add(1)
    list2.add(2)
    list2.add(3)

    val list3 = list + list2
}
