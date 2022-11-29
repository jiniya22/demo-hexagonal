package me.jiniworld.demohx.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@ComponentScan("me.jiniworld.demohx.persistence")
@EnableJpaRepositories(basePackages = ["me.jiniworld.demohx.persistence.notice.repository"])
@EntityScan(basePackages = ["me.jiniworld.demohx.persistence.notice.entity"])
class NoticeModule {
//    @Bean
//    fun noticePersistenceAdapter(noticeRepository: NoticeRepository): NoticePersistenceAdapter {
//        return NoticePersistenceAdapter(noticeRepository)
//    }
}