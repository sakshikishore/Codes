class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky=false,heavy=false;
        if(length>=10000 || height>=10000 || width>=10000)
        {
            bulky=true;
        }
        else
        {
            long volume=1;
            volume=volume*length*width*height;
            if(volume>=1000000000)
            {
                bulky=true; 
            }
        }
        
        if(mass>=100)
        {
            heavy=true;
        }
        
        if(bulky && heavy)
        {
            return "Both";
        }
        if(!bulky && !heavy)
        {
            return "Neither";
        }
        if(!bulky && heavy)
        {
            return "Heavy";
        }
        
        return "Bulky";
        
    }
}
