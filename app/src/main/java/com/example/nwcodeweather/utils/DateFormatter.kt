package com.example.nwcodeweather.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * This function takes a string representing a date in the format "yyyy-MM-dd HH:mm:ss"
 * and converts it to a pair of strings representing the date in the format "MMMM dd"
 * and the time in the format "HH:mm".
 *
 * @param date The date string to be formatted.
 * @return A Pair of formatted date and time strings.
 */
fun formatStringToDateTime(date: String): Pair<String, String> {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val outputFormat = SimpleDateFormat("MMMM dd", Locale.getDefault())
    val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    
    val parsedDate = inputFormat.parse(date)
    
    return Pair(outputFormat.format(parsedDate), timeFormat.format(parsedDate))
}

/**
 * Converts Unix time to date time and returns time in the format "HH:mm".
 * @param unixTime The Unix time to convert.
 * @return The time in the format "HH:mm".
 */
fun unixTimeToDateTime(unixTime: Long): String {
    val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    val date = Date(unixTime * 1000L)

    return timeFormat.format(date)
}