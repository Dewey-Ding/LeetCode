package medium;


import common.TreeNode;
import common.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dewey
 * @date 2019/4/8 15:52
 */
public class UniqueBinarySearchTreesII_95 {
    public static void main(String[] args) {
        List<TreeNode> result = generateTrees(0);
        System.out.println(result.size());
        System.out.println(result.toString());
        for(TreeNode one:result){
            Printer.printTree(one);
            System.out.println();
        }
    }
    public static List<TreeNode> generateTrees(int n) {

        if(n<=0){
            return new ArrayList<TreeNode>();
        }
        return Helper(1,n);

    }
    public static List<TreeNode> Helper(int start,int end){
        List<TreeNode> result = new ArrayList<>();

        if(end<=0){
            return result;
        }
        if(start>end){
            //如果不添加元素在进行后续的for遍历时会直接弹出
            result.add(null);
            return result;
        }
        if(start==end){
            result.add(new TreeNode(start));
            return result;
        }

        List<TreeNode> left,right;

        for (int i = start; i <= end; i++) {
            left = Helper(start,i-1);
            right = Helper(i+1,end);
            for (TreeNode oneLeft:left) {
                for(TreeNode oneRight:right){
                    TreeNode root = new TreeNode(i);
                    root.left = oneLeft;
                    root.right = oneRight;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
