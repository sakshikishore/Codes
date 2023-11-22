class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,ArrayList<String>> h1=new HashMap<String,ArrayList<String>>();
        HashMap<String,ArrayList<String>> h2=new HashMap<String,ArrayList<String>>();
        HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>>();
        ArrayList<String> result=new ArrayList<String>();
        HashSet<String> hset=new HashSet<String>();
        HashSet<String> supplySet=new HashSet<String>();
        for(int i=0;i<recipes.length;i++)
        {
           hset.add(recipes[i]);
        } 
        for(int i=0;i<supplies.length;i++)
        {
            supplySet.add(supplies[i]);
        }
        for(int i=0;i<recipes.length;i++)
        {
             List<String> list=ingredients.get(i);
             ArrayList<String> l=new ArrayList<String>();
             ArrayList<String> m=new ArrayList<String>();
             for(int j=0;j<list.size();j++)
             {
                 if(hset.contains(list.get(j)))
                 {
                     l.add(list.get(j));
                     if(!map.containsKey(list.get(j)))
                     {
                         ArrayList<String> al=new ArrayList<String>();
                         al.add(recipes[i]);
                         map.put(list.get(j),al);
                     }
                     else
                     {
                         ArrayList<String> al=map.get(list.get(j));
                         al.add(recipes[i]);
                         map.put(list.get(j),al);
                     }
                 }
                 else
                 {
                     m.add(list.get(j));
                 }
             }
             if(l.size()!=0)
             {
                 h1.put(recipes[i],l);
             }
             if(m.size()!=0)
             {
                 h2.put(recipes[i],m);
             }
        }
        Queue<String> q=new LinkedList<String>();
        for(int i=0;i<recipes.length;i++)
        {
            if(!h1.containsKey(recipes[i]))
            {
                q.add(recipes[i]);
            }
        }

        while(q.size()>0)
        {
            String ing=q.poll();
            if(h2.containsKey(ing))
            {
                int flag=0;
                ArrayList<String> list=h2.get(ing);
                
                for(int i=0;i<list.size();i++)
                {
                    if(!supplySet.contains(list.get(i)))
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                {
                    result.add(ing);
                    if(map.containsKey(ing))
                {
               ArrayList<String> al=map.get(ing);
               for(int j=0;j<al.size();j++)
               {
                   String s=al.get(j);
                   ArrayList<String> p=h1.get(s);
                   int index=p.indexOf(ing);
                   p.remove(index);
                   if(p.size()==0)
                   {
                       q.add(s);
                   }
                   else
                   {
                       h1.put(s,p);
                   }
               }
           }
                }
            }
            else
            {
                result.add(ing);
           if(map.containsKey(ing))
           {
               ArrayList<String> al=map.get(ing);
               for(int j=0;j<al.size();j++)
               {
                   String s=al.get(j);
                   ArrayList<String> p=h1.get(s);
                   int index=p.indexOf(ing);
                   p.remove(index);
                   if(p.size()==0)
                   {
                       q.add(s);
                   }
                   else
                   {
                       h1.put(s,p);
                   }
               }
           }
           }


        }
        
        
        return result;
    }
}
