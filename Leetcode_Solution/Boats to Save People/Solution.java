class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int result=0;
        Arrays.sort(people);
        int i=0,j=people.length-1;
        while(i<j)
        {
            if(people[i]+people[j]<=limit)
            {
                result++;
                i++;
                j--;
            }
            else
            {
              result++;
                j--;
            }
        }
      if(i==j)
      {
          result=result+1;
      }
        return result;
        
    }
}
