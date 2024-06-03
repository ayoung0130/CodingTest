package com.example.codingtest.programmers.level_1

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Locale

class CodingTest7 {
    @Test
    fun `카드 뭉치`() {
        assertEquals(
            cardBundle(
                arrayOf("i", "drink", "water"),
                arrayOf("want", "to"),
                arrayOf("i", "want", "to", "drink", "water")
            ), "Yes"
        )
        assertEquals(
            cardBundle(
                arrayOf("i", "water", "drink"),
                arrayOf("want", "to"),
                arrayOf("i", "want", "to", "drink", "water")
            ), "No"
        )
    }

    private fun cardBundle(
        cards1: Array<String>,
        cards2: Array<String>,
        goal: Array<String>
    ): String {
        var i1 = 0
        var i2 = 0

        goal.forEach {
            when {
                i1 < cards1.size && cards1[i1] == it -> i1++
                i2 < cards2.size && cards2[i2] == it -> i2++
                else -> return "No"
            }
        }
        return "Yes"
    }


    @Test
    fun `둘만의 암호`() {
        assertEquals(password("aukks", "wbqd", 5), "happy")
        assertEquals(password("ywo", "qzrl", 3), "cat")
    }

    private fun password(s: String, skip: String, index: Int): String {
        var answer = ""
        val word = ('a'..'z').filter { it !in skip }

        s.forEach {
            var i = (word.indexOf(it) + index) % word.size
            answer += word[i]
        }
        return answer
    }


    @Test
    fun `피보나치 수`() {
        assertEquals(fibonacciNum(3), 2)
        assertEquals(fibonacciNum(5), 5)
    }

    private fun fibonacciNum(n: Int): Int {
        var a = 0
        var b = 1

        var temp: Int

        repeat(n) {
            temp = (a + b) % 1234567
            a = b
            b = temp
        }
        return a % 1234567
    }


    @Test
    fun `JadenCase 문자열 만들기`() {
        assertEquals(jadenCase("3people unFollowed me"), "3people Unfollowed Me")
        assertEquals(jadenCase("for the last week"), "For The Last Week")
        assertEquals("for the last week".toJadenCase(), "For The Last Week")
        assertEquals("for the last week".toJadenCase(), "For The Last Week")
    }

    private fun jadenCase(s: String): String {
        val word = s.split(" ")

        val jadenCaseWord = word.map { word ->
            if (word.isNotEmpty()) {
                word[0].uppercaseChar() + word.substring(1).lowercase()
            } else {
                ""
            }
        }
        return jadenCaseWord.joinToString(" ")
    }

    private fun String.toJadenCase(): String =
        split(" ").filterNot { it.isEmpty() }.joinToString(" ") {
            it[0].uppercaseChar() + it.substring(1).lowercase(Locale.getDefault())
        }

}