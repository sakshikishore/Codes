class Solution {
    public int twoCitySchedCost(int[][] costs) {
       ArrayList<Integer> l=new ArrayList<Integer>();
      ArrayList<Integer> m=new ArrayList<Integer>();
        int costA=0;
        int costB=0;
       for(int i=0;i<costs.length;i++)
       {
           if(costs[i][0]>costs[i][1])
           {
               l.add(i);
               costA=costA+costs[i][1];
           }
           else
           {
               m.add(i);
               costB=costB+costs[i][0];
           }
       }
        if(l.size()>costs.length/2)
        {
            for(int i=0;i<l.size();i++)
            {
                for(int j=i+1;j<l.size();j++)
                {
                    if(Math.abs(costs[l.get(i)][1]-costs[l.get(i)][0])<Math.abs(costs[l.get(j)][1]-costs[l.get(j)][0]))
                    {
                        int temp=costs[l.get(i)][1];
                        costs[l.get(i)][1]=costs[l.get(j)][1];
                        costs[l.get(j)][1]=temp;
                        
                        int t=costs[l.get(i)][0];
                        costs[l.get(i)][0]=costs[l.get(j)][0];
                        costs[l.get(j)][0]=t;
                    }
                        
                }
            }
            for(int j=(costs.length/2);j<l.size();j++)
            {
                costA=costA-costs[l.get(j)][1];
                costB=costB+costs[l.get(j)][0];
                                      
            }
            
        }
        if(m.size()>costs.length/2)
        {
            for(int i=0;i<m.size();i++)
            {
                for(int j=i+1;j<m.size();j++)
                {
                    if(Math.abs(costs[m.get(i)][1]-costs[m.get(i)][0])<Math.abs(costs[m.get(j)][1]-costs[m.get(j)][0]))
                    {
                        int temp=costs[m.get(i)][1];
                        costs[m.get(i)][1]=costs[m.get(j)][1];
                        costs[m.get(j)][1]=temp;
                        
                        int t=costs[m.get(i)][0];
                        costs[m.get(i)][0]=costs[m.get(j)][0];
                        costs[m.get(j)][0]=t;
                    }
                }
            }
            
            for(int j=(costs.length/2);j<m.size();j++)
            {
                costB=costB-costs[m.get(j)][0];
                costA=costA+costs[m.get(j)][1];
                
            }
        }
        
       
        return costA+costB;
        
    }
}
