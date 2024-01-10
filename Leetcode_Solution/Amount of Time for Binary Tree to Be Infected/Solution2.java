 class Node
 {
     int parent;
     int leftChild;
     int rightChild;
     public Node(int parent,int leftChild,int rightChild)
     {
         this.parent=parent;
         this.leftChild=leftChild;
         this.rightChild=rightChild;
     }
 }
 class Timer
 {
   int node;
   int time;
   public Timer(int node, int time)
   {
       this.node=node;
       this.time=time;
   }
 }
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashSet<Integer> hset=new HashSet<Integer>();
        HashMap<Integer,Integer> childParent=new HashMap<Integer,Integer>();
        HashMap<Integer,Node> map=new HashMap<Integer,Node>();
        childParent.put(root.val,-1);
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while(q.size()>0)
        {
            TreeNode temp=q.poll();
            int parent=childParent.get(temp.val);
            int leftChild=-1,rightChild=-1;
            if(temp.left!=null)
            {
                childParent.put(temp.left.val,temp.val);
                leftChild=temp.left.val;
                 q.add(temp.left);
            }
            if(temp.right!=null)
            {
                 childParent.put(temp.right.val,temp.val);
                 rightChild=temp.right.val;
                 q.add(temp.right);
            }
            Node node=new Node(parent,leftChild,rightChild);
            map.put(temp.val,node);
        }
        Queue<Timer> qu=new LinkedList<Timer>();
        Timer data=new Timer(start,0);
        hset.add(start);
        qu.add(data);
        int time=0;
        while(qu.size()>0)
        {
            data=qu.poll();
            time=data.time;
            int node=data.node;
            Node ptr=map.get(node);
            if(ptr.parent!=-1 && !hset.contains(ptr.parent))
            {
                hset.add(ptr.parent);
                Timer p=new Timer(ptr.parent,time+1);
                qu.add(p);
            }
            if(ptr.leftChild!=-1 && !hset.contains(ptr.leftChild))
            {
                hset.add(ptr.leftChild);
                Timer p=new Timer(ptr.leftChild,time+1);
                qu.add(p);
            }
             if(ptr.rightChild!=-1 && !hset.contains(ptr.rightChild))
            {
                hset.add(ptr.rightChild);
                Timer p=new Timer(ptr.rightChild,time+1);
                qu.add(p);
            }
        }

        return time;
    }
}
