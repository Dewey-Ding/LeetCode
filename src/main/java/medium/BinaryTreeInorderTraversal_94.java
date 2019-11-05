package medium;


import common.TreeNode;
import common.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dewey
 * @date 2019/4/8 15:39
 */
public class BinaryTreeInorderTraversal_94 {

    public static void main(String args[]){
        TreeNode[] treeNodes = new TreeNode[3];
        for (int i = 0; i < 3; i++) {
            treeNodes[i] = new TreeNode(i+1);
        }
        treeNodes[0].right = treeNodes[1];
        treeNodes[1].left = treeNodes[2];
        List<Integer> list = inorderTraversal(treeNodes[0]);
        System.out.println(list.toString());
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(result,root);
        return result;
    }
    public static void helper(List<Integer> result,TreeNode root){
        if(root==null){
            return;
        }
        helper(result,root.left);
        result.add(root.val);
        helper(result,root.right);
    }
}
