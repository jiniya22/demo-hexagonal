package me.jiniworld.demohx.persistence

import com.ninjasquad.springmockk.MockkBean
import me.jiniworld.demohx.config.BeanConfig
import me.jiniworld.demohx.persistence.notice.NoticeRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.test.context.jdbc.Sql

//@DataJpaTest
@SpringBootTest
//@Import(value = [BeanConfig::class])
//@Import(value = [NoticeRepository::class])
//@Import([NoticePersistenceAdapter::class])
internal class NoticePersistenceAdapterTest {
    @MockkBean
    private lateinit var noticeRepository: NoticeRepository
//    @Test
//    @Sql("NoticePersistenceAdapterTest.sql")
//    fun loadNoticesTest() {
//        val notices = noticePersistenceAdapter.loadNotices(PageRequest.of(0, 10, Sort.by(Sort.Order.desc("id"))))
//        print(notices)
//    }

    @Test
//    @Sql("NoticePersistenceAdapterTest.sql")
    fun ttt() {
        print("zzz")
        val notices = noticeRepository.findAllBy(PageRequest.of(0, 10, Sort.by(Sort.Order.desc("id"))))
        print(notices)
    }

}