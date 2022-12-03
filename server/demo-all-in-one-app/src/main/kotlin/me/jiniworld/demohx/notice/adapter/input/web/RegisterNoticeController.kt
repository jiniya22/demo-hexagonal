package me.jiniworld.demohx.notice.adapter.input.web

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import me.jiniworld.demohx.annotation.WebAdapter
import me.jiniworld.demohx.model.BaseResponse
import me.jiniworld.demohx.notice.application.port.input.RegisterNoticeCommand
import me.jiniworld.demohx.notice.application.port.input.RegisterNoticeUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@WebAdapter
@Tag(name = "setting-system", description = "설정-시스템(공지사항, FAQ, 이용약관, 메타정보 등)")
@RestController
@RequestMapping("/v1/notices")
internal class RegisterNoticeController(
    private val registerNoticeUseCase: RegisterNoticeUseCase,
) {

    @Operation(summary = "공지사항 추가")
    @PostMapping("")
    fun registerNotice(@RequestBody command: RegisterNoticeCommand): BaseResponse {
        registerNoticeUseCase.registerNotice(command)
        return BaseResponse.SUCCESS
    }

}

