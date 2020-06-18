class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        boolean result=true;
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        for(int i=0;i<order.length();i++)
        {
            h.put(order.charAt(i),i);
        }
        
        for(int i=0;i<words.length;i++)
        {
            char c[]=words[i].toCharArray();
            for(int j=0;j<c.length;j++)
            {
                c[j]=(char)(97+h.get(c[j]));
            }
            words[i]=new String(c);
        }
        for(int i=0;i<words.length-1;i++)
        {
           
            if(words[i].compareTo(words[i+1])>0)
            {
                result=false;
                break;
            }
        }
        
        return result;
    }
}
