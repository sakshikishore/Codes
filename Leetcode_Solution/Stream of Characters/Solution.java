class StreamChecker {
HashMap<Character,ArrayList<String>> h=new HashMap<Character,ArrayList<String>>();
    StringBuffer sb=new StringBuffer("");
    int i=0;
    ArrayList<String> al=new ArrayList<String>();
    public StreamChecker(String[] words) {
        for(int i=0;i<words.length;i++)
        {
            if(!al.contains(words[i]))
            {
                al.add(words[i]);
                char ch=words[i].charAt(words[i].length()-1);
               if(!h.containsKey(words[i].charAt(words[i].length()-1)))
               {
                   ArrayList<String> l=new ArrayList<String>();
                   l.add(words[i]);
                   h.put(ch,l);
               }
               else
               {
                   ArrayList<String> m=h.get(ch);
                   m.add(words[i]);
                   h.put(ch,m);
               }
            }
        }
    }
    
    public boolean query(char letter) {
        boolean result=false;
        sb.append(letter);
        i++;
       if(i>201)
       { 
           sb.delete(0,1);
       }
       if(h.containsKey(letter))
       {
           ArrayList<String> s=h.get(letter);
           for(int i=0;i<s.size();i++)
           {
              if(s.get(i).length()<=sb.length())
              {
                  if(sb.substring(sb.length()-s.get(i).length()).equals(s.get(i)))
                  {
                      result=true;
                      break;
                  }
              }
           }
       }
        return result;
    }
}
