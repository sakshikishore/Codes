import java.math.BigInteger;
class Node
{
    BigInteger val;
    BigInteger count;
    public Node(BigInteger v, BigInteger c)
    {
        val=v;
        count=c;
    }
}
class Solution {
    public int sumOfGoodSubsequences(int[] nums) {
       HashMap<Integer,Node> h=new HashMap<Integer,Node>();
       BigInteger totalSum=BigInteger.valueOf(0);
       for(int i=0;i<nums.length;i++)
       {
         if(i==0)
         {
            h.put(nums[i],new Node(BigInteger.valueOf(nums[i]),BigInteger.valueOf(1)));
            totalSum=totalSum.add(BigInteger.valueOf(nums[i]));
         }
         else
         {
            int p=nums[i]-1;
            int q=nums[i]+1;
             BigInteger sum=BigInteger.valueOf(nums[i]);
            BigInteger totalCount=BigInteger.valueOf(1);
            if(h.containsKey(p))
            {
                Node n=h.get(p);
                     BigInteger x=n.count;
                     x=x.multiply(BigInteger.valueOf(nums[i]));
                     x=x.mod(BigInteger.valueOf(1000000007));
                    sum=sum.add(n.val);
                    sum=sum.add(x);
                    sum=sum.mod(BigInteger.valueOf(1000000007));
                    totalCount=totalCount.add(n.count);
            }
            if(h.containsKey(q))
            {
                     Node n=h.get(q);
                     BigInteger x=n.count;
                     x=x.multiply(BigInteger.valueOf(nums[i]));
                     x=x.mod(BigInteger.valueOf(1000000007));
                    sum=sum.add(n.val);
                    sum=sum.add(x);
                    sum=sum.mod(BigInteger.valueOf(1000000007));
                    totalCount=totalCount.add(n.count);
            }
            totalSum=totalSum.add(sum);
            totalSum=totalSum.mod(BigInteger.valueOf(1000000007));
            if(h.containsKey(nums[i]))
            {
                Node node=h.get(nums[i]);
                h.put(nums[i],new Node(node.val.add(sum),node.count.add(totalCount)));
                
            }
            else
            {
                 h.put(nums[i],new Node(sum,totalCount));
            }
         }
       }

       return totalSum.intValue();
    }
}
