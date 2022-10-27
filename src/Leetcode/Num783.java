package Leetcode;

/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void insert(TreeNode root, int newData) {
        if (root == null)
            root = new TreeNode(newData);
        else {
            TreeNode head = root; //빈 노드 찾아서 이동
            TreeNode currentNode; //leaf 노드의 자식으로 insert!

            while (true) {
                currentNode = head;
                if (head.val >= newData) {
                    head = head.left;
                    if (head == null) {
                        currentNode.left = new TreeNode(newData);
                        break;
                    }
                } else {
                    head = head.right;
                    if (head == null) {
                        currentNode.right = new TreeNode(newData);
                        break;
                    }
                }
            }
        }
    }
}

public class Num783 {
    static Integer ans = Integer.MAX_VALUE;
    static Integer pre = null;
    public static int minDiffInBST(TreeNode root) {
        if(root.left != null)
            minDiffInBST(root.left);
        if(pre != null)
            ans = Math.min(ans, root.val - pre);
        pre = root.val;
        if(root.right != null)
            minDiffInBST(root.right);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.insert(root, 4);
        root.insert(root, 2);
        root.insert(root, 1);
        root.insert(root, 3);
        root.insert(root, 6);

        int result = 0;
        result = minDiffInBST(root);
        System.out.println("result:" + result);
    }
}*/


/*class Solution {
    Integer ans = Integer.MAX_VALUE, pre = null;
    public int minDiffInBST(TreeNode root) {
        if(root.left != null)
            minDiffInBST(root.left);
        if(pre != null)
            ans = Math.min(ans, root.val -pre);
        pre = root.val;
        if(root.right != null)
            minDiffInBST(root.right);
        return ans;
    }
}*/

