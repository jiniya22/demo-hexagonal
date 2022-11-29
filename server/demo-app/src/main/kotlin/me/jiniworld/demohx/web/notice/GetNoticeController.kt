package me.jiniworld.demohx.web.notice

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import me.jiniworld.demohx.application.notice.port.input.GetNoticeQuery
import me.jiniworld.demohx.application.notice.domain.Notice
import me.jiniworld.demohx.application.notice.port.output.NoticeSimple
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*

@Component
//@WebAdapter
@Tag(name = "setting-system", description = "설정-시스템(공지사항, FAQ, 이용약관, 메타정보 등)")
@RestController
@RequestMapping("/v1/notices")
internal class GetNoticeController(
    private val getNoticeQuery: GetNoticeQuery,
) {

    @Operation(summary = "공지사항 목록")
    @GetMapping("")
    fun notices(
        @RequestParam(value = "page", required = false, defaultValue = "0") page: Int,
        @RequestParam(value = "size", required = false, defaultValue = "10") size: Int,
    ) = getNoticeQuery.getNoticeSimple(PageRequest.of(page, size, Sort.by(Sort.Order.desc("id"))))

    @Operation(summary = "공지사항 상세조회")
    @GetMapping("/{notice_id}")
    fun notice(@PathVariable("notice_id") noticeId: Long) =
        getNoticeQuery.getNoticeDetail(noticeId)

}