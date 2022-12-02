package me.jiniworld.demohx.notice.application.port.output

import me.jiniworld.demohx.notice.domain.Notice
import me.jiniworld.demohx.notice.domain.NoticeContent

interface SaveNoticePort {
    fun saveNotice(noticeContent: NoticeContent): Notice
}