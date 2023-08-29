class Solution {
    public long numberOfWays(String s) {
        ArrayList<Integer> l1=new ArrayList<Integer>();
        ArrayList<Integer> r1=new ArrayList<Integer>(); // 010
        ArrayList<Integer> l2=new ArrayList<Integer>();//101
        ArrayList<Integer> r2=new ArrayList<Integer>();
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
            {
                count++;
            }
            else
            {
                l1.add(count);
            }
        }
        count=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='0')
            {
                count++;
            }
            else
            {
                r1.add(count);
            }
        }
        count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                count++;
            }
            else
            {
                l2.add(count);
            }
        }
        count=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='1')
            {
                count++;
            }
            else
            {
                r2.add(count);
            }
        }
        int i=0;
        long result=0;
        int j=r1.size()-1;
        while(i<l1.size())
        {
           result+=(l1.get(i))*(r1.get(j));
           i++;
           j--;
        }
        i=0;
        j=r2.size()-1;
        while(i<l2.size())
        {
           result+=(l2.get(i))*(r2.get(j));
           i++;
           j--; 
        }

        return result;
    }
}
