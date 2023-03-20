package me.jiniworld.demohx.notice.adapter.input.web

import io.mockk.mockk
import me.jiniworld.demohx.notice.application.port.input.GetNoticeQuery
import org.hamcrest.Matchers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@AutoConfigureRestDocs
@AutoConfigureMockMvc
internal class GetNoticeControllerTest {
    
    @Autowired
    private lateinit var mockMvc: MockMvc

    private lateinit var getNoticeController: GetNoticeController
    private lateinit var getNoticeQuery: GetNoticeQuery

    @BeforeEach
    fun setUp() {
        val registerNoticeUseCase = mockk<GetNoticeQuery>(relaxed = true)
        this.getNoticeQuery = registerNoticeUseCase
        val cont = GetNoticeController(registerNoticeUseCase)
        this.getNoticeController = cont
        this.mockMvc = MockMvcBuilders.standaloneSetup(cont).build()
    }
    
    @Test
    fun getNotices() {
        val resultActions = mockMvc.perform(
            MockMvcRequestBuilders.get("/v1/notices")
                .header("Content-Type", "application/json")
        )

        // then
        resultActions
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.result", Matchers.`is`("success")))
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun getNotice() {
        val resultActions = mockMvc.perform(
            MockMvcRequestBuilders.get("/v1/notices/{id}", 1)
                .accept(MediaType.APPLICATION_JSON)
        )

        // then
        resultActions
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.result", Matchers.`is`("success")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.data").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").isNotEmpty)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andDo(MockMvcResultHandlers.print())
//
//        resultActions.andDo(document("notice-search/success",
//            requestFields(
//                fieldWithPath("id").description("notice id")
//            )
//        ));
//            prepa
//                resource(
//                    ResourceSnippetParameters.builder()
//                    .description("v1 test")
//                    .pathParameters(
//                        parameterWithName("name").description("이름"))
//                    .responseFields(
//                        fieldWithPath("data").description("입력한 이름")
////                        fieldWithPath("products").description("The product line item of the cart."),
////                        subsectionWithPath("products[]._links.product").description("Link to the product."),
////                        fieldWithPath("products[].quantity").description("The quantity of the line item."),
////                        subsectionWithPath("products[].product").description("The product the line item relates to."),
////                        subsectionWithPath("_links").description("Links section.")
//                    )

    }

    @Test
    fun test1() {
        val resultActions = mockMvc.perform(
            MockMvcRequestBuilders.get("/v1/notices/test")
                .header("Content-Type", "application/json")
        )

        // then
        resultActions
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.result", Matchers.`is`("success")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.data", Matchers.`is`("test")))
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andDo(MockMvcResultHandlers.print())
    }
}