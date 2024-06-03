package com.example.codingtest.programmers.level_2

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.LinkedList
import java.util.Queue

class CodingTest1 {
    @Test
    fun `기능 개발`() {
        assertArrayEquals(
            functionDev(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)),
            intArrayOf(2, 1)
        )
        assertArrayEquals(
            functionDev(
                intArrayOf(95, 90, 99, 99, 80, 99),
                intArrayOf(1, 1, 1, 1, 1, 1)
            ), intArrayOf(1, 3, 2)
        )
    }

    private fun functionDev(progresses: IntArray, speeds: IntArray): IntArray {
        val queue: Queue<Int> = LinkedList()
        var leftDay: Int
        val result = mutableListOf<Int>()

        // 각 작업 완료까지 남은 일수를 큐에 추가
        for (i in progresses.indices) {
            leftDay = (100 - progresses[i]) / speeds[i]
            if ((100 - progresses[i]) % speeds[i] != 0) {
                leftDay++
            }
            queue.add(leftDay)
        }

        // 작업 진행 상황 계산
        while (queue.isNotEmpty()) {
            var count = 1
            val first = queue.poll()

            // 현재 작업보다 빨리 끝나는 작업들 카운트
            while (queue.isNotEmpty() && queue.peek()!! <= first!!) {
                queue.remove()
                count++
            }
            result.add(count)
        }
        return result.toIntArray()
    }


    @Test
    fun `N개의 최소공배수`() {
        assertEquals(nLCM(intArrayOf(2, 6, 8, 14)), 168)
        assertEquals(nLCM(intArrayOf(1, 2, 3)), 6)
    }

    private fun nLCM(arr: IntArray): Int {
        var lcm = 1

        arr.forEach { num ->
            val gcd = gcd(lcm, num)
            lcm = lcm * num / gcd
        }

        return lcm
    }

    private fun gcd(a: Int, b: Int): Int {
        // 유클리드 호제법
        return if (b == 0) a else gcd(b, a % b)
    }
}