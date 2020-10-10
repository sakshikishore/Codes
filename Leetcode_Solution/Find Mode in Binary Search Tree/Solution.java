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
class Solution {
    HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
    public int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        else
        {
            int hleft=height(root.left);
            int hright=height(root.right);
            if(hleft>hright)
            {
                return hleft+1;
            }
            else
            {
                return hright+1;
            }
        }
    }
    public void levelOrder(TreeNode root,int level)
    {
        if(root!=null)
        {
            if(level==0)
            {
                if(!h.containsKey(root.val))
                {
                      h.put(root.val,1);
                }
                else
                {
                    h.put(root.val,h.get(root.val)+1);
                }
                
            }
            else
            {
                levelOrder(root.left,level-1);
                levelOrder(root.right,level-1);
            }
                
        }
    }
    public int[] findMode(TreeNode root) {
        
        for(int i=0;i<height(root);i++)
        {
            levelOrder(root,i);
        }
        
        int max=0;
       
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> m:h.entrySet())
        {
            if(m.getValue()>max)
            {
                max=m.getValue();
                
            }
        }
        
        for(Map.Entry<Integer,Integer> m:h.entrySet())
        {
            if(m.getValue()==max)
            {
                l.add(m.getKey());
                
            }
        }
        
        int result[]=new int[l.size()];
        for(int i=0;i<l.size();i++)
        {
            result[i]=l.get(i);
        }
        
        return result;
        
    }
}
