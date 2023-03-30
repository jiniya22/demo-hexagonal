package me.jiniworld.demohx.application.notice.port.input

import javax.validation.constraints.Min

data class GetNoticesCommand(
    @Min(0) val page: Int,
    @Min(5) val size: Int,
)
