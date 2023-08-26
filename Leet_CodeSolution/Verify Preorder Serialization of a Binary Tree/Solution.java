class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder.charAt(0)=='#' && preorder.length()>1)
        {
            return false;
        }
        if(preorder.charAt(0)=='#' && preorder.length()==1)
        {
            return true;
        }
        String str[]=preorder.split(",");
        Stack<Integer> stck=new Stack<Integer>();
        stck.push(0);
        HashMap<Integer,Integer> childCount=new HashMap<Integer,Integer>(); // if value==2, use pop operation.
        childCount.put(0,0);
        for(int i=1;i<str.length;i++)
        {
              if(stck.empty())
              {
                  return false;
              }
              if(!str[i].equals("#"))
              {
                  int x=stck.peek();
                  if(childCount.get(x)+1==2)
                  {
                      stck.pop();
                      stck.push(i);
                      childCount.remove(x);
                      childCount.put(i,0);
                  }
                  else
                  {
                      childCount.put(x,childCount.get(x)+1);
                      stck.push(i);
                      childCount.put(i,0);

                  }
              }
              else
              {
                  int x=stck.peek();
                  if(childCount.get(x)+1==2)
                  {
                      stck.pop();
                      childCount.remove(x);
                  }
                   else
                  {
                      childCount.put(x,childCount.get(x)+1);

                  }
              }
        }
      if(stck.empty())
      {
        return true;
      }
      return false;
    }
}
