package me.jiniworld.demohx.notice.application.service

import me.jiniworld.demohx.annotation.UseCase
import me.jiniworld.demohx.notice.application.port.input.RegisterNoticeCommand
import me.jiniworld.demohx.notice.application.port.input.RegisterNoticeUseCase
import me.jiniworld.demohx.notice.application.port.output.SaveNoticePort
import me.jiniworld.demohx.notice.domain.NoticeContent
import org.springframework.transaction.annotation.Transactional

@Transactional
@UseCase
class RegisterNoticeService(
    private val saveNoticePort: SaveNoticePort,
) : RegisterNoticeUseCase {

    override fun registerNotice(command: RegisterNoticeCommand) {
        saveNoticePort.saveNotice(NoticeContent(title = command.title, content = command.content))
    }
}