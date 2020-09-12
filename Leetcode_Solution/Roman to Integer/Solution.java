class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        h.put('I',1);
        h.put('V',5);
        h.put('X',10);
        h.put('L',50);
        h.put('C',100);
        h.put('D',500);
        h.put('M',1000);
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
          if(i==0)
          {
              sum=sum+h.get(s.charAt(i));
              
          }
           else
            {
               
               int p=h.get(s.charAt(i));
               int q=h.get(s.charAt(i-1));
               if(p>q)
               {
                   sum=sum-q;
                   sum=sum+(p-q);
               }
               else
               {
                   sum=sum+p;
               }
                
            }
        }
        
        return sum;
        
    }
}
