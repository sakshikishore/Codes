class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        boolean result=true;
         if(bills[0]!=5)
            {
                result=false;
              
            }
        else
            {
              h.put(5,1);
            }
        if(result!=false)
        {
        for(int i=1;i<bills.length;i++)
        {
           if(bills[i]==5)
           {
                if(!h.containsKey(5))
                {
                      h.put(5,1);
                }
                else
                 {
                      h.put(5,h.get(5)+1);
                 } 
           }
           else if(bills[i]==10)
               {
                if(h.containsKey(5))
                {
                    h.put(5,h.get(5)-1);
                    if(h.get(5)==0)
                    {
                        h.remove(5);
                    }
                    if(!h.containsKey(10))
                    {
                      h.put(10,1);
                    }
                    else
                    {
                        h.put(10,h.get(10)+1);
                    }
                }
                else
                {
                    result=false;
                    break;
                }
             }
            else
            {
                if(!h.containsKey(5))
                {
                    result=false;
                    break;
                }
                else
                {
                    if(h.containsKey(10))
                    {
                        h.put(10,h.get(10)-1);
                        if(h.get(10)==0)
                        {
                            h.remove(10);
                        }
                        h.put(5,h.get(5)-1);
                        if(h.get(5)==0)
                        {
                            h.remove(5);
                        }
                        if(!h.containsKey(20))
                        {
                          h.put(20,1);
                        }
                        else
                        {
                            h.put(20,h.get(20)+1);
                        } 
                    }
                    else
                    {
                        if(h.get(5)>=3)
                        {
                            h.put(5,h.get(5)-3);
                            if(h.get(5)==0)
                            {
                                h.remove(5);
                            }
                            
                        }
                        else
                        {
                            result=false;
                            break;
                        }
                    }
                }
            }
            
        }
        }
        return result;
    }
}
