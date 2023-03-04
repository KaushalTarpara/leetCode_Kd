//  Find Duplicate Subtrees
// Medium
// 4K
// 341
// Companies
// Given the root of a binary tree, return all duplicate subtrees.

// For each kind of duplicate subtrees, you only need to return the root node of any one of them.

// Two trees are duplicate if they have the same structure with the same node values.

 

// Example 1:


// Input: root = [1,2,3,4,null,2,4,null,null,4]
// Output: [[2,4],[4]]
// Example 2:


// Input: root = [2,1,1]
// Output: [[1]]
// Example 3:


// Input: root = [2,2,2,3,null,3,null]
// Output: [[2,3],[3]]
 

// Constraints:

// The number of the nodes in the tree will be in the range [1, 5000]
// -200 <= Node.val <= 200

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class 28-02-2023_FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
          List<TreeNode> duplicates = new ArrayList<>();
          Map<String, List<TreeNode>> map = new HashMap<>();
          generateIdentifier(root, map, duplicates);
          return duplicates;
      }
      
      private String generateIdentifier(TreeNode node, Map<String, List<TreeNode>> map, List<TreeNode> duplicates) {
          if (node == null) {
              return "#";
          }
          String identifier = node.val + "," + generateIdentifier(node.left, map, duplicates) + "," + generateIdentifier(node.right, map, duplicates);
          List<TreeNode> nodes = map.getOrDefault(identifier, new ArrayList<>());
          nodes.add(node);
          map.put(identifier, nodes);
          if (nodes.size() == 2) {
              duplicates.add(nodes.get(0));
          }
          return identifier;
      }
  }