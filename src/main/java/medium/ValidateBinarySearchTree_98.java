package medium;


import common.TreeNode;

/**
 * @author dewey
 * @date 2019-11-04 22:05
 */
public class ValidateBinarySearchTree_98 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(1);
        head.right = new TreeNode(5);
        head.right.left = new TreeNode(4);
        head.right.right = new TreeNode(6);
        head.left.right = new TreeNode(2);
        head.left.left = new TreeNode(0);
        System.out.println(isValidBST(head));
    }

    public static boolean isValidBST(TreeNode root) {
        if(root!=null){
            if(isNodeValid(root)){
                return isValidBST(root.left)&&isValidBST(root.right);
            }else {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断当前节点是否
     * @param node
     * @return
     */
    public static boolean isNodeValid(TreeNode node){
        boolean left = true,right = true;
        if(node.left!=null){
            left = node.left.val<node.val&&maxLeftChild(node.left)<node.val;
        }
        if(node.right!=null){
            right = node.right.val>node.val&&minRightChild(node.right)>node.val;
        }
        return left&&right;
    }

    public static int minRightChild(TreeNode node) {
        while(node.left!=null&&node.left.val<node.val){
            node = node.left;
        }
        //没到最右
        if(node.left!=null){
            return Integer.MIN_VALUE;
        }
        return node.val;
    }

    public static int maxLeftChild(TreeNode node){
        while(node.right!=null&&node.right.val>node.val){
            node = node.right;
        }
        //没到最后
        if(node.right!=null){
            return Integer.MAX_VALUE;
        }
        return node.val;
    }
}
