class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        if(tomatoSlices%2==0 && cheeseSlices<=tomatoSlices/2)
        {
            int flag=0;
            int jumbo=0,small=0;
            while(flag!=1)
            {
                if(tomatoSlices==cheeseSlices*2)
                {
                    small+=cheeseSlices;
                    break;
                }
                else if(tomatoSlices==cheeseSlices*2)
                {
                  jumbo+=cheeseSlices;
                  break;
                }
                else if(tomatoSlices>cheeseSlices*2 && tomatoSlices<cheeseSlices*4)
                {
                    tomatoSlices-=4;
                    jumbo+=1;
                    cheeseSlices--;
                }
                else
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                l.add(jumbo);
                l.add(small);
            }
        }
        
        return l;
    }
}
