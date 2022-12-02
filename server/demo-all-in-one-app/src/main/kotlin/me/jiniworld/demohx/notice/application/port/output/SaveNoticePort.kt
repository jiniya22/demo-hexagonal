package me.jiniworld.demohx.notice.application.port.output

import me.jiniworld.demohx.notice.domain.Notice
import me.jiniworld.demohx.notice.domain.NoticeInfo

interface SaveNoticePort {
    fun saveNotice(noticeInfo: NoticeInfo): Notice
}