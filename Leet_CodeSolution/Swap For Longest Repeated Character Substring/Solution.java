class Solution {
    public int maxRepOpt1(String text) {
        HashMap<Character,ArrayList<Integer>> h=new HashMap<Character,ArrayList<Integer>>();
        for(int i=0;i<text.length();i++)
        {
            if(!h.containsKey(text.charAt(i)))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(text.charAt(i),l);
            }
            else
            {
                ArrayList<Integer> l=h.get(text.charAt(i));
                l.add(i);
                h.put(text.charAt(i),l);
            }
        }
        int max=0;
        for(int j=0;j<26;j++)
        {
            if(h.containsKey((char)(97+j)))
            {
                ArrayList<Integer> l=h.get((char)(97+j));
                int count=1;
                int end=-1;
                int start=0;
                for(int i=1;i<l.size();i++)
                {
                    if(end!=i)
                    {
                    if(l.get(i)-l.get(i-1)==1)
                    {
                        count++;
                    }
                    else if(l.get(i)-l.get(i-1)==2)
                    {
                            if(start==0)
                            {
                                if(l.size()-1!=i)
                                {
                                    start=i;
                                    end=l.size()-1;
                                    count+=2;
                                }
                                else
                                {
                                    count++;
                                    if(count>max)
                                    {
                                        max=count;
                                    }
                                }
                            }
                        else
                        {
                            if(count>max)
                            {
                                max=count;
                            }
                                count=i-start+2;
                                start=i;
                                end=-1;
                        }
                    }
                    else
                    {
                        end=-1;
                        if(start==0)
                        {
                            if(count+1>max)
                            {
                                max=count+1;
                            }
                        }
                          else if(count>max)
                          {
                            max=count;
                          }
                          start=i;
                          count=2;
                              
                    }
                }
                }
                if(count>max)
                {
                    max=count;
                }
               
            }
        }

        return max;
    }
}
