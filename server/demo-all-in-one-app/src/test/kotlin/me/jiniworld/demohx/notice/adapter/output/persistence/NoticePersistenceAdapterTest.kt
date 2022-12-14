package me.jiniworld.demohx.notice.adapter.output.persistence

import me.jiniworld.demohx.notice.domain.NoticeInfo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.test.context.jdbc.Sql
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@DataJpaTest
@Import(NoticePersistenceAdapter::class)
internal class NoticePersistenceAdapterTest @Autowired constructor(
    val noticePersistenceAdapter: NoticePersistenceAdapter,
) {

    @Test
    @Sql("notice.sql")
    fun loadNotices() {
        val notices = noticePersistenceAdapter.loadNotices(
            PageRequest.of(1, 3, Sort.by(Sort.Order.desc("id")))
        )
        notices?.forEach(System.out::println)
    }

    @Test
    @Sql("notice.sql")
    fun loadNotice() {
        val notice = noticePersistenceAdapter.loadNotice(1L)
        checkNotNull(notice)
        Assertions.assertEquals(notice.id, 1L)
        println(notice)
    }

    @Transactional
    @Test
    fun saveNotice() {
        val content = NoticeInfo(title = "공지사항", content = "공지사항입니다")
        val notice = noticePersistenceAdapter.saveNotice(content)
        Assertions.assertTrue(notice.id > 0)
        Assertions.assertEquals(notice.noticeInfo.title, content.title)
        Assertions.assertEquals(notice.noticeInfo.content, content.content)
        println(notice)
    }
}