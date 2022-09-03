class Solution {
  
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=1;i<=9;i++)
        {
            Queue<String> q=new LinkedList<String>();
            q.add(Integer.toString(i));
            HashSet<String> hset=new HashSet<String>();
            HashMap<String,Integer> h=new HashMap<String,Integer>();
            h.put(Integer.toString(i),1);
            hset.add(Integer.toString(i));
            while(q.size()>0)
            {
                String str=q.poll();
                int count=h.get(str);
                if(count==n)
                {
                   String s[]=str.split(" ");
                    String num="";
                   for(int j=0;j<s.length;j++)
                   {
                       num=num+s[j];
                   }
                  l.add(Integer.parseInt(num));
                }
                else
                {
                    String s[]=str.split(" ");
                    int x=Integer.parseInt(s[s.length-1]);
                    if(x+k<=9)
                    {
                        String p=str+" "+Integer.toString(x+k);
                        if(!hset.contains(p))
                        {
                            hset.add(p);
                            q.add(p);
                            h.put(p,count+1);
                        }
                    }
                    if(x-k>=0)
                    {
                        String p=str+" "+Integer.toString(x-k);
                        if(!hset.contains(p))
                        {
                            hset.add(p);
                            q.add(p);
                            h.put(p,count+1);
                        }
                    }
                }
            }
        }
        int arr[]=new int[l.size()];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=l.get(i);
        }
        return arr;
    }
}
