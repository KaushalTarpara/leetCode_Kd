import java.util.*;

// Jump Game IV
// Hard
// 2.3K
// 88
// Companies
// Given an array of integers arr, you are initially positioned at the first index of the array.

// In one step you can jump from index i to index:

// i + 1 where: i + 1 < arr.length.
// i - 1 where: i - 1 >= 0.
// j where: arr[i] == arr[j] and i != j.
// Return the minimum number of steps to reach the last index of the array.

// Notice that you can not jump outside of the array at any time.

 

// Example 1:

// Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
// Output: 3
// Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
// Example 2:

// Input: arr = [7]
// Output: 0
// Explanation: Start index is the last index. You do not need to jump.
// Example 3:

// Input: arr = [7,6,9,6,9,6,9,7]
// Output: 1
// Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 

// Constraints:

// 1 <= arr.length <= 5 * 104
// -108 <= arr[i] <= 108

class 05-03-2023_JumpGameIV {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == n - 1) return steps;
                List<Integer> nextPositions = map.get(arr[cur]);
                if (cur > 0 && !visited[cur - 1]) {
                    queue.offer(cur - 1);
                    visited[cur - 1] = true;
                }
                if (cur < n - 1 && !visited[cur + 1]) {
                    queue.offer(cur + 1);
                    visited[cur + 1] = true;
                }
                for (int next : nextPositions) {
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
                nextPositions.clear();
            }
            steps++;
        }
        return -1;
    }
}
