class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=1;i<=n;i++)
        {
            l.add(i);
        }
        int i=0;
        while(l.size()>1)
        {
            i=(i+k-1)%l.size();
            l.remove(i);
        }
        return l.get(0);
    }
}
