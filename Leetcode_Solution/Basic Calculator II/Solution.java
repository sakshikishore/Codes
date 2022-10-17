class Solution {
    public int calculate(String s) {
      Stack<Character> stck1=new Stack<Character>();
      Stack<Integer> stck2=new Stack<Integer>();
      int i=0;
      while(i<s.length())
      {
          if(s.charAt(i)>='0' && s.charAt(i)<='9')
          {
              int startIndex=i;
              i++;
              while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9')
              {
                  i++;
              }
              stck2.push(Integer.parseInt(s.substring(startIndex,i)));
          }
          else
          {
              if(s.charAt(i)=='+')
              {
                  stck1.push('+');
                  i++;
              }
              else if(s.charAt(i)=='-')
              {
                  stck1.push('-');
                  i++;
              }
              else if(s.charAt(i)=='*')
              {
                      int x=stck2.pop();
                      int startIndex=i+1;
                      while(s.charAt(startIndex)==' ')
                      {
                          startIndex++;
                      }
                      i=startIndex+1;
                      while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9')
                      {
                          i++;
                      }
                      int y= Integer.parseInt(s.substring(startIndex,i));
                      stck2.push(x*y);
              }
              else if(s.charAt(i)=='/')
              {
                      int x=stck2.pop();
                      int startIndex=i+1;
                      while(s.charAt(startIndex)==' ')
                      {
                          startIndex++;
                      }
                      i=startIndex+1;
                      while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9')
                      {
                          i++;
                      }
                      int y=Integer.parseInt(s.substring(startIndex,i));
                      stck2.push(x/y);
              }
              else
              {
                  i++;
              }
          }
        }
        int sum=0;
        while(stck1.size()>0)
        {
            char c=stck1.pop();
            int x=stck2.pop();
            if(c=='-')
            {
              x=x*-1;
              sum+=x;
            }
            else
            {
               sum+=x;
            }
        }
        if(stck2.size()==1)
        {
            sum=sum+stck2.peek();
        }
        return sum;
    }
}
