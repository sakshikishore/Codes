class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Double> pq=new PriorityQueue<Double>();
        HashMap<Double,ArrayList<Integer>> h=new HashMap<Double,ArrayList<Integer>>();
        int arr[][]=new int[k][2];
        for(int i=0;i<points.length;i++)
        {
        double x=Math.sqrt((points[i][0]*points[i][0])+(points[i][1]*points[i][1]));
            pq.add(x);
            if(!h.containsKey(x))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(x,l);
            }
            else
            {
                ArrayList<Integer> l=h.get(x);
                l.add(i);
                h.put(x,l);
            }
        }
        
        for(int i=0;i<k;i++)
        {
            double x=pq.poll();
            ArrayList<Integer> l=h.get(x);
            int index=l.get(0);
            arr[i][0]=points[index][0];
            arr[i][1]=points[index][1];
            l.remove(0);
            h.put(x,l);
            
            
        }
        
        return arr;

        }
}
