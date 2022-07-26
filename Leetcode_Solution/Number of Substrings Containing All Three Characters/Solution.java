class Solution {
    public int numberOfSubstrings(String s) {
        int count=0;
        int n=s.length();
        LinkedHashMap<Character,ArrayList<Integer>> h=new LinkedHashMap<Character,ArrayList<Integer>>();
        for(int i=0;i<s.length();i++)
        {
               if(!h.containsKey(s.charAt(i)))
               {
                   ArrayList<Integer> l=new ArrayList<Integer>();
                   l.add(i);
                   h.put(s.charAt(i),l);
               }
                  else
                  {
                       ArrayList<Integer> l=h.get(s.charAt(i));
                       l.add(i);
                       h.put(s.charAt(i),l);
                  }
        }
        if(h.containsKey('a') && h.containsKey('b') && h.containsKey('c'))
        {
        for(int i=0;i<s.length()-2;i++)
        {
            int a=-1,b=-1,c=-1;
            if(h.containsKey('a'))
            {
          ArrayList<Integer> l=h.get('a');
          if(l.size()==0)
          {
              break;
          }
          else
          {
              a=l.get(0);
              if(l.get(0)==i)
              {
                  l.remove(0);
                  if(l.size()==0)
                  {
                      h.remove('a');
                  }
                  else
                  {
                   h.put('a',l);
                  }
              }
          }
    }
            else
            {
                break;
            }
            if(h.containsKey('b'))
            {
            ArrayList<Integer> l=h.get('b');
          if(l.size()==0)
          {
              break;
          }
          else
          {
              b=l.get(0);
              if(l.get(0)==i)
              {
                  l.remove(0);
                  if(l.size()==0)
                  {
                      h.remove('b');
                  }
                  else
                  {
                   h.put('b',l);
                  }
              }
          }
            }
            else
            {
                break;
            }
            if(h.containsKey('c'))
            {
           ArrayList<Integer> l=h.get('c');
          if(l.size()==0)
          {
              break;
          }
          else
          {
              c=l.get(0);
              if(l.get(0)==i)
              {
                  l.remove(0);
                  if(l.size()==0)
                  {
                      h.remove('c');
                  }
                  else
                  {
                  h.put('c',l);
                  }
              }
          }
            }
            else
            {
                break;
            }
            
            
          int max=Math.max(a,b);
          max=Math.max(max,c);
          count+=n-max;
        }
        }
        return count;
    }
}
