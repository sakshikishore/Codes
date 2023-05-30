class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<String>> list=new ArrayList();
        for(int i=0;i<=n;i++)
        {
            ArrayList<String> l=new ArrayList<String>();
            list.add(l);
        } 
        for(int i=1;i<=9;i++)
        {
            for(int j=i;j<=n;j++)
            {
                  int x=j-i;
                  if(x==0)
                  {
                      list.get(j).add(Integer.toString(i));
                  }
                  else
                  {
                      if(list.get(x).size()>0)
                      {
                          for(int r=0;r<list.get(x).size();r++)
                          {
                              String str=list.get(x).get(r);
                              String s[]=str.split(" ");
                              String z=Integer.toString(i);
                              int flag=0;
                              for(int y=0;y<s.length;y++)
                              {
                                  if(s[y].equals(z))
                                  {
                                      flag=1;
                                      break;
                                  }
                              }
                              if(flag==0)
                              {
                                  list.get(j).add(str+" "+z);
                              }
                          }
                      }

                  }
            }
        }
        List<List<Integer>> result=new ArrayList();
        for(int i=0;i<list.get(n).size();i++)
        {
            String str[]=list.get(n).get(i).split(" ");
            if(str.length==k)
            {
                ArrayList<Integer> al=new ArrayList<Integer>();
                for(int j=0;j<k;j++)
                {
                     al.add(Integer.parseInt(str[j]));
                }
                result.add(al);
            }

            
        }


        return result;
    }
}
