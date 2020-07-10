class Solution {
    public List<Integer> filterRestaurants(int[][] restaurant, int veganFriendly, int maxPrice, int maxDistance) {
        ArrayList<Integer> l=new ArrayList<Integer>();
         ArrayList<Integer> s=new ArrayList<Integer>();
       
            for(int i=0;i<restaurant.length;i++)
            {
                if(veganFriendly==1)
                {
                   if(restaurant[i][2]==1 && restaurant[i][3]<=maxPrice && restaurant[i][4]<=maxDistance )
                    {
                        l.add(restaurant[i][0]);
                       s.add(i);
                    }
                }
                else
                {
                     if(restaurant[i][3]<=maxPrice && restaurant[i][4]<=maxDistance )
                     {  
                            l.add(restaurant[i][0]);
                            s.add(i);
                     }
                }
            }
        
     for(int i=0;i<l.size();i++)
     {
         for(int j=i+1;j<l.size();j++)
         {
             if(restaurant[s.get(i)][1]<restaurant[s.get(j)][1])
             {
                 int temp=l.get(i);
                 l.set(i,l.get(j));
                 l.set(j,temp);
                 
                 int t=restaurant[s.get(i)][1];
                 restaurant[s.get(i)][1]=restaurant[s.get(j)][1];
                 restaurant[s.get(j)][1]=t;
                 
                 
             }
             else if(restaurant[s.get(i)][1]==restaurant[s.get(j)][1])
             {
                 if(l.get(i)<l.get(j))
                 {
                     int temp=l.get(i);
                     l.set(i,l.get(j));
                     l.set(j,temp);

                     int t=restaurant[s.get(i)][1];
                     restaurant[s.get(i)][1]=restaurant[s.get(j)][1];
                     restaurant[s.get(j)][1]=t;
                 }
             }
         }
     }
        
        return l;
        
        
        
    }
}
