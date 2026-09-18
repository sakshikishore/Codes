public class Node
{
    int num,totalCount;
    public Node(int n,int tc)
    {
        num=n;
        totalCount=tc;
    }
}
class Solution { 
    public long shadowPairs(int[] nums) {
        Long ans = 0l;
        Stack<Node> stck = new Stack<Node>();
        stck.push(new Node(nums[0],1));
        for (int i = 1; i < nums.length; i++) {
            while(stck.size()>0 && stck.peek().num>nums[i])
            {
                stck.pop();
            }
            if(stck.size()>0)
            {
               if(stck.peek().num==nums[i])
               {
                  Node p=stck.pop();
                  if(stck.size()>0)
                  {
                      ans+=stck.peek().totalCount;
                  }
                  stck.push(new Node(nums[i],p.totalCount+1));
               }
               else
               {
                 ans+=stck.peek().totalCount;
                 stck.push(new Node(nums[i],stck.peek().totalCount+1));
               }
            }
            else
            {
               stck.push(new Node(nums[i],1));
            }
        }

        return ans;
    }
}
