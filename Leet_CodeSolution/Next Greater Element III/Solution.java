class Solution {
    public int nextGreaterElement(int n) {
        String str=Integer.toString(n);
        char c[]=str.toCharArray();
        ArrayList<Character> l=new ArrayList<Character>();
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        l.add(c[c.length-1]);
        h.put(c[c.length-1],c.length-1);
        for(int i=c.length-2;i>=0;i--)
        {
            if(!h.containsKey(c[i]))
            {
                l.add(c[i]);
                h.put(c[i],i);
            }
            if(c[i]<c[i+1])
            {
                Collections.sort(l);
                int p=l.indexOf(c[i]);
                char val=l.get(p+1);
                int j=h.get(val);
                char temp=c[i];
                c[i]=c[j];
                c[j]=temp;
               Arrays.sort(c,i+1,c.length);
                 break;
            }
        }
        str=new String(c);
        try
        {
            int x=Integer.parseInt(str);
            if(x==n)
            {
                return -1;
            }
            else
            {
                return x;
            }
        }
        catch(Exception e)
        {
            return -1;
        }

    }
}
