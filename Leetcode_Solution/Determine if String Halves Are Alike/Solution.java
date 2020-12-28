class Solution {
    public boolean halvesAreAlike(String s) {
        boolean result=false;
        String str=s.toLowerCase();
        int a=0,b=0;
        for(int i=0;i<s.length()/2;i++)
        {
            if(str.charAt(i)=='a'||str.charAt(i)=='e'|| str.charAt(i)=='i'|| str.charAt(i)=='o'|| str.charAt(i)=='u')
            {
                a++;
            }
        }
        for(int i=s.length()/2;i<s.length();i++)
        {
             if(str.charAt(i)=='a'||str.charAt(i)=='e'|| str.charAt(i)=='i'||       str.charAt(i)=='o'|| str.charAt(i)=='u')
            {
                b++;
            }
        }
        if(a==b)
        {
            result=true;
        }

        return result;
    }
}
