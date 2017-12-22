package easy;

import java.util.Stack;

public class SameTree_100 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode[] p = new TreeNode[3];
        TreeNode[] q = new TreeNode[3];
        for(int i=0;i<3;i++){
            p[i] = new TreeNode(i);
            q[i] = new TreeNode(i);
        }
        p[0].val=1;
        p[0].left = p[1];
        p[0].right = p[2];
        p[1].val=2;
        p[1].left = null;
        p[1].right = null;
        p[2].val=3;
        p[2].left = null;
        p[2].right = null;

        q[0].val=1;
        q[0].left = p[1];
        q[0].right = p[2];
        q[1].val=2;
        q[1].left = null;
        q[1].right = null;
        q[2].val=3;
        q[2].left = null;
        q[2].right = null;
        System.out.println(isSameTree(p[0],q[0]));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null&&q==null){
            return true;
        }else if(p==null||q==null){
            return false;
        }
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();

        pStack.push(p);
        qStack.push(q);

        while (!(pStack.isEmpty() && qStack.isEmpty())) {
            TreeNode nq = qStack.pop();
            TreeNode np = pStack.pop();

            if (nq.val != np.val) {
                return false;
            }
            if (nq.left != null) {
                qStack.push(nq.left);
            }
            if (np.left != null) {
                pStack.push(np.left);
            }

            if (qStack.size() != pStack.size()) {
                return false;
            }

            if (nq.right != null) {
                qStack.push(nq.right);
            }
            if (np.right != null) {
                pStack.push(np.right);
            }
            if (pStack.size() != qStack.size()) {
                return false;
            }
        }
        return pStack.size() == qStack.size();
    }
  /*  public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }else if(p==null||q==null||p.val!=q.val){
            return false;
        }
        return isSameTree(p.right,q.right)&&isSameTree(p.left,q.left);
    }*/
}
