package com.example.codingtest.programmers.level_1

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.max
import kotlin.math.min


class CodingTest1 {

    @Test
    fun `두 정수 사이의 합`() {
        //a = 3 , b = 5
        assertEquals(sum(3, 5), 12)

        //a = 3 , b = 3
        assertEquals(sum(3, 3), 3)

        //a = 5 , b = 3
        assertEquals(sum(5, 3), 12)

    }

    private fun sum(a: Int, b: Int): Long =
        if (a == b) a.toLong()
        else (min(a, b)..max(a, b)).sum().toLong()


    @Test
    fun `문자열을 정수로 바꾸기`() {
        assertEquals(toInt("1234"), 1234)
        assertEquals(toInt("-1234"), -1234)
    }

    private fun toInt(s: String): Int = s.toInt()

    @Test
    fun `평균 구하기`() {
        assertEquals(average(intArrayOf(1, 2, 3, 4)), 2.5, 0.0)
        assertEquals(average(intArrayOf(5, 5)), 5.0, 0.0)
    }

    private fun average(arr: IntArray): Double = arr.average()


    @Test
    fun `짝수와 홀수`() {
        assertEquals(3.evenOrOdd(), "Odd")
        assertEquals(4.evenOrOdd(), "Even")
    }

    private fun Int.evenOrOdd(): String = if (this % 2 == 0) "Even" else "Odd"


    @Test
    fun `제일 작은 수 제거하기`() {
        assertArrayEquals(removeSmallest(intArrayOf(4, 3, 2, 1)), intArrayOf(4, 3, 2))
        assertArrayEquals(removeSmallest(intArrayOf(10)), intArrayOf(-1))
    }


    private fun removeSmallest(numbers: IntArray): IntArray =
        if (numbers[0] == 10 || numbers.isEmpty()) intArrayOf(-1)
        else (numbers.filter { it != numbers.minOrNull() }.toIntArray())


    @Test
    fun `나누어 떨어지는 숫자 배열`() {

        assertArrayEquals(divideArray(intArrayOf(5, 9, 7, 10), 5), intArrayOf(5, 10))
        assertArrayEquals(divideArray(intArrayOf(2, 36, 1, 3), 1), intArrayOf(1, 2, 3, 36))
        assertArrayEquals(divideArray(intArrayOf(3, 2, 6), 10), intArrayOf(-1))
    }

    private fun divideArray(arr: IntArray, divisor: Int): IntArray {
        arr.filter { it % divisor == 0 }.sorted().toIntArray().let {
            return if (it.isEmpty()) intArrayOf(-1) else it
        }
    }


    @Test
    fun `가운데 글자 가져오기`() {
        assertEquals("abcde".getMiddle(), "c")
        assertEquals("qwer".getMiddle(), "we")
    }

    private fun String.getMiddle(): String =
        this.slice(((this.length - 1) / 2..(this.length / 2)))


    @Test
    fun `자연수 뒤집어 배열로 만들기`() {
        assertArrayEquals(12345L.toReverseIntArray(), intArrayOf(5, 4, 3, 2, 1))
    }

    private fun Long.toReverseIntArray(): IntArray =
        this.toString().reversed().map { it.toString().toInt() }.toIntArray()


    @Test
    fun `수박수박수박수?`(){
        assertEquals(3.toConvertPattern(), "수박수")
        assertEquals(4.toConvertPattern(), "수박수박")
    }

    private fun Int.toConvertPattern() : String =
        if(this % 2 == 0) "수박".repeat(this / 2) else "수박".repeat(this / 2) + "수"

    @Test
    fun `휴대폰 번호 가리기`() {

        assertEquals("01033334444".toHidePhoneNumber(), "*******4444")
        assertEquals("027778888".toHidePhoneNumber(), "*****8888")
    }

    private fun String.toHidePhoneNumber() : String =
        "*".repeat(this.length - 4) + this.takeLast(4)
}