package com.example.codingtest.programmers.level_1

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Calendar
import java.util.Stack

class CodingTest4 {

    @Test
    fun `콜라츠 추측`() {
        assertEquals(collatz(6), 8)
        assertEquals(collatz(16), 4)
        assertEquals(collatz(626331), -1)
    }

    private fun collatz(num: Int): Int = collatzAlgorithm(num.toLong())

    private tailrec fun collatzAlgorithm(num: Long, count: Int = 0): Int =
        when {
            count > 500 -> -1
            num == 1L -> count
            else -> collatzAlgorithm(num = if (num % 2 == 0L) num / 2 else num * 3 + 1, count + 1)
        }


    @Test
    fun `이상한 문자 만들기`() {
        assertEquals(_toMakeStrangeWord("try hello world"), "TrY HeLlO WoRlD")
        assertEquals(_toMakeStrangeWord("cat dog snake"), "CaT DoG SnAkE")
    }

    private fun toMakeStrangeWord(s: String): String {
        return s.split(" ").joinToString(" ") { word ->
            word.indices.joinToString("") { index ->
                val char = word[index]
                if (index % 2 == 0) char.toString().uppercase() else char.toString().lowercase()
            }
        }
    }


    private fun _toMakeStrangeWord(s: String): String =
        s.split(" ").joinToString(" ") { word ->
            word.mapIndexed(::toUpperOrLower).joinToString("")
        }


    private fun toUpperOrLower(index: Int, c: Char): String =
        if (index % 2 == 0) c.uppercase() else c.lowercase()


    @Test
    fun `2016년`() {
        assertEquals(toFindDayOfWeek2(5, 24), "TUE")
    }

    private fun toFindDayOfWeek(a: Int, b: Int): String {
        val dayOfWeek = listOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")
        val dayInMonth = intArrayOf(0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        var totalDays = b

        for (month in 1 until a) {
            totalDays += dayInMonth[month]
        }
        val dayOfWeekIndex = (totalDays + 4) % 7

        return dayOfWeek[dayOfWeekIndex]
    }

    private fun toFindDayOfWeek2(a: Int, b: Int): String {
        val dayOfWeek = listOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")
        var totalDays = b

        IntRange(1, a - 1).forEach {
            totalDays += when (it) {
                1, 3, 5, 7, 8, 10, 12 -> 31
                2 -> 29
                else -> 30
            }
        }

        return dayOfWeek[(totalDays + 4) % 7]
    }


    private fun toFindDayOfWeekUseCalendar(a: Int, b: Int): String =
        when (Calendar.getInstance().apply {
            set(2016, a - 1, b)
        }.get(Calendar.DAY_OF_WEEK)) {
            Calendar.SUNDAY -> "SUN"
            Calendar.MONDAY -> "MON"
            Calendar.TUESDAY -> "TUE"
            Calendar.WEDNESDAY -> "WED"
            Calendar.THURSDAY -> "THU"
            Calendar.FRIDAY -> "FRI"
            Calendar.SATURDAY -> "SAT"
            else -> ""
        }


    @Test
    fun `크레인 인형뽑기 게임`() {
        assertEquals(
            craneGame(
                arrayOf(
                    intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 1, 0, 3), intArrayOf(0, 2, 5, 0, 1),
                    intArrayOf(4, 2, 4, 4, 2), intArrayOf(3, 4, 1, 3, 1)
                ),
                intArrayOf(1, 5, 3, 5, 1, 2, 1, 4),
            ), 4
        )
    }

    private fun craneGame(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val box = Stack<Int>()

        moves.forEach {
            for (i in board.indices) {
                if (board[i][it - 1] != 0) {
                    if (!box.empty() && box.peek() == board[i][it - 1]) {
                        answer += 2
                        box.pop()
                    } else {
                        box.push(board[i][it - 1])
                    }
                    board[i][it - 1] = 0
                    break
                }
            }
        }
        return answer
    }


    @Test
    fun `없는 숫자 더하기`() {
        assertEquals(addGhostNum(intArrayOf(1, 2, 3, 4, 6, 7, 8, 0)), 14)
        assertEquals(addGhostNum(intArrayOf(5, 8, 4, 0, 6, 7, 9)), 6)
    }

    private fun addGhostNum(numbers: IntArray): Int {
        val allNum = setOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val ghostNum = allNum - numbers.toSet()
        return ghostNum.sum()
    }


    @Test
    fun `약수의 개수와 덧셈`() {
        assertEquals(divisorNum(13, 17), 43)
        assertEquals(divisorNum(24, 27), 52)
    }

    private fun divisorNum(left: Int, right: Int): Int {
        var answer = 0

        for (i in left..right) {
            var count = 0
            for (j in 1..i) {
                if (i % j == 0) {
                    count++
                }
            }
            if (count % 2 == 0) {
                answer += i
            } else {
                answer -= i
            }
        }
        return answer
    }

}