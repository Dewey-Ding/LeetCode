package easy;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthofBinaryTree_104 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //深度优先遍历  learning
    //用一个stack来记录当前节点的层次
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        int max = 0;
        stack.push(root);
        level.push(1);
        while(!stack.empty()){
            TreeNode treeNode = stack.pop();
            int tmp = level.pop();
            max = Math.max(max,tmp);
            if (treeNode.left != null) {
                stack.add(treeNode.left);
                level.push(tmp+1);
            }
            if (treeNode.right != null) {
                stack.add(treeNode.right);
                level.push(tmp+1);
            }
        }
        return max;
    }


    //层次遍历
    /*
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int count=0;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size>0) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                size--;
            }
            count++;
        }
        return count;
    }
    */
    //递归栈溢出
    /*
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return (1+maxDepth(root.left))>(1+maxDepth(root.right))?1+maxDepth(root.left):1+maxDepth(root.right);
    }
    */
}
