class Solution {
    public int[][] merge(int[][] intervals) {
     
        if(intervals.length>0)
        {
        for(int i=0;i<intervals.length;i++)
        {
            for(int j=i+1;j<intervals.length;j++)
            {
                if(intervals[i][0]>intervals[j][0])
                {
                    int temp=intervals[i][0];
                    intervals[i][0]=intervals[j][0];
                    intervals[j][0]=temp;
                    
                    int t=intervals[i][1];
                    intervals[i][1]=intervals[j][1];
                    intervals[j][1]=t;
                    
                }
               else if(intervals[i][0]==intervals[j][0])
               {
                   if(intervals[i][1]>intervals[j][1])
                   {
                    int temp=intervals[i][0];
                    intervals[i][0]=intervals[j][0];
                    intervals[j][0]=temp;
                    
                    int t=intervals[i][1];
                    intervals[i][1]=intervals[j][1];
                    intervals[j][1]=t;
                    
                   }
               }
            }
        }
            for(int i=0;i<intervals.length;i++)
            {
            System.out.print(intervals[i][0]+" "+intervals[i][1]+"  ");
            }
        
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(intervals[0][0]);
        int p=0;
        for(int i=0;i<intervals.length-1;i++)
        {
            if(intervals[p][1]<intervals[i+1][0])
            {
                l.add(intervals[p][1]);
                l.add(intervals[i+1][0]);
                p=i+1;
            }
            else
            {
                if(intervals[p][1]<=intervals[i+1][1])
                {
                    p=i+1;
                }
                
            }
        }
       l.add(intervals[p][1]);
        
       int arr[][]=new int[l.size()/2][2];
        int j=0;
       for(int i=0;i<l.size();i=i+2)
       {
           arr[j][0]=l.get(i);
           arr[j][1]=l.get(i+1);
           j++;
       }
             return arr;
    }
        else
        {
            return intervals;
        }
     
       
    }
}
