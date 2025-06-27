package com.lolimizuki.mzandroids.datetimes

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.YearMonth
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date

//@formatter:off

@Suppress("unused")
class MZDateTimeExtension // dummny for search

// region Instant

fun Instant.toDate(): Date = Date.from(this)

// endregion

// region LocalDateTime

@Suppress("unused")
fun LocalDateTime.toDateString(pattern: String = "yyyy-MM-dd hh:mm:ss"): String =
    this.format(DateTimeFormatter.ofPattern(pattern))

@Suppress("unused")
fun LocalDateTime.toDate() = toInstant(OffsetDateTime.now().offset).toDate()

@Suppress("unused")
fun LocalDateTime.toYearMonth(): YearMonth = YearMonth.of(this.year, this.month)

// endregion


// region LocalDate

@Suppress("unused")
fun LocalDate.toYearMonth(): YearMonth {
    return YearMonth.of(this.year, this.month)
}

@Suppress("unused")
fun LocalDate.toLocalDateTime(): LocalDateTime {
    return this.atTime(0, 0, 0)
}

// endregion

// region Date

@Suppress("unused")
fun Date.toLocalDateTime(): LocalDateTime = toInstant().atZone(ZoneId.systemDefault())
    .toLocalDateTime()

@Suppress("unused")
fun Date.toYearMonth(): YearMonth = toLocalDateTime().let {
    YearMonth.of(it.year, it.month)
}

@Suppress("unused")
fun Date.startOf(
    type: StartEndOfDayType = StartEndOfDayType.day,
    calendar: Calendar = Calendar.getInstance()
): Date {
    val local = toLocalDateTime()
    return calendar.let {
        when (type) {
            StartEndOfDayType.year -> {
                it.set(local.year, 0, 1, 0,0,0)
            }

            StartEndOfDayType.month -> {
                it.set(local.year, local.monthValue - 1, 1,
                    0,0,0)
            }

            StartEndOfDayType.day -> {
                it.set(local.year, local.monthValue - 1, local.dayOfMonth,
                    0,0,0)
            }
        }

        it.time
    }
}

fun Date.endOf(
    type: StartEndOfDayType = StartEndOfDayType.day,
    calendar: Calendar = Calendar.getInstance()
): Date {
    val start = startOf(type, calendar)

    return Calendar.getInstance().let {
        it.time = start

        when (type) {
            StartEndOfDayType.year -> it.add(Calendar.YEAR, 1)
            StartEndOfDayType.month -> it.add(Calendar.MONTH, 1)
            StartEndOfDayType.day -> it.add(Calendar.DATE, 1)
        }

        it.add(Calendar.SECOND, -1)

        it.time
    }
}

@Suppress("unused")
fun Date.iso8601String(zoneId: ZoneId = ZoneId.systemDefault()): String {
    return toInstant().atZone(zoneId).toString()
}

@Suppress("unused")
fun dateOfISO8601(iso8601String: String): Date {
    return OffsetDateTime.parse(iso8601String).toInstant().toDate()
}

@Suppress("unused")
enum class StartEndOfDayType { year, month, day; }

// endregion

//@formatter:on