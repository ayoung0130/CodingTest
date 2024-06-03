package com.example.codingtest.backjoon

import org.junit.Assert.assertEquals
import org.junit.Test

class JosephusProblem0 {

    @Test
    fun `요세푸스 문제 0(11866)`() {
        assertEquals(josephusProblem0(7, 3), arrayListOf(3, 6, 2, 7, 5, 1, 4))
        assertEquals(josephusProblem0(10, 2), arrayListOf(2, 4, 6, 8, 10, 3, 7, 1, 9, 5))
    }

    private fun josephusProblem0(n: Int, k: Int): List<Int> {
        val people = (1..n).toMutableList()
        val ans = mutableListOf<Int>()
        var idx = 0

        while (people.isNotEmpty()) {
            idx = (idx + k - 1) % people.size
            ans.add(people.removeAt(idx))
        }

        return ans
    }
}