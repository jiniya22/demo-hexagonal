package me.jiniworld.demohx.notice.adapter.output.persistence

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories
internal class NoticePersistenceAdapterConfiguration {

    @Bean
    fun noticePersistenceAdapter(noticeRepository: NoticeRepository): NoticePersistenceAdapter {
        return NoticePersistenceAdapter(noticeRepository)
    }
}