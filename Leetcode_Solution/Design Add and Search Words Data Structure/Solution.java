class WordDictionary {
    HashSet<String> h;
    HashSet<String> found; 
    HashMap<Integer,HashSet<String>> map=new HashMap<Integer,HashSet<String>>();
    public WordDictionary() {
        h=new HashSet<String>();
        found= new HashSet<String>();
    }
    
    public void addWord(String word) {
        h.add(word);
        int len=word.length();
        if(!map.containsKey(len))
        {
            HashSet<String> hset=new HashSet<String>();
            hset.add(word);
            map.put(len,hset);
        }
        else
        {
            HashSet<String> hset=map.get(len);
            hset.add(word);
            map.put(len,hset);
        }
        
    }
    
    public boolean search(String word) {
      boolean result=false;
        if(found.contains(word))
        {
            return true;
        }
      else if(h.contains(word))
       {
           found.add(word);
           result=true;
       }
       else
       {
           int count=0;
           for(int i=0;i<word.length();i++)
           {
               if(word.charAt(i)=='.')
               {
                   count++;
                   break;
               }
           }
           if(count==1)
           {
           int len=word.length();
           if(map.containsKey(len))
           {
               HashSet<String> hset=map.get(len);
               Iterator<String> itr=hset.iterator();
               while(itr.hasNext())
               {
                   String str=itr.next();
                   int flag=0;
                       for(int i=0;i<word.length();i++)
                       {
                           if(word.charAt(i)=='.')
                           {
                               continue;
                           }
                           else
                           {
                               if(word.charAt(i)!=str.charAt(i))
                               {
                                   flag=1;
                                   break;
                               }
                           }
                       }

                       if(flag==0)
                       {
                           found.add(word);
                           result=true;
                           break;
                       }
               }
           }
           }
       }
        
        return result;
    }
}
