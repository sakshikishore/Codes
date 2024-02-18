class Solution {
    public int mostFrequentPrime(int[][] mat) {
        if(mat.length==1 && mat[0].length==1)
        {
            return -1;
        }
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                int val=mat[i][j];
                for(int k=j+1;k<mat[0].length;k++)
                {
                    val=val*10+mat[i][k];
                        if(!map.containsKey(val))
                        {
                            map.put(val,1);
                        }
                        else
                        {
                            map.put(val,map.get(val)+1);
                        }   
                }
                val=mat[i][j];
                for(int k=j-1;k>=0;k--)
                {
                     val=val*10+mat[i][k];
                        if(!map.containsKey(val))
                        {
                            map.put(val,1);
                        }
                        else
                        {
                            map.put(val,map.get(val)+1);
                        }   
                }
                val=mat[i][j];
                for(int k=i+1;k<mat.length;k++)
                {
                    val=val*10+mat[k][j];
                        if(!map.containsKey(val))
                        {
                            map.put(val,1);
                        }
                        else
                        {
                            map.put(val,map.get(val)+1);
                        }   
                }
                 val=mat[i][j];
                for(int k=i-1;k>=0;k--)
                {
                    val=val*10+mat[k][j];
                        if(!map.containsKey(val))
                        {
                            map.put(val,1);
                        }
                        else
                        {
                            map.put(val,map.get(val)+1);
                        }   
                }
                int k=j-1;
                int l=i-1;
                val=mat[i][j];
                while(l>=0 && k>=0)
                {
                    val=val*10+mat[l][k];
                        if(!map.containsKey(val))
                        {
                            map.put(val,1);
                        }
                        else
                        {
                            map.put(val,map.get(val)+1);
                        }   
                    l--;
                    k--;
                }
                
                k=j-1;
                l=i+1;
                val=mat[i][j];
                while(l<mat.length && k>=0)
                {
                    val=val*10+mat[l][k];
                        if(!map.containsKey(val))
                        {
                            map.put(val,1);
                        }
                        else
                        {
                            map.put(val,map.get(val)+1);
                        }   
                    l++;
                    k--;
                }
                k=j+1;
                l=i-1;
                val=mat[i][j];
                while(l>=0&& k<mat[0].length)
                {
                    val=val*10+mat[l][k];
                        if(!map.containsKey(val))
                        {
                            map.put(val,1);
                        }
                        else
                        {
                            map.put(val,map.get(val)+1);
                        }   
                    l--;
                    k++;
                }
                k=j+1;
                l=i+1;
                val=mat[i][j];
                while(l<mat.length && k<mat[0].length)
                {
                    val=val*10+mat[l][k];
                        if(!map.containsKey(val))
                        {
                            map.put(val,1);
                        }
                        else
                        {
                            map.put(val,map.get(val)+1);
                        }   
                    l++;
                    k++;
                }               
                
            }
        }
        int max=-1,res=-1;

        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            int val=entry.getValue();
            int key=entry.getKey();
            int flag=0;
            for(int j=2;j<=key/2;j++)
            {
                if(key%j==0)
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                if(val>max)
                {
                    max=val;
                    res=key;
                }
                else if(val==max)
                {
                    if(res<key)
                    {
                        res=key;
                    }
                }
            }
        }
       
        
        return res;
    }
}
