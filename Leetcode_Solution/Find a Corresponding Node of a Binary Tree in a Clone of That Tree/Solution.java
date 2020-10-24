/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode result=null;
      Stack<TreeNode> stck1=new Stack<TreeNode>();
      Stack<TreeNode> stck2=new Stack<TreeNode>();
      if(original!=null)
      {
          stck1.push(original);
          stck2.push(cloned);
          while(!stck1.empty())
          {
              TreeNode p=stck1.pop();
              TreeNode q=stck2.pop();
              if(p==target)
              {
                  result=q;
                  break;
              }
              if(p.right!=null)
              {
                  stck1.push(p.right);
                  stck2.push(q.right);
              }
              if(p.left!=null)
              {
                  stck1.push(p.left);
                  stck2.push(q.left);
              }
          }
      }
        return result;
        
    }
}
