class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuffer sb=new StringBuffer("");
        int ch[]=new int[26];
    PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<s.length();i++)
        {
            ch[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(ch[i]>0)
            {
                pq.add(i);
            }
        }
        while(pq.size()>0)
        {
            int x=pq.poll();
            int min=Math.min(ch[x],repeatLimit);
            for(int j=0;j<min;j++)
            {
                ch[x]--;
                sb.append((char)(97+x));
            }
            if(ch[x]!=0)
            {
                if(pq.size()>0)
                {
                    int p=pq.peek();
                    sb.append((char)(97+p));
                    ch[p]--;
                    if(ch[p]==0)
                    {
                        pq.poll();
                    }
                    pq.add(x);
                }
            }
        }
        
        return sb.toString();
    }
}
