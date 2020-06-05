class Solution {
    public int minDeletionSize(String[] A) {
        int result=0;
        for(int i=0;i<A[0].length();i++)
        {
            int count=0;
            for(int j=0;j<A.length-1;j++)
            {
                if(A[j].charAt(i)>A[j+1].charAt(i))
                {
                    count++;
                    break;
                }
            }
            if(count==1)
            {
                result++;
            }
        }
        
        return result;
    }
}
