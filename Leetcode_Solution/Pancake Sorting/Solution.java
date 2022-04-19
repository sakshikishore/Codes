class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int p[]=new int[arr.length];
        int count=p.length-1;
        int index=0;
        for(int i=0;i<arr.length;i++)
        {
            p[i]=arr[i];
        }
        
        Arrays.sort(p);
        if(!Arrays.equals(p,arr))
        {
            int flag=1;
            while(flag!=0)
            {
                for(int i=0;i<arr.length;i++)
                {
                    if(arr[i]==p[count])
                    {
                        index=i;
                    }
                }
                
                if(index!=count)
                {
                
                    int k[]=new int[index+1];
                    int x=index;
                    for(int j=0;j<k.length;j++)
                    {
                        k[j]=arr[x];
                        x--;
                    }
                    l.add(index+1);
                    for(int i=0;i<=index;i++)
                        {
                            arr[i]=k[i];
                        }
                    k=new int[count+1];
                    l.add(count+1);
                    for(int i=0;i<=count;i++)
                    {
                        k[i]=arr[i];
                    }
                    int r=0;
                    for(int i=count;i>=0;i--)
                    {
                        arr[i]=k[r];
                        r++;
                    }
                }
                count=count-1;
                if(Arrays.equals(p,arr))
                {
                    flag=1;
                    break;
                }
            }
        }
        
        return l;
        
    }
}
