package com.example.sharedviewmodelnavigationdemo

import kotlinx.serialization.Serializable

@Serializable
data object A
@Serializable
data object B
@Serializable
data class C(val name: String)

@Serializable
object GraphRoute