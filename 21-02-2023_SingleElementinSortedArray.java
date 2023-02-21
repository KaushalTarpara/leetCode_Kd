// Single Element in a Sorted Array
 
//  You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.

 

// Example 1:

// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2
// Example 2:

// Input: nums = [3,3,7,7,10,11,11]
// Output: 10
 

// Constraints:

// 1 <= nums.length <= 105
// 0 <= nums[i] <= 105
class 21-02-2023_SingleElementinSortedArray{
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) { // adjust mid index to be even
                mid--;
            }
            if (nums[mid] != nums[mid+1]) { // single element is in the left half
                right = mid;
            } else { // single element is in the right half
                left = mid + 2;
            }
        }
        return nums[left];
    }
}