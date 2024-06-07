package com.example.codingtest.algorithm

import java.util.LinkedList

// 백준 1260번 - DFS와 BFS
fun main() {
    val (n, m, v) = readln().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { IntArray(n + 1) }
    var visit = ArrayList<Int>()

    repeat(m) {
        val (x, y) = readln().split(" ").map { it.toInt() }

        graph[x][y] = 1
        graph[y][x] = 1
    }

    dfs(v, graph, visit)
    println()

    visit = ArrayList() // 방문 정점 초기화
    bfs(v, graph, visit)
}

fun dfs(start: Int, graph: Array<IntArray>, visit: ArrayList<Int>) {
    visit.add(start)
    print("$start ")

    for (i in 1 until graph.size) {
        if (graph[start][i] == 1 && !visit.contains(i)) {
            dfs(i, graph, visit)
        }
    }
}

fun bfs(start: Int, graph: Array<IntArray>, visit: ArrayList<Int>) {
    val queue = LinkedList<Int>()
    queue.add(start)
    visit.add(start)

    while (queue.isNotEmpty()) {
        val x = queue.poll()
        print("$x ")

        for (i in 1 until graph.size) {
            if (graph[x][i] == 1 && !visit.contains(i)) {
                queue.add(i)
                visit.add(i)
            }
        }
    }
}