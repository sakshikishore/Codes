class Solution {
    public long maxSpending(int[][] values) {
        long result=0;
      List<List<Integer>> list=new ArrayList();
      for(int i=0;i<values.length;i++)
      {
          ArrayList<Integer> l=new ArrayList<Integer>();
          for(int j=0;j<values[0].length;j++)
          {
              l.add(values[i][j]);
          }
          list.add(l);
      } 
      long count=0;
      while(count!=(values.length*values[0].length))
      {
          int min=1000001;
          int index=0;
               for(int i=0;i<list.size();i++)
               {
                   int p=list.get(i).size();
                   if(list.get(i).get(p-1)<min)
                   {
                       min=list.get(i).get(p-1);
                       index=i;
                   }
                   else if(list.get(i).get(p-1)==min)
                   {
                       if(p-2>=0 && list.get(index).size()>1 && list.get(index).get(list.get(index).size()-2)>list.get(i).get(p-2))
                       {
                             index=i;
                       }
                   }
               }

               count++;
               result+=count*(list.get(index).get(list.get(index).size()-1));
               if(list.get(index).size()==1)
               {
                   list.remove(index);
               }
               else
               {
                   list.get(index).remove(list.get(index).size()-1);
               }
      }

      return result;
    }
}
