class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        ArrayList<Integer> al=new ArrayList<Integer>();
        int c[]=new int[nums.size()];
        for(int i=0;i<nums.size();i++)
        {
            for(int j=0;j<nums.get(i).size();j++)
            {
               int x=nums.get(i).get(j);
               if(l.size()==0)
               {
                   l.add(x);
                   al.add(i);
               }
               else if(l.size()==1)
               {
                   if(l.get(0)>x)
                   {
                       l.add(0,x);
                       al.add(0,i);
                   }
                   else
                   {
                       l.add(x);
                       al.add(i);
                   }
               }
               else
               {
                     int low=0,high=l.size()-1;
                     int index=0;
                     while(low<=high)
                     {
                         int mid=(low+high)/2;
                         if(l.get(mid)>x)
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

                     l.add(index,x);
                     al.add(index,i);
               }
            }
        }
        int p=0;
        int min=Integer.MAX_VALUE;
        int result[]=new int[2];
        for(int i=0;i<l.size();i++)
        {
           c[al.get(i)]++;
           if(i>=nums.size()-1)
           {
               int flag=0;
               while(flag==0)
               {
                    for(int j=0;j<c.length;j++)
                    {
                        if(c[j]==0)
                        {
                            flag=1;
                            break;
                        }
                    }
                    if(flag==0)
                    {
                        if(l.get(i)-l.get(p)<min)
                        {
                            min=l.get(i)-l.get(p);
                            result[0]=l.get(p);
                            result[1]=l.get(i);
                        }
                        c[al.get(p)]--;
                        p++;
                    }
               }
           }
        }

         return result;
    }
}
