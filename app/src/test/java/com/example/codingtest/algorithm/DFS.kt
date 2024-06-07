package com.example.codingtest.algorithm

import java.util.LinkedList

fun bfs(graph: Map<Int, List<Int>>, start: Int): Set<Int> {
    val visited = mutableSetOf<Int>()
    val queue = LinkedList<Int>()

    queue.add(start)
    while (queue.isNotEmpty()) {
        val vertex = queue.removeFirst()
        if (vertex !in visited) {
            visited.add(vertex)
            graph[vertex]?.let { neighbors ->
                queue.addAll(neighbors.filterNot {
                    it in visited
                })
            }
        }
    }
    return visited
}