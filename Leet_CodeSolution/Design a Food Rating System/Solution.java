class FoodRatings {
    HashMap<String,ArrayList<Integer>> cuisineRatingMap;
    HashMap<String,HashMap<Integer,TreeMap<String,Integer>>> map;
    HashMap<String,String> foodCusineMap=new HashMap<String,String>();
    HashMap<String,Integer> foodRatingMap=new HashMap<String,Integer>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineRatingMap=new HashMap<String,ArrayList<Integer>>();
        map=new HashMap<String,HashMap<Integer,TreeMap<String,Integer>>>();
        for(int i=0;i<foods.length;i++)
        {
            foodCusineMap.put(foods[i],cuisines[i]);
            foodRatingMap.put(foods[i],ratings[i]);
            if(!map.containsKey(cuisines[i]))
            {
                HashMap<Integer,TreeMap<String,Integer>> h=new HashMap<Integer,TreeMap<String,Integer>>();
                TreeMap<String,Integer> tmap=new TreeMap<String,Integer>();
                tmap.put(foods[i],1);
                h.put(ratings[i],tmap);
                map.put(cuisines[i],h);
            }
            else
            {
                HashMap<Integer,TreeMap<String,Integer>> h=map.get(cuisines[i]);
                if(h.containsKey(ratings[i]))
                {
                    TreeMap<String,Integer> tmap=h.get(ratings[i]);
                    tmap.put(foods[i],1);
                    h.put(ratings[i],tmap);
                    map.put(cuisines[i],h);
                }
                else
                {
                    TreeMap<String,Integer> tmap=new TreeMap<String,Integer>();
                    tmap.put(foods[i],1);
                    h.put(ratings[i],tmap);
                    map.put(cuisines[i],h);
                }
                
            }
        }
        for(int i=0;i<cuisines.length;i++)
        {
            if(!cuisineRatingMap.containsKey(cuisines[i]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(ratings[i]);
                cuisineRatingMap.put(cuisines[i],l);
            }
            else
            {
                ArrayList<Integer> l=cuisineRatingMap.get(cuisines[i]);
                int low=0,high=l.size()-1,index=0;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(l.get(mid)>ratings[i])
                    {
                        index=mid;
                        high=mid-1;
                    }
                    else
                    {
                        index=mid+1;
                        low=mid+1;
                    }
                }
                l.add(index,ratings[i]);
                cuisineRatingMap.put(cuisines[i],l);
            }
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine=foodCusineMap.get(food);
        int prevRating=foodRatingMap.get(food);
        foodRatingMap.put(food,newRating);
        ArrayList<Integer> l=cuisineRatingMap.get(cuisine);
        int low=0,high=l.size()-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(l.get(mid)==prevRating)
            {
                l.remove(mid);
                break;
            }
            else if(l.get(mid)>prevRating)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        low=0;
        high=l.size()-1;
        int index=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(l.get(mid)>newRating)
            {
                index=mid;
                high=mid-1;
            }
            else
            {
                index=mid+1;
                low=mid+1;
            }
        }
        l.add(index,newRating);
        cuisineRatingMap.put(cuisine,l);
        HashMap<Integer,TreeMap<String,Integer>> h=map.get(cuisine);
        h.get(prevRating).remove(food);
        if(h.get(prevRating).size()==0)
        {
            h.remove(prevRating);
        }
        if(!h.containsKey(newRating))
        {
            TreeMap<String,Integer> tmap=new TreeMap<String,Integer>();
            tmap.put(food,1);
            h.put(newRating,tmap);
        }
        else
        {
            TreeMap<String,Integer> tmap=h.get(newRating);
            tmap.put(food,1);
            h.put(newRating,tmap);
        }
         map.put(cuisine,h);
        

    }
    
    public String highestRated(String cuisine) {
        ArrayList<Integer> l=cuisineRatingMap.get(cuisine);
        int highestRating= l.get(l.size()-1);
        HashMap<Integer,TreeMap<String,Integer>> h=map.get(cuisine);
        return h.get(highestRating).firstKey();

    }
}
