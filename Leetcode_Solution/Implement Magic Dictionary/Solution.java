class MagicDictionary {

    /** Initialize your data structure here. */
    ArrayList<String> l;
    public MagicDictionary() {
        l=new ArrayList<String>();
    }
    
    public void buildDict(String[] dictionary) {
        for(int i=0;i<dictionary.length;i++)
        {
            l.add(dictionary[i]);
        }
    }
    
    public boolean search(String searchWord) {
        boolean result=false;
          for(int i=0;i<l.size();i++)
               {
                   String str=l.get(i);
                   if(str.length()==searchWord.length())
                   {
                       int count=0;
                     for(int j=0;j<str.length();j++)
                     {
                         if(str.charAt(j)!=searchWord.charAt(j))
                         {
                             count++;
                             if(count==2)
                             {
                                 break;
                             }
                         }
                     }
                       if(count==1)
                       {
                           result=true;
                           break;
                       }
                   }
               }
           
        
        return result;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
