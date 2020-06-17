package com.kluivert.weada.data

data class Current(
    val humidity: Int,
    val observation_time: String,
    val pressure: Int,
    val temperature: Int,
    val visibility: Int,
    val weather_descriptions: List<String>,
    val weather_icons: List<String>,
    val wind_degree: Int,
    val wind_dir: String
)