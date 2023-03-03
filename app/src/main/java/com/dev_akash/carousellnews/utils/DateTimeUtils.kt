package com.dev_akash.carousellnews.utils

import android.util.Log
import java.util.concurrent.TimeUnit

object DateTimeUtils {

    fun getPostedTimeText(timeCreated: Long): String {
        val currTime = System.currentTimeMillis()
        val timeDiff = currTime - (timeCreated * 1000)

        val year = timeDiff / (1000L * 60 * 60 * 24 * 365)
        val month = timeDiff / (1000L * 60 * 60 * 24 * 30)
        val weeks = timeDiff / (1000L * 60 * 60 * 24 * 7)
        val day = TimeUnit.MILLISECONDS.toDays(timeDiff)
        val hour = TimeUnit.MILLISECONDS.toHours(timeDiff)

//        Log.d("getPostedTimeText() == ","Y ->$year, M -> $month, W -> $weeks, D -> $day, H -> $hour")

        return when {
            hour < 24 -> "$hour ${if (hour > 1) "hours" else "hour"} ago"
            day < 7 -> "$day ${if (day > 1) "days" else "day"} ago"
            weeks <= 4 -> "$weeks ${if (weeks > 1) "weeks" else "week"} ago"
            month < 12 -> "$month ${if (month > 1) "months" else "month"} ago"
            else -> "$year ${if (year > 1) "years" else "year"} ago"
        }

    }

}