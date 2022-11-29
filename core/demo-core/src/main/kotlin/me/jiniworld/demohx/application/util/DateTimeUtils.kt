package me.jiniworld.demohx.application.util

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField
import java.time.temporal.TemporalAdjusters

object DateTimeUtils {

    private const val SIMPLE_PATTERN_MONTH = "yyyyMM"
    private const val SIMPLE_PATTERN_DATE = "yyyyMMdd"
    private const val DEFAULT_PATTERN_DATE = "yyyy-MM-dd"
    private const val DEFAULT_PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss"
    private const val DEFAULT_PATTERN_TIME = "HH:mm:ss"

    private val LOCALTIME_START = LocalTime.of(0, 0)
    private val LOCALTIME_END = LocalTime.of(23, 59, 59)

    val FORMATTER_MONTH_SIMPLE: DateTimeFormatter = DateTimeFormatter.ofPattern(SIMPLE_PATTERN_MONTH)
    val FORMATTER_DATE_SIMPLE: DateTimeFormatter = DateTimeFormatter.ofPattern(SIMPLE_PATTERN_DATE)
    val FORMATTER_DATE: DateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN_DATE)
    val FORMATTER_DATETIME: DateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN_DATETIME)
    val FORMATTER_TIME: DateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN_TIME)

    fun getFirstDate(month: String): LocalDate =
        LocalDate.of(Integer.parseInt(month.substring(0, 4)), Integer.parseInt(month.substring(4, 6)), 1)

    fun getLastDate(month: String): LocalDate =
        getFirstDate(month).with(TemporalAdjusters.lastDayOfMonth())

    fun getFirstDateTime(date: LocalDate): LocalDateTime =
        LocalDateTime.of(date, LOCALTIME_START)

    fun getLastDateTime(date: LocalDate): LocalDateTime =
        LocalDateTime.of(date.with(TemporalAdjusters.lastDayOfMonth()), LOCALTIME_END)

    fun getFirstDateTime(date: LocalDate, type: AnalysisType): LocalDateTime =
        when (type) {
            AnalysisType.weekly -> LocalDateTime.of(date.minusDays((date[ChronoField.DAY_OF_WEEK] - 1).toLong()).minusWeeks(6), LOCALTIME_START)
            AnalysisType.monthly -> date.minusDays((date[ChronoField.DAY_OF_MONTH] - 1).toLong()).minusMonths(6).atStartOfDay()
            else -> LocalDateTime.of(date.minusDays((date[ChronoField.DAY_OF_WEEK] - 1).toLong()), LOCALTIME_START)
        }

    fun getLastDateTime(date: LocalDate, type: AnalysisType): LocalDateTime =
        when (type) {
            AnalysisType.monthly -> LocalDateTime.of(date.minusDays(date[ChronoField.DAY_OF_MONTH].toLong()).plusMonths(1), LOCALTIME_END)
            else -> LocalDateTime.of(date.plusDays((7 - date[ChronoField.DAY_OF_WEEK]).toLong()), LOCALTIME_END)
        }

    fun toString(date: LocalDate) = date.format(FORMATTER_DATE)

    fun toString(dateTime: LocalDateTime) = dateTime.format(FORMATTER_DATETIME)

    fun toDateString(dateTime: LocalDateTime) = dateTime.format(FORMATTER_DATE)
}


enum class AnalysisType {
    daily, weekly, monthly
}