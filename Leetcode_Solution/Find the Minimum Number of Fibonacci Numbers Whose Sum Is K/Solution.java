class Solution {
    public int findMinFibonacciNumbers(int k) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int a=1,b=1,c=0;
        l.add(a);
        l.add(b);
        while(c<=k)
        {
            c=a+b;
            l.add(c);
            a=b;
            b=c;
        }
        int count=0,sum=0;
        for(int i=l.size()-2;i>=0;i--)
        {
            if(sum+l.get(i)<=k)
            {
              sum=sum+l.get(i);
                count++;
            }
            if(sum==k)
            {
                break;
            }
        }
        return count;
        
    }
}
