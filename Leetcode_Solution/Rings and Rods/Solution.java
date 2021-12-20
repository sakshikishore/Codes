class Solution {
    public int countPoints(String rings) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int count=0;
        for(int i=0;i<rings.length();i++)
        {
            if(rings.charAt(i)>='0' && rings.charAt(i)<='9')
            {
                int p=Integer.parseInt(rings.substring(i,i+1));
                
                if(!h.containsKey(p))
                {
                    if(rings.charAt(i-1)=='B') // R=1,G=2,B=5
                    {
                        h.put(p,5);
                    }
                    else if(rings.charAt(i-1)=='R')
                    {
                        h.put(p,1);
                    }
                    else
                    {
                        h.put(p,2);
                    }
                }
                else
                {
                    int r=h.get(p);
                    if(r==8)
                    {
                        count++;
                        h.put(p,9);
                    }
                    else if(r!=9)
                    {
                        if(r==1 && rings.charAt(i-1)=='G')
                        {
                            h.put(p,3);
                        }
                       else if(r==1 && rings.charAt(i-1)=='B')
                        {
                            h.put(p,6);
                        }
                         else if(r==2 && rings.charAt(i-1)=='B')
                        {
                            h.put(p,7);
                        }
                        else if(r==2 && rings.charAt(i-1)=='R')
                        {
                            h.put(p,3);
                        }
                         else if(r==5 && rings.charAt(i-1)=='G')
                        {
                            h.put(p,7);
                        }
                          else if(r==5 && rings.charAt(i-1)=='R')
                        {
                            h.put(p,6);
                        }
                          else if(r==3 && rings.charAt(i-1)=='B')
                        {
                            count++;
                            h.put(p,9);
                        }
                           else if(r==6 && rings.charAt(i-1)=='G')
                        {
                               count++;
                            h.put(p,9);
                        }
                        else if(r==7 && rings.charAt(i-1)=='R')
                        {
                            count++;
                            h.put(p,9);
                        }
                        
                        
                    }
                }
            }
        }
        
        return count;
        
        
    }
}
