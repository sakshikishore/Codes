class Solution {
    public int fillCups(int[] amount) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int ans=0;
        for(int i=0;i<3;i++)
        {
            if(amount[i]!=0)
            {
             l.add(amount[i]);
            }
        }
        if(l.size()==0)
        {
            return 0;
        }
        if(l.size()==1)
        {
            ans=l.get(0);
        }
        else
        {
            int flag=1;
            while(flag!=0)
            {
                if(l.size()==1)
                {
                    ans=ans+l.get(0);
                    break;
                }
                else
                {
                    Collections.sort(l);
                    int arr[]=new int[l.size()];
                    for(int i=0;i<l.size();i++)
                    {
                        arr[i]=l.get(i);
                    }
                    l=new ArrayList<Integer>();
                    ans++;
                    arr[0]=arr[0]-1;
                    arr[arr.length-1]=arr[arr.length-1]-1;
                    int count=0;
                    for(int i=0;i<arr.length;i++)
                    {
                        if(arr[i]!=0)
                        {
                            l.add(arr[i]);
                            count++;
                        }
                    }
                    if(count==0)
                    {
                        break;
                    }
                }
                
            }
        }
        return ans;
        
    }
}
