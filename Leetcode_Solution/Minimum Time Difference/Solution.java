class Solution {
    public int findMinDifference(List<String> timePoints) {
        HashMap<String,Integer> h=new HashMap<String,Integer>();
        int ans=-1;
        int arr[]=new int[timePoints.size()];
        for(int i=0;i<timePoints.size();i++)
        {
            if(!h.containsKey(timePoints.get(i)))
            {
                h.put(timePoints.get(i),1);
            }
            else
            {
                ans=0;
                break;
            }
            if(timePoints.get(i).equals("00:00"))
            {
                arr[i]=24*60;
            }
            else
            {
              String str[]=timePoints.get(i).split(":");
              arr[i]=Integer.parseInt(str[0])*60+Integer.parseInt(str[1]);
            }
            
        }
        if(ans!=0)
        {
            ans=24*60;
            for(int i=0;i<arr.length;i++)
            {
                for(int j=i+1;j<arr.length;j++)
                {
                    if(arr[i]<arr[j])
                    {
                        if(arr[j]-arr[i]<ans)
                        {
                            ans=arr[j]-arr[i];
                        }
                        if(1440+arr[i]-arr[j]<ans)
                        {
                            ans=1440+arr[i]-arr[j];
                        }
                    }
                    else
                    {
                       if(arr[i]-arr[j]<ans)
                        {
                            ans=arr[i]-arr[j];
                        }
                        if(1440+arr[j]-arr[i]<ans)
                        {
                            ans=1440+arr[j]-arr[i];
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}
