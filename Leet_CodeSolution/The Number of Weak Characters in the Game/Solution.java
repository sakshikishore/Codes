class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<properties.length;i++)
        {
            if(!h.containsKey(properties[i][0]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(properties[i][1]);
                h.put(properties[i][0],l);
                list.add(properties[i][0]);
            }
            else
            {
                 ArrayList<Integer> l=h.get(properties[i][0]);
                 int low=0,high=l.size()-1,index=0;
                 while(low<=high)
                 {
                      int mid=(low+high)/2;
                      if(l.get(mid)>properties[i][1])
                      {
                          index=mid;
                          high=mid-1;
                      }
                      else
                      {
                          index=mid+1;
                          low=mid+1;

                      }
                 }
                 l.add(index,properties[i][1]);
                 h.put(properties[i][0],l);
            }
        }
        Collections.sort(list);
        int arr[]=new int[list.size()];
        int max=0;
        for(int i=list.size()-1;i>=0;i--)
        {
             ArrayList<Integer> l=h.get(list.get(i));
             if(l.get(l.size()-1)>max)
             {
                 max=l.get(l.size()-1);
             }
             arr[i]=max;
        }
       int result=0;
        for(int i=0;i<list.size()-1;i++)
        {
             ArrayList<Integer> l=h.get(list.get(i));
             int index=0,low=0,high=l.size()-1;
             while(low<=high)
             {
                 int mid=(low+high)/2;
                 if(l.get(mid)>=arr[i+1])
                 {
                     index=mid;
                     high=mid-1;
                 }
                 else
                 {
                     index=mid+1;
                     low=mid+1;
                 }
             }
             result+=index;
        }

        return result;

    }
}
