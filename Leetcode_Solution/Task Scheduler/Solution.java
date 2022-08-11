class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int ch[]=new int[26];
        for(int i=0;i<tasks.length;i++)
        {
            ch[tasks[i]-'A']++;
        }
        int i=0,maxIndex=0;
        int day=0;
        while(i<tasks.length)
        {
                day++;
                int max=0;
                for(int j=0;j<26;j++)
                {
                    if(ch[j]>max)
                    {
                        if(h.containsKey(j))
                        {
                            int x=h.get(j);
                            if(x<day)
                            {
                                  max=ch[j];
                                  maxIndex=j;
                            }
                        }
                        else
                        {
                                  max=ch[j];
                                  maxIndex=j;
                        }
                        
                    }
                }
                if(max!=0)
                {
                    ch[maxIndex]--;
                    h.put(maxIndex,day+n);
                    i++;
                }
            
        }
        return day;
    }
}
