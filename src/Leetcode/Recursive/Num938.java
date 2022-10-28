package Leetcode.Recursive;


import Tree.BinarySearchTree;

public class Num938 {

    static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    static int ans = 0;
    public static void insert_node(TreeNode root, int val){
        if(root == null)
            root.val = val;
        else{
            TreeNode head = root;
            TreeNode CurrentNode = head;
            while(true){
                CurrentNode = head;
                if(root.val >= val){
                    head = head.left;
                    if(head == null){
                        CurrentNode.left.val = val;
                        break;
                    }
                }
                else{
                    head = head.right;
                    if(head == null){
                        CurrentNode.right.val = val;
                    }
                }
            }
        }

    }
    public static void inorder(TreeNode root, int low, int high){
        if(root == null) return;
        inorder(root.left, low, high);
        System.out.println(root.val);
        inorder(root.right, low, high);
    }
    public static int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root, low, high);
        return ans;
    }
    public static int main(String[] args) {
        TreeNode root = new TreeNode();
        insert_node(root, 10);
        insert_node(root, 5);
        insert_node(root, 16);
        insert_node(root, 3);
        insert_node(root, 7);
        insert_node(root, 18);
        int answer = 0;
        int low = 7;
        int high = 15;
        answer = rangeSumBST(root, low, high);
        return answer;
    }

}

/*
class Solution {


    private void preorder(TreeNode root, int left, int right) {
        if (root == null)  return;
        if (root.val >= left && root.val <= right) {
            ans += root.val;
        }
        preorder(root.left, left, right);
        preorder(root.right, left, right);
    }
}*/
