import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//  IPO
// Hard
// 1.8K
// 129
// Companies
// Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

// You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.

// Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

// Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.

// The answer is guaranteed to fit in a 32-bit signed integer.

 

// Example 1:

// Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
// Output: 4
// Explanation: Since your initial capital is 0, you can only start the project indexed 0.
// After finishing it you will obtain profit 1 and your capital becomes 1.
// With capital 1, you can either start the project indexed 1 or the project indexed 2.
// Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
// Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
// Example 2:

// Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
// Output: 6
 
// Constraints:

// 1 <= k <= 105
// 0 <= w <= 109
// n == profits.length
// n == capital.length
// 1 <= n <= 105
// 0 <= profits[i] <= 104
// 0 <= capital[i] <= 109


class Project {
    int profit;
    int capital;

    public Project(int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }
}

public class 23-02-2023_IPO{
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Create a list of projects
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            projects.add(new Project(profits[i], capital[i]));
        }

        // Sort projects by capital in increasing order
        Collections.sort(projects, (a, b) -> a.capital - b.capital);

        // Use a max heap to store the profits of available projects
        PriorityQueue<Project> maxHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);

        // Start with the initial capital
        int availableCapital = w;

        // Iterate k times to choose k projects
        for (int i = 0; i < k; i++) {
            // Add all projects with capital less than or equal to available capital to the max heap
            while (!projects.isEmpty() && projects.get(0).capital <= availableCapital) {
                maxHeap.add(projects.get(0));
                projects.remove(0);
            }

            // If there are no available projects, break the loop
            if (maxHeap.isEmpty()) {
                break;
            }

            // Choose the project with the highest profit and add its profit to available capital
            availableCapital += maxHeap.remove().profit;
        }

        return availableCapital;
    }
}
