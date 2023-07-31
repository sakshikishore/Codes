class Solution {
    HashMap<String,Integer> h=new HashMap<String,Integer>();
    public int Solve(int n,int x, int num)
    {
        if(n==0)
        {
            return 1;
        }
        if(n<0 || (int)Math.pow(num,x)>n)
        {
            return 0;
        }
        String key=n+" "+num;
        if(h.containsKey(key))
        {
            return h.get(key);
        }
      int inc=Solve(n-(int)Math.pow(num,x),x,num+1)%(1000000007);
      int exc=Solve(n,x,num+1)%(1000000007);
      h.put(key,(inc+exc)%(1000000007));
      return (inc+exc)%(1000000007);
    }
    public int numberOfWays(int n, int x) {
        return Solve(n,x,1);
    }
}
