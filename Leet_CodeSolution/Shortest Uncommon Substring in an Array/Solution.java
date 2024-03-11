class Solution {
    public String[] shortestSubstrings(String[] arr) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        HashMap<Integer,TreeSet<String>> h=new HashMap<Integer,TreeSet<String>>();
        for(int i=0;i<arr.length;i++)
        {
             TreeSet<String> tset=new TreeSet<String>();
             HashSet<String> hset=new HashSet<String>();
            for(int j=0;j<arr[i].length();j++)
            { 
                String str=""+arr[i].charAt(j);
                if(!hset.contains(str))
                {
                    if(!map.containsKey(str))
                    {
                        map.put(str,1);
                    }
                    else
                    {
                        map.put(str,2);
                    }
                }
                tset.add(str);
                hset.add(str);
                for(int k=j+1;k<arr[i].length();k++)
                {
                     str+=arr[i].charAt(k);
                    if(!hset.contains(str))
                    {
                        if(!map.containsKey(str))
                        {
                            map.put(str,1);
                        }
                        else
                        {
                            map.put(str,2);
                        }
                    }
                    tset.add(str);
                    hset.add(str);
                }
            }
            h.put(i,tset);
        }
      
        String result[]=new String[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            result[i]="";
            TreeSet<String> t=h.get(i);
            Iterator<String> itr=t.iterator();
            while(itr.hasNext())
            {
                String str=itr.next();
                if(map.get(str)==1 && (result[i].length()>str.length() || result[i].length()==0))
                {
                    result[i]=str;
                     
                }
              
            }
        }
        
        return result;
        
        
    }
}
