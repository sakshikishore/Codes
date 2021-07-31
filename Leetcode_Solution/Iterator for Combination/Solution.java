class CombinationIterator {
     TreeSet<String> t=new TreeSet<String>();
     Iterator itr;
     public CombinationIterator(String characters, int combinationLength) {
        for(int i=0;i<(1<<characters.length());i++)
        {
            String str="";
            for(int j=0;j<characters.length();j++)
            {
                if((i & (1<<j))>0)
                {
                  str=str+characters.substring(j,j+1);
                }
            }
            if(str.length()==combinationLength)
            {
                int count=0;
                for(int p=1;p<str.length();p++)
                {
                    if(str.charAt(p-1)>str.charAt(p))
                    {
                        count++;
                        break;
                    }
                }
                if(count==0)
                {
                    t.add(str);
                }
            }
            
        }
        
         itr=t.iterator();
        
    }
    public String next() {
      
       return itr.next().toString();
      
    }
    
    public boolean hasNext() {
            
        return itr.hasNext();
        
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
