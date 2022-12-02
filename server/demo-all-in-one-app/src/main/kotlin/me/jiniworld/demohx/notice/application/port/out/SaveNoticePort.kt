package me.jiniworld.demohx.notice.application.port.out

import me.jiniworld.demohx.notice.domain.NoticeContent

interface SaveNoticePort {
    fun saveNotice(noticeContent: NoticeContent)
}