class Solution {
    public int expressiveWords(String s, String[] words) {
        int result=0;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int x=1;
        int count=1;
        ArrayList<Character> l=new ArrayList<Character>();
        l.add(s.charAt(0));
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)!=s.charAt(i-1))
            {
                 h.put(x,count);
                l.add(s.charAt(i));
                x++;
                count=1;
            }
            else
            {
                count++;
            }
        }
        h.put(x,count);
      for(int i=0;i<words.length;i++)
      {
            x=1;
            ArrayList<Character> ch=new ArrayList<Character>();
            HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
            ch.add(words[i].charAt(0));
            int c=1;
            for(int j=1;j<words[i].length();j++)
            {
                if(words[i].charAt(j)!=words[i].charAt(j-1))
                {
                    map.put(x,c);
                    ch.add(words[i].charAt(j));
                    c=1;
                    x++;
                }
                else
                {
                    c++;
                }
            }
            map.put(x,c);
            if(ch.size()==l.size())
            {
                int flag=0;
                for(int j=0;j<ch.size();j++)
                {
                    if(ch.get(j)!=l.get(j))
                    {
                        flag=1;
                        break;
                    }
                    else if(h.get(j+1)<map.get(j+1))
                    {
                        flag=1;
                        break;
                    }
                    else if(h.get(j+1)==2 && map.get(j+1)==1)
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                {
                    result++;
                }
            }
      }

        return result;

    }
}
