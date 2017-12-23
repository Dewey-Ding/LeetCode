package easy;

import java.util.Stack;

public class SymmetricTree_101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //iteratively
    public boolean isSymmetric(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)){
            return true;
        }else if(root.left==null||root.right==null){
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.empty()){
            TreeNode tr = stack.pop();
            TreeNode tl = stack.pop();
            if(tr==null&&tl==null){
                continue;
            }else if(tr==null||tl==null){
                return false;
            }
            if(tl.val==tr.val){
                stack.push(tl.left);
                stack.push(tr.right);
                stack.push(tl.right);
                stack.push(tr.left);
            }else{
                return false;
            }
        }
        return true;
    }

    /*
    //recursively
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return symmetry(root.left,root.right);
    }
    public boolean symmetry(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }else if(left==null||right==null){
            return false;
        }
        if(left.val==right.val){
            return symmetry(left.left,right.right)&&symmetry(left.right,right.left);
        }
        return false;
    }*/
}
