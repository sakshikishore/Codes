class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1)
        {
            return word;
        }
        char max=word.charAt(0);
        HashMap<Character,ArrayList<Integer>> map=new HashMap<Character,ArrayList<Integer>> ();
        for(int i=0;i<word.length();i++)
        {
            if(word.charAt(i)>max)
            {
                max=word.charAt(i);
            }
            if(!map.containsKey(word.charAt(i)))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                map.put(word.charAt(i),l); 
            }
            else
            {
                ArrayList<Integer> l=map.get(word.charAt(i));
                l.add(i);
                map.put(word.charAt(i),l); 
            }
        }

        ArrayList<Integer> l=map.get(max);
        int c=word.length()-numFriends+1;
        String res="";
        for(int i=0;i<l.size();i++)
        {
          int x=l.get(i);
        
          if(word.length()-x>=c)
          {
                 String str=word.substring(x,x+c);
                 if(str.compareTo(res)>0)
                 {
                    res=str;
                 }
          }
          else
          {
            String str=word.substring(x);
             if(str.compareTo(res)>0)
                 {
                    res=str;
                 }
          }
        }

        return res;

    }
}
