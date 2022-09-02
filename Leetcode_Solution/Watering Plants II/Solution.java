class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int i=0,j=plants.length-1;
        int count=0;
        int cap_A=capacityA,cap_B=capacityB;
        while(i<j)
        {
            // Alice
            if(plants[i]>cap_A)
            {
                cap_A=capacityA;
                cap_A=cap_A-plants[i];
                count++;
            }
            else
            {
                 cap_A=cap_A-plants[i];
            }
            // Bob
            if(plants[j]>cap_B)
            {
                cap_B=capacityB;
                cap_B=cap_B-plants[j];
                count++;
            }
            else
            {
                 cap_B=cap_B-plants[j];
            }  
            i++;
            j--;
        }
        
        if(i==j)
        {
            int max=Math.max(cap_A,cap_B);
            if(plants[i]>max)
            {
                count++;
            }
            
        }
        
        return count;
    }
}
