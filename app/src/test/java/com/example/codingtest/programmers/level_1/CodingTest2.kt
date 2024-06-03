package com.example.codingtest.programmers.level_1

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.sqrt

class CodingTest2 {

    @Test
    fun `서울에서 김서방 찾기`() {
        assertEquals(toFindKim(arrayOf("Jane", "Kim")), "김서방은 1에 있다")
        assertEquals(toFindKim(arrayOf("Kim", "Jung", "Han")), "김서방은 0에 있다")
        assertEquals(toFindKim(arrayOf("Park", "Lee", "Kim")), "김서방은 2에 있다")
    }

    private fun toFindKim(seoul: Array<String>): String =
        "김서방은 ${seoul.indexOf("Kim")}에 있다"


    @Test
    fun `시저 암호`() {
        assertEquals(caesarCipher("AB", 1), "BC")
        assertEquals(caesarCipher("z", 1), "a")
        assertEquals(caesarCipher("a B z", 4), "e F d")
    }

    private fun caesarCipher(s: String, n: Int): String =
        s.map {
            when {
                it.isLowerCase() -> ('a' + (it - 'a' + n) % 26)
                it.isUpperCase() -> ('A' + (it - 'A' + n) % 26)
                else -> ' '
            }
        }.joinToString("")


    @Test
    fun `x만큼 간격이 있는 n개의 숫자`() {
        assertArrayEquals(intervalArray(2, 5), longArrayOf(2, 4, 6, 8, 10))
        assertArrayEquals(intervalArray(4, 3), longArrayOf(4, 8, 12))
        assertArrayEquals(intervalArray(-4, 2), longArrayOf(-4, -8))
    }

    private fun intervalArray(x: Int, n: Int) = LongArray(n) {
        x.toLong() * (it + 1)   // it: 현재 인덱스
    }

    private fun _intervalArray(x: Int, n: Int) =
        IntRange(1, n).map { (it * x).toLong() }.toLongArray()


    @Test
    fun `두 개 뽑아서 더하기`() {
        assertArrayEquals(pickAndAdd(intArrayOf(2, 1, 3, 4, 1)), intArrayOf(2, 3, 4, 5, 6, 7))
        assertArrayEquals(pickAndAdd(intArrayOf(4, 6, 1)), intArrayOf(5, 7, 10))
    }

    private fun pickAndAdd(num: IntArray): IntArray {
        val answer = mutableSetOf<Int>()

        for (i in 0 until num.size - 1) {
            for (j in i + 1 until num.size) {
                answer.add(num[i] + num[j])
            }
        }
        return answer.sorted().toIntArray()
    }


    @Test
    fun `정수 제곱근 판별`() {
        assertEquals(checkSquareRoot(121), 144)
        assertEquals(checkSquareRoot(3), -1)
        assertEquals(checkSquareRoot(81), 100)
        assertEquals(checkSquareRoot(50), -1)
    }

    private fun checkSquareRoot(n: Long): Long {
        val x = sqrt(n.toDouble()).toLong()
        return if (x * x == n) (x + 1) * (x + 1) else -1
    }

}