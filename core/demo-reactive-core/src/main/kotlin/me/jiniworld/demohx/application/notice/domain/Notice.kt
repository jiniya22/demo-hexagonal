package me.jiniworld.demohx.application.notice.domain

data class Notice(
    val summary: Summary,
    val content: String,
) {
    data class Summary(
        val id: String? = null,
        val title: String,
        val createdAt: String? = null,
    )

    data class Detail(
        val id: String? = null,
        val title: String,
        val content: String,
        val createdAt: String? = null,
    )

    fun detail(): Detail {
        return Detail(id = summary.id, title = summary.title, content = content, createdAt = summary.createdAt)
    }
}