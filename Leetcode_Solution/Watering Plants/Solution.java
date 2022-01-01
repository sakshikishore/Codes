class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int count=0;
        int x=capacity;
       for(int i=0;i<plants.length;i++)
       {
           if(plants[i]<=capacity)
           {
               capacity=capacity-plants[i];
               count++;
           }
           else
           {
               capacity=x;
               count=count+i+1+i;
               capacity=capacity-plants[i];
           }
       }
        return count;
    }
}
