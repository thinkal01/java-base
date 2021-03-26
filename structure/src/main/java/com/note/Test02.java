package com.note;

import org.junit.Test;

import java.util.*;

public class Test02 {
    @Test
    public void test() {
        char[][] grid = new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        int[][] prerequisites = new int[][]{{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}};
        System.out.println(canFinish(2, prerequisites));
    }

    Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; ++i) {
            if (!map.containsKey(prerequisites[i][0])) map.put(prerequisites[i][0], new ArrayList<>());
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            if (!dfs(iterator.next())) {
                return false;
            }
        }

        return true;
    }

    List<Integer> path = new ArrayList();
    boolean result = true;

    private boolean dfs(int course) {
        if (path.contains(course)) {
            result = false;
        }

        path.add(course);

        if (!result) return false;

        List<Integer> list = map.get(course);
        if (list == null) return true;

        for (int i = 0; i < list.size(); ++i) {
            dfs(list.get(i));
            path.remove(path.size() - 1);
        }

        return true;
    }
}
