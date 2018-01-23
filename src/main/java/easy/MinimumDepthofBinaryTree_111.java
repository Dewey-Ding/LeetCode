package easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree_111 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode[] treeNodes = new TreeNode[5];
        for (int i = 0; i <5 ; i++) {
            treeNodes[i] = new TreeNode(i);
        }
        treeNodes[0].left=treeNodes[1];
        treeNodes[1].left = treeNodes[2];
        //treeNodes[0].right = treeNodes[3];
        //treeNodes[3].right = treeNodes[4];
        System.out.println(minDepth1(treeNodes[0]));
    }
    public static int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        int depth = 1;
        while(!queue.isEmpty()){
            count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode tmp = queue.poll();
                if(tmp.left!=null&&tmp.right!=null){
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                }else if(tmp.left!=null){
                    queue.add(tmp.left);
                }else if(tmp.right!=null){
                    queue.add(tmp.right);
                }else{
                    return depth;
                }
            }
            depth++;
        }
        return depth;
    }
    public static int minDepth1(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if(left==0){
                return right+1;
            }else if(right == 0){
                return left+1;
            }else{
                return 1+Math.min(minDepth1(root.left),minDepth1(root.right));
            }
        }
    }
}
