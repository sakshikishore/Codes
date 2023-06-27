class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String str1[]=sentence1.split(" ");
        String str2[]=sentence2.split(" ");
        boolean result=true;
        // Case1: Insert sentence in Sentence2
        int flag=0;
        HashMap<String,ArrayList<Integer>> h=new HashMap<String,ArrayList<Integer>>();
        for(int i=0;i<str1.length;i++)
        {
            if(!h.containsKey(str1[i]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(str1[i],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(str1[i]);
                l.add(i);
                h.put(str1[i],l);
            }
        }
        int index=-1;
        for(int i=0;i<str2.length;i++)
        {
              if(!h.containsKey(str2[i]))
              {
                  result=false;
                  break;
              }
              else
              {
                  ArrayList<Integer> l=h.get(str2[i]);
                  int x=l.get(0);
                  if(x<index)
                  {
                      result=false;
                      break;
                  }
                  if(x-index!=1)
                  {
                      if(flag==0)
                      {
                          flag=1;
                      }
                      else
                      {
                          result=false;
                          break;
                      }
                  }
                  index=x;
                  l.remove(0);
                  if(l.size()==0)
                  {
                      h.remove(str2[i]);
                  }
                  else
                  {
                      h.put(str2[i],l);
                  }
              }
        }
        if(result && flag==1 && index!=str1.length-1)
                {
                    result= false;
                }

       if(!result)
       {
           result=true;
           flag=0;
           h=new HashMap<String,ArrayList<Integer>>();
        for(int i=0;i<str1.length;i++)
        {
            if(!h.containsKey(str1[i]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(str1[i],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(str1[i]);
                l.add(i);
                h.put(str1[i],l);
            }
        }
        index=str1.length;
        for(int i=str2.length-1;i>=0;i--)
        {
              if(!h.containsKey(str2[i]))
              {
                  result=false;
                  break;
              }
              else
              {
                  ArrayList<Integer> l=h.get(str2[i]);
                  int x=l.get(l.size()-1);
                  if(x>index)
                  {
                      result=false;
                      break;
                  }
                  if(index-x!=1)
                  {
                      if(flag==0)
                      {
                          flag=1;
                      }
                      else
                      {
                          result=false;
                          break;
                      }
                  }
                  index=x;
                  l.remove(l.size()-1);
                  if(l.size()==0)
                  {
                      h.remove(str2[i]);
                  }
                  else
                  {
                      h.put(str2[i],l);
                  }
              }
        }
        if(result && flag==1 && index!=0)
                {
                    result= false;
                }
       }
/////////////////////////////////////////////////////////////////////////////////////////////
       if(!result)
       {
           result=true;
           // Case2: Insert sentence in Sentence1
        flag=0;
         h=new HashMap<String,ArrayList<Integer>>();
        for(int i=0;i<str2.length;i++)
        {
            if(!h.containsKey(str2[i]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(str2[i],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(str2[i]);
                l.add(i);
                h.put(str2[i],l);
            }
        }
        index=-1;
        for(int i=0;i<str1.length;i++)
        {
              if(!h.containsKey(str1[i]))
              {
                  result= false;
                  break;
              }
              else
              {
                  ArrayList<Integer> l=h.get(str1[i]);
                  int x=l.get(0);
                  if(x<index)
                  {
                      result=false;
                      break;
                  }
                  if(x-index!=1)
                  {
                      if(flag==0)
                      {
                          flag=1;
                      }
                      else
                      {
                          result=false;
                          break;
                      }
                  }
                  index=x;
                  l.remove(0);
                  if(l.size()==0)
                  {
                      h.remove(str1[i]);
                  }
                  else
                  {
                      h.put(str1[i],l);
                  }
              }
        }
        if(result && flag==1 && index!=str2.length-1)
        {
            result= false;
        }
            if(!result)
            {
                result=true;
                index=str2.length;
                flag=0;
                h=new HashMap<String,ArrayList<Integer>>();
                for(int i=0;i<str2.length;i++)
                {
                    if(!h.containsKey(str2[i]))
                    {
                        ArrayList<Integer> l=new ArrayList<Integer>();
                        l.add(i);
                        h.put(str2[i],l);
                    }
                    else
                    {
                        ArrayList<Integer> l=h.get(str2[i]);
                        l.add(i);
                        h.put(str2[i],l);
                    }
                }
                for(int i=str1.length-1;i>=0;i--)
                {
                    if(!h.containsKey(str1[i]))
                    {
                        return false;
                    }
                    else
                    {
                        ArrayList<Integer> l=h.get(str1[i]);
                        int x=l.get(l.size()-1);
                        if(x>index)
                        {
                            return false;
                        }
                        if(index-x!=1)
                        {
                            if(flag==0)
                            {
                                flag=1;
                            }
                            else
                            {
                                return false;
                            }
                        }
                        index=x;
                        l.remove(l.size()-1);
                        if(l.size()==0)
                        {
                            h.remove(str1[i]);
                        }
                        else
                        {
                            h.put(str1[i],l);
                        }
                    }
                }
                if(flag==1 && index!=0)
                {
                    return false;
                }
            }
       }
        return true;
    }
}
