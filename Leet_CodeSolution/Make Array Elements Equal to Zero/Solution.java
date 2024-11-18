class Solution {
    public int countValidSelections(int[] nums) {
        int count=0;
        HashSet<Integer> hset=new HashSet<Integer>();
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
          arr[i]=nums[i];
          if(nums[i]==0)
          {
            hset.add(i);
          }
        }

        Iterator<Integer> itr=hset.iterator();
        while(itr.hasNext())
        {
            int x=itr.next();
            // take left
            int i=x-1;
            int direc=0; // 0 for left and 1 for right
            while(i>=0 && i<nums.length)
            {
               if(nums[i]!=0)
               {
                 nums[i]=nums[i]-1;
                 if(direc==0)
                 {
                    direc=1;
                 }
                 else
                 {
                    direc=0;
                 }
               } 

               if(direc==0)
                 {
                    i--;
                 }
                 else
                 {
                    i++;
                 }
            }
            int flag=0;
            for(int j=0;j<nums.length;j++)
            {
                if(nums[j]!=0)
                {
                    flag=1;
                }
            }
            if(flag==0)
            {
                count++;
            }
            for(int j=0;j<nums.length;j++)
            {
               nums[j]=arr[j];
            }
            // take right
            i=x+1;
            direc=1; // 0 for left and 1 for right
            while(i>=0 && i<nums.length)
            {
               if(nums[i]!=0)
               {
                 nums[i]=nums[i]-1;
                 if(direc==0)
                 {
                    direc=1;
                 }
                 else
                 {
                    direc=0;
                 }
               } 
               if(direc==0)
                 {
                    i--;
                 }
                 else
                 {
                    i++;
                 }
            }
             flag=0;
            for(int j=0;j<nums.length;j++)
            {
                if(nums[j]!=0)
                {
                    flag=1;
                }
            }
            if(flag==0)
            {
                count++;
            }
            for(int j=0;j<nums.length;j++)
            {
               nums[j]=arr[j];
            }


        }

        return count;
    }
}
