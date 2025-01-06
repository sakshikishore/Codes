class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       HashMap<Integer,Double> h=new HashMap<Integer,Double>();
       for(int i=0;i<position.length;i++)
       {
        double x=(target-position[i])*1.0;
        h.put(position[i],x/speed[i]);
       }

       Arrays.sort(position);
       Stack<Double> stck=new Stack<Double>();
       stck.push(h.get(position[position.length-1]));
       int i=position.length-2;
       while(i>=0)
       {
         if(h.get(position[i])>stck.peek())
         {
            stck.push(h.get(position[i]));
         }
         i--;
       }

       return stck.size();
    }
}
