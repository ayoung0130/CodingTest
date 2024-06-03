package com.example.codingtest.programmers.level_1

import org.junit.Assert.assertEquals
import org.junit.Test

class CodingTest6 {

    @Test
    fun `옹알이2`() {
        assertEquals(babbling(arrayOf("aya", "yee", "u", "maa")), 1)
        assertEquals(babbling(arrayOf("ayaye", "uuu", "yeye", "yemawoo", "ayaayaa")), 2)
    }

    private fun babbling(babbling: Array<String>): Int {
        var answer = 0
        var possible = arrayOf("aya", "ye", "woo", "ma")

        for (word in babbling) {
            var temp = word
            for (i in possible.indices) {
                if (temp.contains(possible[i] + possible[i])) {
                    continue
                } else {
                    temp = temp.replace(possible[i], " ")
                }
            }
            if (temp.replace(" ", "") == "") answer++
        }
        return answer
    }


    private fun _babbling(babbling: Array<String>): Int {
        val ableRegex = "aya|ye|woo|ma".toRegex()
        val unableRegex = "ayaaya|yeye|woowoo|mama".toRegex()
        return babbling.count {
            !it.contains(unableRegex) && it.replace(ableRegex, "").isEmpty()
        }
    }


    @Test
    fun `크기가 작은 부분문자열`() {
        assertEquals(partialString("3141592", "271"), 2)
        assertEquals(partialString("500220839878", "7"), 8)
        assertEquals(partialString("10203", "15"), 3)
    }

    private fun partialString(t: String, p: String): Int =
        t.windowed(p.length,1,false).count { it <= p }

    private fun _partialString(t: String, p: String): Int =
        (0..t.length - p.length).map { t.substring(it until it + p.length) }.count { it <= p }


    @Test
    fun `숫자 문자열과 영단어`() {
        assertEquals(engToNum("one4seveneight"), 1478)
        assertEquals(engToNum("23four5six7"), 234567)
        assertEquals(engToNum("2three45sixseven"), 234567)
        assertEquals(engToNum("123"), 123)
    }

    private fun engToNum(s: String): Int {
        val nums =
            arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        var s1 = s
        for (i in nums.indices) {
            s1 = s1.replace(nums[i], i.toString())
        }
        return s1.toInt()
    }

}