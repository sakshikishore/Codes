class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(obstacles[0]);
        int result[]=new int[obstacles.length];
        result[0]=1;
        for(int i=1;i<obstacles.length;i++)
        {
             int val=obstacles[i];
             int low=0,high=l.size()-1;
             int index=0;
             while(low<=high)
             {
                 int mid=(low+high)/2;
                 if(l.get(mid)<=val)
                 {
                     index=mid+1;
                     low=mid+1;
                 }
                 else
                 {
                     index=mid;
                     high=mid-1;
                 }
             }
             if(index==l.size())
             {
                 result[i]=l.size()+1;
                 l.add(val);
             }
             else
             {
                 l.remove(index);
                 l.add(index,val);
                 result[i]=index+1;
             }
        }

        return result;
    }
}
