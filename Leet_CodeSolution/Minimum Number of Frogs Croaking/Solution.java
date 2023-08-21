class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int c[]=new int[5]; // count 'c', 'r', 'o', 'a', and 'k'
        ArrayList<Integer> l=new ArrayList<Integer>(); // Track c index
        ArrayList<Integer> m=new ArrayList<Integer>(); // Track k index
        for(int i=0;i<croakOfFrogs.length();i++)
        {
             if(croakOfFrogs.charAt(i)=='c')
             {
                 c[0]++;
                 l.add(i);
             }
             else if(croakOfFrogs.charAt(i)=='r')
             {
                 c[1]++;
                 if(c[1]>c[0])
                 {
                     return -1;
                 }
             }
             else if(croakOfFrogs.charAt(i)=='o')
             {
                 c[2]++;
                 if(c[2]>c[0] || c[2]>c[1])
                 {
                     return -1;
                 }
             }
             else if(croakOfFrogs.charAt(i)=='a')
             {
                 c[3]++;
                 if(c[3]>c[0] || c[3]>c[1] || c[3]>c[2])
                 {
                     return -1;
                 }
             }
             else
             {
                 c[4]++;
                 m.add(i);
                 if(c[4]>c[0] || c[4]>c[1] || c[4]>c[2] || c[4]>c[3])
                 {
                     return -1;
                 }
             }

        }
        int x=c[0];
        if(c[1]!=x || c[2]!=x || c[3]!=x || c[4]!=x)
        {
            return -1;
        }
        int ans=1;
        int start=0;
        for(int i=1;i<l.size();i++)
        {
            if(l.get(i)<m.get(start))
            {
                ans++;
            }
            else
            {
                start++;
            }
        }

        return ans;
    }
}
