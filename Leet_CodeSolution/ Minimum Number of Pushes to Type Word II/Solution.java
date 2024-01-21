class Solution {
    public int minimumPushes(String word) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        int ch[]=new int[26];
        int ans=0;
        for(int i=0;i<word.length();i++)
        {
            ch[word.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(ch[i]!=0)
            {
                pq.add(ch[i]);
            }
        }
        int count=1;
        while(pq.size()>0)
        {
            int x=pq.poll();
            if(count<=8)
            {
                ans+=x;
            }
            else if(count>8 && count<=16)
            {
                ans+=(2*x);
            }
            else if(count>16 && count<=24)
            {
                ans+=(3*x);
            }
            else
            {
                ans+=(4*x);
            }
             count++;   
            
        }
        
        return ans;
        
    }
}
