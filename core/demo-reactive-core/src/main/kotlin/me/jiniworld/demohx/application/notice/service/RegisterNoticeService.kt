package me.jiniworld.demohx.application.notice.service

import me.jiniworld.demohx.annotation.UseCase
import me.jiniworld.demohx.application.notice.domain.Notice
import me.jiniworld.demohx.application.notice.port.input.RegisterNoticeCommand
import me.jiniworld.demohx.application.notice.port.input.RegisterNoticeUseCase
import me.jiniworld.demohx.application.notice.port.output.SaveNoticePort
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@UseCase
internal class RegisterNoticeService(
    private val saveNoticePort: SaveNoticePort,
): RegisterNoticeUseCase {

    @Transactional
    override suspend fun registerNotice(command: RegisterNoticeCommand) {
        saveNoticePort.saveNotice(Notice(Notice.Summary(title = command.title), content = command.content))
    }

}