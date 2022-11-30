package me.jiniworld.demohx.model

data class BaseResponse(
    val result: String = "success",
    val reason: String = "",
) {
    companion object {
        val SUCCESS = BaseResponse()
    }
}
