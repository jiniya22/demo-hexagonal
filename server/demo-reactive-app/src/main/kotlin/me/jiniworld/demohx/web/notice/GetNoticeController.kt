package me.jiniworld.demohx.web.notice

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import me.jiniworld.demohx.annotation.WebAdapter
import me.jiniworld.demohx.application.notice.port.input.GetNoticeQuery
import me.jiniworld.demohx.application.notice.port.input.GetNoticesCommand
import me.jiniworld.demohx.model.NotFoundException
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Validated
@WebAdapter
@Tag(name = "setting-system", description = "설정-시스템(공지사항, FAQ, 이용약관, 메타정보 등)")
@RestController
@RequestMapping("/v1/notices")
internal class GetNoticeController(
    private val getNoticeQuery: GetNoticeQuery,
) {

    @Operation(summary = "공지사항 목록")
    @GetMapping("")
    fun getNotices(
        @RequestParam(value = "page", required = false, defaultValue = "0") page: Int,
        @RequestParam(value = "size", required = false, defaultValue = "10") size: Int,
    ) = getNoticeQuery.getNoticeSummaries(GetNoticesCommand(page = page, size = size))

    @Operation(summary = "공지사항 상세조회")
    @GetMapping("/{notice_id}")
    suspend fun getNotice(@PathVariable("notice_id") noticeId: String,
    ) = getNoticeQuery.getNoticeDetail(noticeId)
        ?: throw NotFoundException("조회되는 공지사항이 없습니다.")

}