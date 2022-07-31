class Solution {
    public int maximumGroups(int[] grades) {
        int count=0;
        int t=1,a=0;
        for(int i=0;i<grades.length;i++)
        {
            a++;
            if(a==t)
            {
                count++;
                a=0;
                t++;
            }
        }
    
    return count;
    }
}
