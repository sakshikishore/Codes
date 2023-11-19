class Solution {
    public long minimumSteps(String s) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        long result=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='1')
            {
                l.add(i);
            }
        }
        int x=s.length()-1;
        for(int i=l.size()-1;i>=0;i--)
        {
            result+=x-l.get(i);
            x--;
        }

        return result;
    }
}
