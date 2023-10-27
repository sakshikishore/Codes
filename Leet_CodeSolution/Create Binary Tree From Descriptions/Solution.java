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
    public TreeNode createBinaryTree(int[][] descriptions) {
      HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
     HashSet<Integer> hset=new HashSet<Integer>();
      for(int i=0;i<descriptions.length;i++)
      {
          hset.add(descriptions[i][1]);
          if(!h.containsKey(descriptions[i][0]))
          {
              ArrayList<Integer> l=new ArrayList<Integer>();
              if(descriptions[i][2]==1)
              {
                 l.add(1);
                 l.add(descriptions[i][1]);
              }
              else
              {
                  l.add(0);
                  l.add(descriptions[i][1]);
              }
              h.put(descriptions[i][0],l);
          }
          else
          {
              ArrayList<Integer> l=h.get(descriptions[i][0]);
              if(descriptions[i][2]==1)
              {
                  l.add(0,descriptions[i][1]);
                  l.add(0,1);
                   h.put(descriptions[i][0],l);
              }
              else
              {
                  l.add(0);
                  l.add(descriptions[i][1]);
                  h.put(descriptions[i][0],l);
              }
          }
      }
      TreeNode root=null;
      for(Map.Entry<Integer,ArrayList<Integer>> entry:h.entrySet())
      {
          int parent=entry.getKey();
          if(!hset.contains(parent))
          {
              root=new TreeNode(parent,null,null);
              break;
          }
      }
     Queue<TreeNode> q=new LinkedList<TreeNode>();
     q.add(root);
     while(q.size()>0)
     {
         TreeNode temp=q.poll();
         if(h.containsKey(temp.val))
         {
             ArrayList<Integer> l=h.get(temp.val);
             if(l.size()==4)
             {
                 temp.left=new TreeNode(l.get(1),null,null);
                 q.add(temp.left);
                 temp.right=new TreeNode(l.get(3),null,null);
                 q.add(temp.right);
             }
             else if(l.size()==2)
             {
                 if(l.get(0)==1)
                 {
                     temp.left=new TreeNode(l.get(1),null,null);
                     q.add(temp.left);
                 }
                 else
                 {
                      temp.right=new TreeNode(l.get(1),null,null);
                      q.add(temp.right);
                 }

             }
         }
     }
      return root;
    }
}
