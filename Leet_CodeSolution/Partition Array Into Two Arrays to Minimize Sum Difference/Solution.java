class Solution {
    int res=Integer.MAX_VALUE;
    public void Solve(int nums[],HashMap<Integer,ArrayList<Integer>> h,int i, int count,int total)
    {
         if(count!=0)
        {
            if(!h.containsKey(count))
            {
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(total);
                h.put(count,list);
                
               
            }
            else
            {
               ArrayList<Integer> list=h.get(count);
               int low=0,high=list.size()-1;
               int flag=0,index=0;
               while(low<=high)
               {
                   int mid=(low+high)/2;
                   if(list.get(mid)==total)
                   {
                       flag=1;
                       break;
                   }
                   else if(list.get(mid)>total)
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
               if(flag==0)
               {
                    list.add(index,total);
                    h.put(count,list);
               }
                
                
            }
        }
        if(i>=nums.length)
        {
            return;
        }
        Solve(nums,h,i+1,count+1,total+nums[i]);
        Solve(nums,h,i+1,count,total);
    }
    public int minimumDifference(int[] nums) {
       
        int n=nums.length/2;
        int nums1[]=new int[n];
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            nums1[i]=nums[i];
        }
        HashMap<Integer,ArrayList<Integer>> h1=new HashMap<Integer,ArrayList<Integer>>();
        Solve(nums1,h1,0,0,0);
        int nums2[]=new int[n];
        int j=0;
        for(int i=n;i<nums.length;i++)
        {
            sum+=nums[i];
            nums2[j]=nums[i];
            j++;
        }
         HashMap<Integer,ArrayList<Integer>> h2=new HashMap<Integer,ArrayList<Integer>>();
         Solve(nums2,h2,0,0,0);

         for(Map.Entry<Integer,ArrayList<Integer>> entry: h1.entrySet())
         {
             System.out.println(res);
             int key=entry.getKey();
             int p=n-key;
             if(p!=0)
             {
                 ArrayList<Integer> l1=entry.getValue();
                 ArrayList<Integer> l2=h2.get(p);
                 for(int i=0;i<l1.size();i++)
                 {
                     int k=sum/2;
                     k=k-l1.get(i);
                     int low=0,high=l2.size()-1,index=0;
                     while(low<=high)
                     {
                         int mid=(low+high)/2;
                         if(l2.get(mid)>k)
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
                     
                     if(index==0)
                     {
                         if(Math.abs(2*(l1.get(i)+l2.get(0))-sum)<res)
                         {
                             res=Math.abs(2*(l1.get(i)+l2.get(0))-sum);
                         }
                     }
                     else if(index==l2.size())
                     {
                          if(Math.abs(2*(l1.get(i)+l2.get(l2.size()-1))-sum)<res)
                         {
                             res=Math.abs(2*(l1.get(i)+l2.get(l2.size()-1))-sum);
                         }
                     }
                     else
                     {
                         
                        if(Math.abs(2*(l1.get(i)+l2.get(index))-sum)<res)
                         {
                             res=Math.abs(2*(l1.get(i)+l2.get(index))-sum);
                         } 
                         if(Math.abs(2*(l1.get(i)+l2.get(index-1))-sum)<res)
                         {
                             res=Math.abs(2*(l1.get(i)+l2.get(index-1))-sum);
                         }
                     }

                 }
             }
             else
             {
                 ArrayList<Integer> list=entry.getValue();
                 for(j=0;j<list.size();j++)
                 {
                     if(Math.abs(list.get(j)-(sum-list.get(j)))<res)
                     {
                         res=Math.abs(list.get(j)-(sum-list.get(j)));
                     }
                 }
             }
         }

         return res;
    }
}
