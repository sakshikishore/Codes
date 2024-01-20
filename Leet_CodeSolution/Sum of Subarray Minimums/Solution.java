class Node
{
    int index;
    int val;
    public Node(int index, int val)
    {
        this.index=index;
        this.val=val;
    }
}
class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Node> stck=new Stack<Node>();
        Node node=new Node(arr.length-1,arr[arr.length-1]);
        stck.push(node);
        long ans=0;
        for(int i=arr.length-2;i>=0;i--)
        {
           while(!stck.empty() && arr[stck.peek().index]>arr[i])
           {
               
               ans=ans+stck.pop().val;
               ans=ans%(1000000007);
           }
           if(stck.empty())
           {
               node=new Node(i,(arr.length-i)*arr[i]);
               stck.push(node);
           }
           else
           {
               node=new Node(i,(stck.peek().index-i)*arr[i]+stck.peek().val);
               stck.push(node); 
           }
        }
        while(!stck.empty())
        {
              ans+=stck.pop().val;
              ans=ans%(1000000007);
        }

        return (int)ans;
    }
}
