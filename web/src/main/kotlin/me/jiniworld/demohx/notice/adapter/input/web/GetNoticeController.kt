package me.jiniworld.demohx.notice.adapter.input.web

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import me.jiniworld.demohx.notice.application.service.GetNoticeService
import me.jiniworld.demohx.notice.domain.Notice
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Component
//@WebAdapter
@Tag(name = "setting-system", description = "설정-시스템(공지사항, FAQ, 이용약관, 메타정보 등)")
@RestController
@RequestMapping("/v1/notices")
internal class GetNoticeController(
    private val getNoticeQuery: GetNoticeService,
) {

    @Operation(summary = "공지사항 목록")
    @GetMapping("")
    fun notices(
        @RequestParam(value = "page", required = false, defaultValue = "0") page: Int,
        @RequestParam(value = "size", required = false, defaultValue = "10") size: Int,
    ): List<Notice> {
        println(">>>>>>>>> 1")
        return getNoticeQuery.getNoticeSimple(PageRequest.of(page, size, Sort.by(Sort.Order.desc("id"))))
    }

}