class Solution {
    public int createSortedArray(int[] instructions) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        long result=0;
        for(int i=0;i<instructions.length;i++)
        {
            if(i==0)
            {
                list.add(instructions[i]);
            }
            else
            {
                int low=0,high=list.size()-1;
                int lowerIndex=0;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(list.get(mid)>=instructions[i])
                    {
                        lowerIndex=mid;
                        high=mid-1;
                    }
                    else
                    {
                        lowerIndex=mid+1;
                        low=mid+1;
                    }
                }
                int upperIndex=0;
                low=0;
                high=list.size()-1;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(list.get(mid)>instructions[i])
                    {
                        high=mid-1;
                        upperIndex=mid;
                    }
                    else
                    {
                        upperIndex=mid+1;
                        low=mid+1;
                    }
                }
                result+=Math.min(lowerIndex,list.size()-upperIndex);
                list.add(lowerIndex,instructions[i]);
                result=result%(1000000007);

            }
        }

        return (int)result;
    }
}
