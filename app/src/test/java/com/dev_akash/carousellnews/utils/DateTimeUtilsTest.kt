package com.dev_akash.carousellnews.utils

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(value = Parameterized::class)
class DateTimeUtilsTest(val input: Long, val expectedValue: String) {


    @Test
    fun getPostedTimeText() {
        val res = DateTimeUtils.getPostedTimeText(input)
        assertEquals(expectedValue, res)
    }

    companion object {

        @JvmStatic
        @Parameters(name = "{index} : {0} is equals to = {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf(1532853058, "4 years ago"),
                arrayOf(1519983341, "5 years ago"),
                arrayOf(1669983341, "2 months ago"),
                arrayOf(1675324787, "4 weeks ago"),
                arrayOf(1677139187, "1 week ago"),
                arrayOf(1677657587, "1 day ago"),
                arrayOf(1677484787, "3 days ago"),
            )
        }
    }
}