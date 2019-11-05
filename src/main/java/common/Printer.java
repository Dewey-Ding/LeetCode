package common;

import common.TreeNode;

/**
 * @author dewey
 * @date 2019/4/8 15:57
 */
public class Printer {
    public static void printTree(TreeNode root){
        if(root!=null){
            System.out.print(root.val);
            printTree(root.left);
            printTree(root.right);
        }
    }
}
