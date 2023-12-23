class Solution {
    public boolean isPathCrossing(String path) {
        int x=0,y=0; // N-> y++, S-> y-- || E-> x++, W-> x--;
        HashSet<String> hset=new HashSet<String>();
        hset.add("0 0");
        for(int i=0;i<path.length();i++)
        {
            if(path.charAt(i)=='N')
            {
                y++;
            }
            else if(path.charAt(i)=='S')
            {
                y--;
            }
            else if(path.charAt(i)=='W')
            {
                x--;
            }
            else if(path.charAt(i)=='E')
            {
                x++;
            }
            String str=Integer.toString(x)+" "+Integer.toString(y);
            if(hset.contains(str))
            {
                return true;
            }
            hset.add(str);
           
        }

        return false;
    }
}
