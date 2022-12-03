package me.jiniworld.demohx.notice.adapter.input.web

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import me.jiniworld.demohx.GsonUtils
import me.jiniworld.demohx.model.BaseResponse
import me.jiniworld.demohx.notice.application.port.input.RegisterNoticeCommand
import me.jiniworld.demohx.notice.application.port.input.RegisterNoticeUseCase
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.Matchers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders

internal class RegisterNoticeControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    private lateinit var registerNoticeController: RegisterNoticeController
    private lateinit var registerNoticeUseCase: RegisterNoticeUseCase

    @BeforeEach
    fun setUp() {
        val registerNoticeUseCase = mockk<RegisterNoticeUseCase>(relaxed = true)
        this.registerNoticeUseCase = registerNoticeUseCase
        val cont = RegisterNoticeController(registerNoticeUseCase)
        this.registerNoticeController = cont
        this.mockMvc = MockMvcBuilders.standaloneSetup(cont).build()
    }

    @Test
    fun registerNoticeTest_mockMvc() {
        val command = RegisterNoticeCommand(title = "title1", content = "content1")

        // when
        val resultActions = mockMvc.perform(
            MockMvcRequestBuilders.post("/v1/notices")
                .content(GsonUtils.toJson(command))
                .header("Content-Type", "application/json")
        )

        // then
        resultActions
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.result", Matchers.`is`("success")))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun registerNoticeTest_mockK() {
        val command = RegisterNoticeCommand(title = "title1", content = "content1")

        every { registerNoticeUseCase.registerNotice(command) } returns Unit
        assertThat(registerNoticeController.registerNotice(command)).isEqualTo(BaseResponse.SUCCESS)
        verify { registerNoticeUseCase.registerNotice(command) }
    }

}