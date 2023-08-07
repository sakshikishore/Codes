class Solution {
    public int uniqueLetterString(String s) {
        HashMap<Character,ArrayList<Integer>> h=new HashMap<Character,ArrayList<Integer>>();
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            if(!h.containsKey(s.charAt(i)))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(s.charAt(i),l);
            }
            else
            {
                ArrayList<Integer> l=h.get(s.charAt(i));
                l.add(i);
                h.put(s.charAt(i),l);
            }
        }
        for(int i=0;i<s.length();i++)
        {
            System.out.println(result);
            if(h.get(s.charAt(i)).size()==1)
            {
                result+=(i+1)*(s.length()-i);
            }
            else
            {
                ArrayList<Integer> l=h.get(s.charAt(i));
                int low=0,high=l.size()-1,index=0;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(l.get(mid)==i)
                    {
                        index=mid;
                        break;
                    }
                    else if(l.get(mid)>i)
                    {
                        high=mid-1;
                    }
                    else
                    {
                        low=mid+1;
                    }
                }
                if(index==0)
                {
                    result+=(l.get(index)+1)*(l.get(index+1)-l.get(index));
                }
                else if(index==l.size()-1)
                {
                    result+=(l.get(index)-l.get(index-1))*(s.length()-l.get(index));
                }
                else
                {
                     result+=(l.get(index)-l.get(index-1))*((l.get(index+1)-l.get(index)));
                }

            }
        }

        return result;
    }
}
