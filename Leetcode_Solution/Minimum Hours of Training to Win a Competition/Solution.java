class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int available_energy=initialEnergy;
        int available_experience=initialExperience;
        int count=0;
        for(int i=0;i<energy.length;i++)
        {
            if(energy[i]<available_energy && available_experience>experience[i])
            {
                available_energy=available_energy-energy[i];
                available_experience+=experience[i];
                continue;
            }
            else
            {
                if(energy[i]>=available_energy)
                {
                    count+=(1+energy[i])-available_energy;
                    available_energy=1;
                }
                else
                {
                    available_energy=available_energy-energy[i];
                }
                if(experience[i]>=available_experience)
                {
                    int p=(1+experience[i])-available_experience;
                    available_experience+=p;
                    available_experience+=experience[i];
                    count+=p;
                }
                else
                {
                    available_experience+=experience[i];
                }
            }
        }
        
        return count;
    }
}
