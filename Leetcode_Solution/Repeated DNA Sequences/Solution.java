class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> l=new ArrayList<String>();
        if(s.length()>9)
        {
          HashMap<String,Integer> h=new HashMap<String,Integer>();
          for(int i=0;i<=s.length()-10;i++)
          {
              String str=s.substring(i,i+10);
              if(!h.containsKey(str))
              {
                  h.put(str,1);
              }
              else
              {
                  if(h.get(str)==1)
                  {
                  l.add(str);
                  }
                  h.put(str,h.get(str)+1);
              }
          }
        }
        
        return l;
        
    }
}
