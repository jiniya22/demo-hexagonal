package me.jiniworld.demohx.web.item

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import me.jiniworld.demohx.annotation.WebAdapter
import me.jiniworld.demohx.application.item.port.input.GetItemQuery
import me.jiniworld.demohx.application.item.port.input.GetItemsCommand
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@WebAdapter
@Tag(name = "item", description = "상품")
@RestController
@RequestMapping("/v1/items")
internal class GetItemController(
    private val getItemQuery: GetItemQuery,
) {
    @Operation(summary = "삼품 목록")
    @GetMapping("")
    fun getItems(
        @RequestParam(value = "page", required = false, defaultValue = "0") page: Int,
        @RequestParam(value = "size", required = false, defaultValue = "10") size: Int,
    ) = getItemQuery.getItems(GetItemsCommand(page = page, size = size))

}