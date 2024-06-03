package com.example.codingtest.programmers.level_1

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

class CodingTest5 {

    @Test
    fun `실패율`() {
        assertArrayEquals(failure(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)), intArrayOf(3, 4, 2, 1, 5))
        assertArrayEquals(failure(4, intArrayOf(4, 4, 4, 4, 4)), intArrayOf(4, 1, 2, 3))
    }

    private fun failure(N: Int, stages: IntArray): IntArray {
        val success = FloatArray(N + 1)
        val challenge = FloatArray(N + 1)
        val rate = FloatArray(N)

        for (i in stages.indices) {
            for (j in 0 until stages[i]) {
                challenge[j]++
                if (j != stages[i] - 1) success[j]++
            }
        }
        for (i in 0 until N) {
            if (challenge[i] == 0f) rate[i] = 0f
            else rate[i] = (challenge[i] - success[i]) / challenge[i]
        }
        val map = mutableMapOf<Int, Float>()
        for (i in 1..N) map[i] = rate[i - 1]

        val sorted = map.toList().sortedByDescending { it.second }.toMap()
        return sorted.keys.toIntArray()
    }


    @Test
    fun `하샤드 수`() {
        assertEquals(hNum(18), true)
        assertEquals(hNum(10), true)
        assertEquals(hNum(11), false)
    }

    private fun hNum(x: Int): Boolean {
        val sum = x.toString().sumOf { it.toString().toInt() }

        return x % sum == 0
    }

    private fun _hNum(x: Int) : Boolean =
        x % x.toString().sumOf { it.toString().toInt() }  == 0

    @Test
    fun `최대공약수와 최소공배수`() {
        assertArrayEquals(common(3, 12), intArrayOf(3, 12))
        assertArrayEquals(common(2, 5), intArrayOf(1, 10))
    }

    private fun common(n: Int, m: Int): IntArray {
        return intArrayOf(myFun(n, m), ((n*m)/myFun(n,m)))
    }
    private tailrec fun myFun(n: Int, m: Int): Int {
        return if (m > n) {
            if (n == 0) m else myFun(n, m % n)
        } else {
            if (m == 0) n else myFun(n % m, m)
        }
    }
}