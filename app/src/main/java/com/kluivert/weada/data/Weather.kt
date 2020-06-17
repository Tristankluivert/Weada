package com.kluivert.weada.data

data class Weather(
    val current: Current,
    val location: Location,
    val request: Request
)