class Solution {
    public int splitNum(int num) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        while(num>0)
        {
            l.add(num%10);
            num=num/10;
        }
        int num1=0,num2=0;
        Collections.sort(l);
        for(int i=0;i<l.size();i++)
        {
            if(i%2==0)
            {
                num1=num1*10+l.get(i);
            }
            else
            {
                num2=num2*10+l.get(i);
            }
        }
        
        return num1+num2;
    }
}
