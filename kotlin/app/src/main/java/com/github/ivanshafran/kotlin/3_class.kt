package com.github.ivanshafran.kotlin

class A

class B {
    var x: Int = 0

    fun a() {

    }
}


class C(val x: Int, val y: String)

class C2 constructor(x: Int, y: String) {

    val x: Int
    val y: String

    init {
        this.x = x
        this.y = y
    }
}

// second constructor

class D(val x: Int) {

    var y: String? = null

    constructor(x: Int, y: String) : this(x) {
        this.y = y
    }
}

class E {
    companion object {
        val t = 0
    }
}

val e = E.t


data class Point(val x: Int, val y: Int)
