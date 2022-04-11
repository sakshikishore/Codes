class Solution {
    public int largestInteger(int num) {
    ArrayList<Integer> l=new ArrayList<Integer>();
    ArrayList<Integer> m=new ArrayList<Integer>();
    String s=Integer.toString(num);
      while(num>0)
      {
          int r=num%10;
          if(r%2==0)
          {
              l.add(r);
          }
          else
          {
              m.add(r);
          }
          num=num/10;
      }
        Collections.sort(l);
        Collections.sort(m);
        int i=l.size()-1;
        int j=m.size()-1;
        int result=0;
      for(int x=0;x<s.length();x++)
      {
          int r=Integer.parseInt(s.substring(x,x+1));
          if(r%2==0)
          {
             result=result*10+l.get(i);
             i--;
          }
          else
          {
             result=result*10+m.get(j);
             j--; 
          }
      }
        
        
        return result;
      
    }
}
