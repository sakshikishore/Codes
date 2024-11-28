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
    public int countPairs(TreeNode root, int distance) {
        int result=0;
        HashMap<TreeNode,TreeNode> map=new HashMap<TreeNode,TreeNode>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        map.put(root,null);
        ArrayList<TreeNode> list=new ArrayList<TreeNode>();
        while(q.size()>0)
        {
            TreeNode temp=q.poll();
            if(temp.left==null && temp.right==null)
            {
                list.add(temp);
            }
            if(temp.left!=null)
            {
                map.put(temp.left,temp);
                q.add(temp.left);
            }
            if(temp.right!=null)
            {
                q.add(temp.right);
                map.put(temp.right,temp);
            }
        }

        for(int i=0;i<list.size();i++)
        {
            TreeNode a=list.get(i);
            for(int j=i+1;j<list.size();j++)
            {
                TreeNode b=list.get(j);
                HashMap<TreeNode,Integer> h=new HashMap<TreeNode,Integer>();
                h.put(b,0);
                TreeNode temp=b;
                int count=0;
                while(temp!=null)
                {
                    temp=map.get(temp);
                    count++;
                    if(temp!=null)
                    {
                       h.put(temp,count); 
                    }
                }
              temp=a;
              count=0;
              while(temp!=null)
                {
                    if(h.containsKey(temp))
                    {
                        count+=h.get(temp);
                        break;
                    }
                      temp=map.get(temp);
                    count++;
                  
                }

              if(count<=distance)
              {
                result++;
              }


            }
        }

        return result;
    }
}
