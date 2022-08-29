class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int result[]=new int[k];
        Arrays.sort(arr);
        int mid=(arr.length-1)/2;
        int median=arr[mid];
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<arr.length;i++)
        {
            int x=Math.abs(arr[i]-median);
            if(!h.containsKey(x))
            {
                pq.add(x);
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(arr[i]);
                h.put(x,l);
            }
            else
            {
                 ArrayList<Integer> l=h.get(x);
                 l.add(arr[i]);
                 h.put(x,l);
            }
        }
        int count=0;
        while(pq.size()>0)
        {
            int x=pq.poll();
            ArrayList<Integer> l=h.get(x);
            Collections.sort(l);
            for(int i=l.size()-1;i>=0;i--)
            {
                result[count]=l.get(i);
                count++;
                if(count==k)
                {
                    break;
                }
            }
            if(count==k)
            {
                break;
            }
        }
        
        return result;
    }
}
