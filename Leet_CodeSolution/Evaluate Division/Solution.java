class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,ArrayList<String>> h=new HashMap<String,ArrayList<String>>();
        double[] result=new double[queries.size()];
        for(int i=0;i<equations.size();i++)
        {
            String s1=equations.get(i).get(0);
            String s2=equations.get(i).get(1);
            if(!h.containsKey(s1))
            {
                ArrayList<String> al=new ArrayList<String>();
                al.add(s2+" "+Double.toString(values[i]));
                h.put(s1,al);
            }
            else
            {
                ArrayList<String> al=h.get(s1);
                al.add(s2+" "+Double.toString(values[i]));
                h.put(s1,al);
            }
            if(!h.containsKey(s2))
            {
                ArrayList<String> al=new ArrayList<String>();
                al.add(s1+" "+Double.toString(1/values[i]));
                h.put(s2,al);
            }
            else
            {
                ArrayList<String> al=h.get(s2);
                al.add(s1+" "+Double.toString(1/values[i]));
                h.put(s2,al);
            }
        }
        for(int i=0;i<queries.size();i++)
        {
            result[i]=-1.00000;
            String s1=queries.get(i).get(0);
            String s2=queries.get(i).get(1);
            if(!h.containsKey(s1) || !h.containsKey(s2))
            {
                result[i]=-1.00000;
            }
            else if(s1.equals(s2))
            {
                result[i]= 1.00000;
            }
            else
            {
                HashSet<String> hset=new HashSet<String>();
                hset.add(s1);
                Queue<String> q=new LinkedList<String>();
                q.add(s1+" "+Double.toString(1.0));
                int flag=0;
                  while(q.size()>0)
                  {
                     String s[]=q.poll().split(" ");
                     double val=Double.parseDouble(s[1]);
                     if(h.containsKey(s[0]))
                     {
                         ArrayList<String> al=h.get(s[0]);
                         for(int j=0;j<al.size();j++)
                         {
                             String str[]=al.get(j).split(" ");
                             double a=Double.parseDouble(str[1]);
                             if(str[0].equals(s2))
                             {
                                 result[i]= val*a;
                                 flag=1;
                                 break;
                             }
                             else if(!hset.contains(str[0]))
                             {
                                     hset.add(str[0]);
                                     q.add(str[0]+" "+Double.toString(val*a));
                                    
                             }
                         }
                     }
                     if(flag==1)
                     {
                         break;
                     }
                  }     
                

            }
        }
        return result;
    }
}
