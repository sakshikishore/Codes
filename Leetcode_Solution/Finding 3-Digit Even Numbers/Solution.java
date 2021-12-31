class Solution {
    public int[] findEvenNumbers(int[] digits) {
         HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
         ArrayList<Integer> result=new ArrayList<Integer>();
        for(int i=0;i<digits.length;i++)
        {
              if(!h.containsKey(digits[i]))
              {
                  h.put(digits[i],1);
              }
              else
              {
                  h.put(digits[i],h.get(digits[i])+1);
              }
        }
        for(int i=100;i<=998;i=i+2)
        {
            int x=i;
            int count=0;
            int a=-1,b=-1,c=-1;
            while(x>0)
            {
                if(a==-1)
                {
                    a=x%10;
                }
                else if(b==-1)
                {
                    b=x%10;
                }
                else
                {
                    c=x%10;
                }
                x=x/10;
            }
            if(a==b && b==c)
            {
                if(h.containsKey(a) && h.get(a)>2)
                {
                   result.add(i);
                }
            }
            else if(a!=b && a!=c && b!=c)
            {
                if(h.containsKey(a) && h.containsKey(b) && h.containsKey(c))
                {
                    result.add(i);
                }
            }
            else if(a==b && b!=c)
            {
                if(h.containsKey(a) && h.get(a)>1 && h.containsKey(c))
                {
                    result.add(i);
                }
            }
            else if(a==c && a!=b)
            {
                if(h.containsKey(a) && h.get(a)>1 && h.containsKey(b))
                {
                    result.add(i);
                }
            }
            else
            {
                if(h.containsKey(b) && h.get(b)>1 && h.containsKey(a))
                {
                    result.add(i);
                }
            }
        }
        
        int arr[]=new int[result.size()];
        for(int i=0;i<result.size();i++)
        {
            arr[i]=result.get(i);
        }
        
        return arr;
    }
}
