class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> l=new ArrayList<Long>();
        if(finalSum%2==0)
        {
           long r=0;
           while(finalSum!=0)
           {
              if(finalSum-(r+2)>=(r+4))
              {
                  r=r+2;
                  l.add(r);
                  finalSum=finalSum-r;
              }
               else
               {
                   l.add(finalSum);
                   break;
               }
           }
        }
        
        return l;
        
    }
}
