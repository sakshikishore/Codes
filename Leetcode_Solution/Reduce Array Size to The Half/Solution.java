class Solution {
    public int minSetSize(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> l=new ArrayList<Integer>();
         ArrayList<Integer> p=new ArrayList<Integer>();
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++)
        {
            if(!h.containsKey(arr[i]))
            {
                l.add(arr[i]);
                h.put(arr[i],1);
                
            }
            else
            {
                h.put(arr[i],h.get(arr[i])+1);
            }
        }
        for(int i=0;i<l.size();i++)
        {
            p.add(h.get(l.get(i)));
        }
        Collections.sort(p);
        int result=0;
        int n=arr.length;
        for(int i=p.size()-1;i>=0;i--)
        {
            result++;
            n=n-p.get(i);
            if(n<=arr.length/2)
            {
                break;
            }
        }
        
        return result;
    }
}
