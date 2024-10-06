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
 public class Node
 {
    int data;
    char direc;
    public Node(int v, char d)
    {
        data=v;
        direc=d;
    }
 }
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {

        HashMap<Integer,Node> h=new HashMap<Integer,Node>();// child->parent and whichChild(L or R)
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        int count=0;
        if(root.val==startValue || root.val==destValue)
        {
            count++;
        }
        h.put(root.val,new Node(-1,'O'));
        while(q.size()>0)
        {
            int len=q.size();
            for(int i=0;i<len;i++)
            {
                TreeNode temp=q.poll();
                if(temp.left!=null)
                {
                    h.put(temp.left.val,new Node(temp.val,'L'));
                    if(temp.left.val==startValue || temp.left.val==destValue)
                    {
                        count++;

                    }
                    if(count==2)
                    {
                        break;
                    }
                    q.add(temp.left);
                }
                 if(temp.right!=null)
                {
                    h.put(temp.right.val,new Node(temp.val,'R'));
                    if(temp.right.val==startValue || temp.right.val==destValue)
                    {
                        count++;

                    }
                    if(count==2)
                    {
                        break;
                    }
                    q.add(temp.right);
                }
            }
        }
        int a=startValue,b=destValue;
       int p=startValue;
        Stack<Node> stck1=new Stack<Node>();
        Stack<Node> stck2=new Stack<Node>();
        String res="";
        while(p!=-1)
        {
            Node node=h.get(p);
            stck1.push(node);
            p=node.data;
            if(p==destValue)
            {
                for(int i=0;i<stck1.size();i++)
                {
                     res+="U";
                }
                return res;
            }
        }
        while(destValue!=-1)
        {
            Node node=h.get(destValue);
            stck2.push(node);
            destValue=node.data;
            if(destValue==startValue)
            {
               while(!stck2.empty())
               {
                 res+=stck2.pop().direc;
               }
               return res;
            }
        }
          int x=-1;
        while(!stck1.empty() && !stck2.empty() && (stck1.peek().data==stck2.peek().data ))
        {
            x=stck1.peek().data;
            stck1.pop();
            stck2.pop();
            
        }

    while(a!=x)
    {
        res+='U';
        a=h.get(a).data;
    }
    String r="";
    while(b!=x)
    {
        r=h.get(b).direc+r;
        b=h.get(b).data;
    }



   return res+r;
        
    }
}
