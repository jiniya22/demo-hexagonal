package me.jiniworld.demohx.model

data class DataResponse<T>(
    val result: String = "success",
    val reason: String = "",
    val data: T,
)