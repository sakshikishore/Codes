class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        HashMap<String,Integer> h=new HashMap<String,Integer>();
        List<List<Integer>> list=new ArrayList();
        for(int i=0;i<coordinates.size();i++)
        {
            String str=Integer.toString(coordinates.get(i).get(0))+" "+Integer.toString(coordinates.get(i).get(1));
            if(!h.containsKey(str))
            {
                h.put(str,1);
                ArrayList<Integer> al=new ArrayList<Integer>();
                al.add(coordinates.get(i).get(0));
                al.add(coordinates.get(i).get(1));
                list.add(al);
                
            }
            else
            {
                h.put(str,h.get(str)+1);
            }
        }
        HashSet<String> hset=new HashSet<String>();
        long result=0;
        for(int j=0;j<list.size();j++)
        {
            int x1=list.get(j).get(0);
            int y1=list.get(j).get(1);
            String str1=Integer.toString(x1)+" "+Integer.toString(y1);
            for(int i=0;i<=k;i++)
            {
                int x2=x1^i;
                int y2=y1^(k-i);
                String str2=Integer.toString(x2)+" "+Integer.toString(y2);
                String p1=str1+" "+str2;
                String p2=str2+" "+str1;
                
                if(h.containsKey(str2))
                {
                    if(str1.equals(str2))
                    {
                        long x=h.get(str1)-1;
                        result+=((x)*(x+1))/2;
                        hset.add(p1);
                        hset.add(p2);
                    }
                    else
                    {
                        if(!hset.contains(p1) && !hset.contains(p2))
                        {
                                result+=1l*h.get(str1)*h.get(str2);
                                hset.add(p1);
                                hset.add(p2);
                        }
                        
                    }
                }
            }
        }
        
        return (int)result;
    }
}
