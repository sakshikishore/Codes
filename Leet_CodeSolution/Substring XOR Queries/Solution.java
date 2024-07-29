class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        HashMap<String,Integer> h=new HashMap<String,Integer>();
        int result[][]=new int[queries.length][2];
        for(int i=0;i<s.length();i++)
        {
            String str=""+s.charAt(i);
            if(!h.containsKey(str))
            {
                h.put(str,i);
            }
            if(s.charAt(i)=='1')
            {
                for(int j=i+1;j<i+32 && j<s.length();j++)
                {
                    str+=s.charAt(j);
                    if(!h.containsKey(str))
                    {
                        h.put(str,i);
                    }
                }
            }
        }
        for(int i=0;i<queries.length;i++)
        {
            result[i][0]=-1;
            result[i][1]=-1;
            int x=queries[i][0]^queries[i][1];
            String str=Integer.toBinaryString(x);
            if(h.containsKey(str))
            {
                 result[i][0]=h.get(str);
                 result[i][1]=result[i][0]+str.length()-1;
            }
        }

        return result;
    }
}
