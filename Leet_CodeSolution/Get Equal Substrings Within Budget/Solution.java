class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int sum=0,max=0,start=0;
        for(int i=0;i<s.length();i++)
        {
            int x=Math.abs((s.charAt(i)-'a')-(t.charAt(i)-'a'));
            while(x+sum>maxCost && start<=i)
            {
                sum=sum-Math.abs((s.charAt(start)-'a')-(t.charAt(start)-'a'));
                if(sum<0)
                {
                    sum=0;
                }
                start++;
            }
            if(start<=i)
            {
                sum=sum+x;
                if(i-start+1>max)
                {
                    max=i-start+1;
                }
            }

        }

        return max;
    }
}
