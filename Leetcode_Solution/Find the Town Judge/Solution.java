class Solution {
    public int findJudge(int N, int[][] trust) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int result=-1;
        
        for(int i=0;i<trust.length;i++)
        {
            if(!l.contains(trust[i][0]))
            {
            l.add(trust[i][0]);
            }
        }
            for(int i=1;i<=N;i++)
            {
                if(!l.contains(i))
                {
                    result=i;
                    break;
                }
            }
        int arr[]=new int[N+1];
        for(int i=0;i<trust.length;i++)
        {
            if(trust[i][1]==result)
            {
                 arr[trust[i][0]]++;   
            }
                
        }
        for(int i=1;i<=N;i++)
        {
            if(i!=result && arr[i]==0)
            {
                result=-1;
                break;
            }
        }
        
        return result;
        
    }
}
