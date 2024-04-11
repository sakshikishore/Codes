class Solution {
    public String[] getFolderNames(String[] names) {
        String result[]=new String[names.length];
        HashMap<String,Integer> h=new HashMap<String,Integer>();
        for(int i=0;i<names.length;i++)
        {
            if(!h.containsKey(names[i]))
            {
                h.put(names[i],0);
                result[i]=names[i];
            }
            else
            {
                int x=h.get(names[i]);
                String p=names[i]+"("+(x+1)+")";
                while(h.containsKey(p))
                {
                    x++;
                    p=names[i]+"("+(x+1)+")";
                }
                h.put(names[i],x+1);
                result[i]=p;
                h.put(result[i],0);
            }
        }
        return result;
    }
}
