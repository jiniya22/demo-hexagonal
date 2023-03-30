package me.jiniworld.demohx.application.notice.domain

data class Notice(
    val summary: Summary,
    val content: String,
) {
    data class Summary(
        val id: String,
        val title: String,
        val createdAt: String,
    )

    data class Detail(
        val id: String,
        val title: String,
        val content: String,
        val createdAt: String,
    )

    fun detail(): Detail {
        return Detail(id = summary.id, title = summary.title, content = content, createdAt = summary.createdAt)
    }
}