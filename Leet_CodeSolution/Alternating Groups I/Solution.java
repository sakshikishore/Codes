class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int count=0;
        for(int i=0;i<colors.length-2;i++)
        {
            if(colors[i]==colors[i+2] && colors[i+1]!=colors[i])
            {
                count++;
            }
        }
      
            if(colors[0]==colors[colors.length-2] && colors[0]!=colors[colors.length-1])
            {
            
                  count++;
            }
            if(colors[1]==colors[colors.length-1] && colors[0]!=colors[colors.length-1])
            {
                  count++;
            }

        return count;
    }
}
