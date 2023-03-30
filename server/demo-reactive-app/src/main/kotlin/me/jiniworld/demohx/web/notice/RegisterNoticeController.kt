package me.jiniworld.demohx.web.notice

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import me.jiniworld.demohx.annotation.WebAdapter
import me.jiniworld.demohx.application.notice.port.input.RegisterNoticeCommand
import me.jiniworld.demohx.application.notice.port.input.RegisterNoticeUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@WebAdapter
@Tag(name = "setting-system", description = "설정-시스템(공지사항, FAQ, 이용약관, 메타정보 등)")
@RestController
@RequestMapping("/v1/notices")
internal class RegisterNoticeController(
    private val registerNoticeUseCase: RegisterNoticeUseCase,
) {

    @Operation(summary = "공지사항 등록")
    @PostMapping("")
    suspend fun getNotices(
        @Valid @RequestBody command: RegisterNoticeCommand,
    ) = registerNoticeUseCase.registerNotice(command)

}