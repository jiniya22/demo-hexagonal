package me.jiniworld.demohx.application.notice.port.input

import javax.validation.constraints.NotBlank

data class RegisterNoticeCommand(
    @NotBlank val title: String,
    @NotBlank val content: String,
)