// Convert Sorted List to Binary Search Tree
// Medium
// 5.6K
// 129
// Companies
// Given the head of a singly linked list where elements are sorted in ascending order, convert it to a 
// height-balanced
//  binary search tree.

 

// Example 1:


// Input: head = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
// Example 2:

// Input: head = []
// Output: []
 

// Constraints:

// The number of nodes in head is in the range [0, 2 * 104].
// -105 <= Node.val <= 105

class 11-03-2023_ConvertSortedListtoBinarySearchTre {
    private ListNode current;
    
    public TreeNode sortedListToBST(ListNode head) {
        int size = getSize(head);
        current = head;
        return buildBST(0, size - 1);
    }
    
    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    
    private TreeNode buildBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode left = buildBST(start, mid - 1);
        TreeNode node = new TreeNode(current.val);
        current = current.next;
        TreeNode right = buildBST(mid + 1, end);
        node.left = left;
        node.right = right;
        return node;
    }
}