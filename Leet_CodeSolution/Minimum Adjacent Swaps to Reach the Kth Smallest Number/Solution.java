class Solution {
    public int getMinSwaps(String num, int k) {
        char c[]=num.toCharArray();
        int count=0;
        while(count<k)
        {
           ArrayList<Character> l=new ArrayList<Character>();
           HashMap<Character,Integer> h=new HashMap<Character,Integer>();
            h.put(c[c.length-1],c.length-1);
            l.add(c[c.length-1]);
            int index=0;
            for(int i=c.length-2;i>=0;i--)
            {
                if(!h.containsKey(c[i]))
                {
                    h.put(c[i],i);
                    if(l.size()==1)
                    {
                        if(l.get(0)>c[i])
                        {
                            l.add(0,c[i]);
                            index=0;
                        }
                        else
                        {
                            l.add(c[i]);
                            index=1;
                        }
                    }
                    else
                    {
                        int low=0,high=l.size()-1;
                        while(low<=high)
                        {
                            int mid=(low+high)/2;
                            if(l.get(mid)<c[i])
                            {
                                index=mid+1;
                                low=mid+1;
                            }
                            else
                            {
                                index=mid;
                                high=mid-1;
                            }
                        }
                        l.add(index,c[i]);
                    }
                    
                }
                if(c[i]<c[i+1])
                {
                    int currentElementIndex=l.indexOf(c[i]); // in ArrayList l
                    char nextGreaterElement=l.get(currentElementIndex+1);
                    int nextGreaterElement_Index=h.get(nextGreaterElement);
                    char temp=c[i];
                    c[i]=c[nextGreaterElement_Index];
                    c[nextGreaterElement_Index]=temp;
                    Arrays.sort(c,i+1,c.length);
                    break;
                }
            }
            count++;
        }
        ArrayList<Character> l=new ArrayList<Character>();
        for(int i=0;i<c.length;i++)
        {
            l.add(c[i]);
        }
        char ch[]=num.toCharArray();
        int result=0;
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i]!=l.get(i))
            {
                int r=-1;
               for(int j=i+1;j<c.length;j++)
               {
                   if(l.get(j)==ch[i])
                   {
                        r=j;
                        break;
                   }
               }
               result+=(r-i);
               l.remove(r);
               l.add(i,ch[i]);
            }
        }

        return result;
    }
}
