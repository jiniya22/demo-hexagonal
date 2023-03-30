package me.jiniworld.demohx.application.notice.port.output

import me.jiniworld.demohx.application.notice.domain.Notice

interface SaveNoticePort {
    suspend fun saveNotice(notice: Notice)
}