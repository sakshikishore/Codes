class Solution {
    public String getHappyString(int n, int k) {
        List<List<String>> list=new ArrayList();
        for(int i=0;i<n;i++)
        {
            ArrayList<String> l=new ArrayList<String>();
            list.add(l);
        }
       list.get(0).add("a");
       list.get(0).add("b");
       list.get(0).add("c");
       for(int i=1;i<n;i++)
       {
           for(int j=0;j<list.get(i-1).size();j++)
           {
               String str=list.get(i-1).get(j);
               if(str.charAt(str.length()-1)=='a')
               {
                   list.get(i).add(str+"b");
                   list.get(i).add(str+"c");
                   
               }
               else if(str.charAt(str.length()-1)=='b')
               {
                   list.get(i).add(str+"a");
                   list.get(i).add(str+"c");
                   
               }
               else
               {
                   list.get(i).add(str+"a");
                   list.get(i).add(str+"b");
               }
           }
       }
        if(k>list.get(n-1).size())
        {
            return "";
        }
        return list.get(n-1).get(k-1);
    }
}
