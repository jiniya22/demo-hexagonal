package me.jiniworld.demohx

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

object GsonUtils {
    private const val patternDate = "yyyy-MM-dd"
    private const val patternTime = "HH:mm:ss"
    private const val patternDateTime = "yyyy-MM-dd HH:mm:ss"

    private val gson = GsonBuilder()
        .disableHtmlEscaping()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .setDateFormat(patternDateTime)
        .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeAdapter().nullSafe())
        .registerTypeAdapter(LocalDate::class.java, LocalDateAdapter().nullSafe())
        .registerTypeAdapter(LocalTime::class.java, LocalTimeAdapter().nullSafe())
        .create()

    fun toJson(obj: Any): String {
        return gson.toJson(obj)
    }

    fun <T> fromJson(str: String, clazz: Class<T>): T {
        return gson.fromJson(str, clazz)
    }
    
    class LocalDateAdapter : TypeAdapter<LocalDate>() {
        private val format: DateTimeFormatter = DateTimeFormatter.ofPattern(patternDate)

        override fun write(writer: JsonWriter, value: LocalDate?) {
            value?.let { writer.value(value.format(format)) }
        }

        override fun read(reader: JsonReader): LocalDate {
            return LocalDate.parse(reader.nextString(), format)
        }
    }

    class LocalDateTimeAdapter : TypeAdapter<LocalDateTime>() {
        private val format: DateTimeFormatter = DateTimeFormatter.ofPattern(patternDateTime)

        override fun write(writer: JsonWriter, value: LocalDateTime?) {
            value?.let { writer.value(value.format(format)) }
        }

        override fun read(reader: JsonReader): LocalDateTime {
            return LocalDateTime.parse(reader.nextString(), format)
        }
    }

    class LocalTimeAdapter : TypeAdapter<LocalTime>() {
        private val format: DateTimeFormatter = DateTimeFormatter.ofPattern(patternTime)

        override fun write(writer: JsonWriter, value: LocalTime?) {
            value?.let { writer.value(value.format(format)) }
        }

        override fun read(reader: JsonReader): LocalTime {
            return LocalTime.parse(reader.nextString(), format)
        }
    }
}