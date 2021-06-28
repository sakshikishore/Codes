class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=i+1;
        }
        for(int i=0;i<(1<<n);i++)
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            for(int j=0;j<n;j++)
            {
                if((i & (1<<j))>0)
                {
                    l.add(arr[j]);
                }
            }
            if(l.size()==k)
             {
                list.add(l);
             }
        }
        
        return list;
    }
}
