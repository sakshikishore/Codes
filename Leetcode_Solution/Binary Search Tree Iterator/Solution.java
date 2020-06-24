/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
  ArrayList<Integer> l;
    int i=0;
    public BSTIterator(TreeNode root) {
       l=new ArrayList();
        BST(root);
        
    }
    
    public void BST(TreeNode root)
    {
        if(root!=null)
        {
            BST(root.left);
            l.add(root.val);
            BST(root.right);
        }
    }
      
    /** @return the next smallest number */
    public int next() {
        int res=l.get(i);
        i++;
        return res;
        
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    boolean result=false;
      if(l.size()>i)
      {
          result=true;
          
      }
        
        return result;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
