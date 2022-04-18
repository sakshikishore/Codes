class Solution {
    public int minimumRounds(int[] tasks) {
     HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int result=0;
        for(int i=0;i<tasks.length;i++)
        {
            if(!h.containsKey(tasks[i]))
            {
                h.put(tasks[i],1);
            }
            else
            {
                h.put(tasks[i],h.get(tasks[i])+1);
            }
        }
        
        for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
            int p=entry.getValue();
            int flag=0;
            int rounds=0;
            while(flag!=1)
            {
                if(p==3)
                {
                    rounds+=1;
                    flag=1;
                }
                else if(p==2)
                {
                    rounds+=1;
                    flag=1;
                }
                else if(p==1)
                {
                    result=-1;
                    break;
                }
                else
                {
                    if(p%2!=0)
                    {
                        rounds=rounds+1;
                        p=p-3;
                    }
                    else if(p%3==0)
                    {
                        rounds+=(p/3);
                        flag=1;
                    }
                    else
                    {
                        rounds=rounds+1;
                        p=p-2;
                    }
                }
                
            }
            if(result==-1)
            {
                break;
            }
            else
            {
                result=result+rounds;
            }
        }
        
        return result;
        
    }
}
