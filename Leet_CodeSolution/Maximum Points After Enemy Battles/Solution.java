class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);
        long point=0;
        int count=0;
        while(true)
        {
            if(count==enemyEnergies.length)
            {
                break;
            }
            if(currentEnergy>=enemyEnergies[0])
            {
                point+=(currentEnergy/enemyEnergies[0]);
                currentEnergy=currentEnergy%enemyEnergies[0];
            }
            else
            {
                break;
            }
                while(currentEnergy<enemyEnergies[0])
                {
                    currentEnergy+=enemyEnergies[enemyEnergies.length-1-count];
                    count++;
                }
        }

        return point;
    }
}
