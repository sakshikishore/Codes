class Solution {
    public int maximumLength(String s) {
        int count=1,max=-1;
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        String str=s.substring(0,1)+" "+Integer.toString(1);
        map.put(str,1);
        int ch[]=new int[26];
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                count++;
                str=s.charAt(i)+" "+Integer.toString(count);
                if(!map.containsKey(str))
                {
                    map.put(str,1);
                }
                else
                {
                    map.put(str,map.get(str)+1);
                }
               
            }
            else
            {
                if(ch[s.charAt(i-1)-'a']<count)
                {
                    ch[s.charAt(i-1)-'a']=count;
                }
                str=s.charAt(i)+" "+Integer.toString(1);
                if(!map.containsKey(str))
                {
                    map.put(str,1);
                }
                else
                {
                    map.put(str,map.get(str)+1);
                }
                
                count=1;
            }
        }
                if(ch[s.charAt(s.length()-1)-'a']<count)
                {
                    ch[s.charAt(s.length()-1)-'a']=count;
                }
        for(int i=0;i<26;i++)
        {
           int len=ch[i];
           if(len!=0)
           {
              if(len==1)
              {
                  if(max==-1)
                  {   
                              String st=Character.toString((char)(97+i))+" "+Integer.toString(1);
                              if(map.get(st)>2)
                              {
                                  max=1;
                              }
                  }
              }
              else if(len==2)
              {
                  String st=Character.toString((char)(97+i));
             
                    if(max==-1)
                    {   
                              if(map.get(st+" "+Integer.toString(1))>1)
                              {
                                  max=1;
                              }
                    }
                  if(map.get(st+" "+Integer.toString(2))>2)
                   {
                        if(2>max)
                        {
                            max=2;
                        }
                  }
              }
              else
              {
                  String st=Character.toString((char)(97+i));
                                  if(len-2>max)
                                  {
                                      max=len-2;
                                  }

                  if(map.get(st+" "+Integer.toString(len-1))>1)
                              {
                                  if(len-1>max)
                                  {
                                      max=len-1;
                                  }
                              }
                  if(map.get(st+" "+Integer.toString(len))>2)
                              {
                                  if(len>max)
                                  {
                                      max=len;
                                  }
                              }
                  
              }
           }
        }
        
        return max;
    }
}
