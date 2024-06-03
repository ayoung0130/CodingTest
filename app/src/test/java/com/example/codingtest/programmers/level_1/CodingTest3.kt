package com.example.codingtest.programmers.level_1

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Stack

class CodingTest3 {

    @Test
    fun `햄버거 만들기`() {
        assertEquals(toMakeHamburger(intArrayOf(1, 2, 3, 1)), 1)
        assertEquals(toMakeHamburger(intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1)), 2)
        assertEquals(toMakeHamburger(intArrayOf(1, 2, 3)), 0)
        assertEquals(toMakeHamburger(intArrayOf(1, 3, 2, 1, 2, 1, 3, 1, 2)), 0)
    }

    private fun toMakeHamburger(ingredient: IntArray): Int {
        var answer: Int = 0
        val s = Stack<Int>()

        for (i in ingredient) {
            s.push(i)

            if (s.size >= 4) {
                val peek1 = s.peek()
                s.pop()
                val peek2 = s.peek()
                s.pop()
                val peek3 = s.peek()
                s.pop()
                val peek4 = s.peek()
                s.pop()

                if ((peek4 == 1) && (peek3 == 2) && (peek2 == 3) && (peek1 == 1)) answer++
                else {
                    s.push(peek4)
                    s.push(peek3)
                    s.push(peek2)
                    s.push(peek1)
                }
            }
        }
        return answer
    }


    @Test
    fun `콜라 문제`() {
        assertEquals(coke(2, 1, 20), 19)
        assertEquals(coke(3, 1, 20), 9)
        assertEquals(coke(4, 2, 20), 18)
    }

    private fun coke(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        var num = n

        while (num >= a) {
            var r = num % a
            num = (num - r) / a * b
            answer += num
            num += r
        }
        return answer
    }


    @Test
    fun `삼총사`() {
        assertEquals(three(intArrayOf(-2, 3, 0, 2, -5)), 2)
        assertEquals(three(intArrayOf(-3, -2, -1, 0, 1, 2, 3)), 5)
        assertEquals(three(intArrayOf(-1, 1, -1, 1)), 0)
    }

    private fun three(number: IntArray): Int {
        var answer: Int = 0
        val n = number.size

        for (i in 0 until n - 2) {
            for (j in i + 1 until n - 1) {
                for (k in j + 1 until n) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++
                    }
                }
            }
        }

        return answer
    }


    @Test
    fun `나머지가 1이 되는 수 찾기`() {
        assertEquals(toFindNum(10), 3)
        assertEquals(toFindNum(12), 11)
        assertEquals(toFindNum(21), 2)
    }

    private fun toFindNum(n: Int): Int {
        for (i in 1 until n) {
            if (n % i == 1) {
                return i
            }
        }
        return 0
    }


    @Test
    fun `내적`() {
        assertEquals(_innerProduct(intArrayOf(1, 2, 3, 4), intArrayOf(-3, -1, 0, 2)), 3)
        assertEquals(_innerProduct(intArrayOf(-1, 0, 1), intArrayOf(1, 0, -1)), -2)
    }

    private fun innerProduct(a: IntArray, b: IntArray): Int {
        var answer: Int = 0

        for (i in 0 until a.size) {
            answer += a[i] * b[i]   // a.size = b.size 이므로
        }

        return answer
    }
    private fun _innerProduct(a: IntArray, b: IntArray): Int =
        a.zip(b).map { it.first * it.second }.sum()


    @Test
    fun `3진법 뒤집기`() {
        assertEquals(flipflopNum(45), 7)
        assertEquals(flipflopNum(125), 229)
    }

    private fun flipflopNum(n: Int): Int =
        n.toString(3).reversed().toInt(3)


}