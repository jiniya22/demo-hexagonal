package me.jiniworld.demohx.notice.application.service

import me.jiniworld.demohx.annotation.UseCase
import me.jiniworld.demohx.notice.application.port.`in`.RegisterNoticeCommand
import me.jiniworld.demohx.notice.application.port.`in`.RegisterNoticeUseCase
import me.jiniworld.demohx.notice.application.port.out.SaveNoticePort
import org.springframework.transaction.annotation.Transactional

@Transactional
@UseCase
class RegisterNoticeService(
    private val saveNoticePort: SaveNoticePort,
) : RegisterNoticeUseCase {



    override fun registerNotice(command: RegisterNoticeCommand) {
        TODO("Not yet implemented")
    }
}