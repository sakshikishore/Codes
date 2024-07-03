/*

If number is divisible by 3, then its digits sum will also be divisible by 3.

At first we will sort the digits.
We will take sum of all digits value, if sum will divisible by 3, then we will store the value in result by iterating digits from right to left(to get maximum value)
Here I have taken 4 variables a,b,c,d. We will store smallest 1 remainder index in a and 2nd smallest 1 remainder index in and e will store smallest 2 remainder index in c and 2nd smallest 1 remainder index in d.
If total digits sum remainder is 1, then we will check 'a' if it has some value then we will store all the digits value in result except a index value. We will iterate digits from right to left(to get maximum value). If 'a' value is -1,then we will take 'c' and 'd' value and exclude them from our result((digits[c]+digits[d])%3==1).
If total digits sum remainder is 2, then we will check 'c' if it has some value then we will store all the digits value in result except c index value. We will iterate digits from right to left(to get maximum value). If 'c' value is -1,then we will take 'a' and 'b' value and exclude them from our result((digits[a]+digits[b])%3==2).
/*

Code
class Solution {
    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        if(digits[0]==0 && digits[digits.length-1]==0)
        {
            return "0";
        }
        int a=-1,b=-1; // we will store smallest 1 remainder index in a and 2nd smallest 1 remainder index in b;
        int c=-1,d=-1; // we will store smallest 2 remainder index in c and 2nd smallest 1 remainder index in d;
        int sum=0;
        for(int i=0;i<digits.length;i++)
        {
            sum+=digits[i];
            if(digits[i]%3==1)
            {
                if(a==-1)
                {
                    a=i;
                }
                else if(b==-1)
                {
                     b=i;
                }
            }
            else if(digits[i]%3==2)
            {
                if(c==-1)
                {
                    c=i;
                }
                else if(d==-1)
                {
                    d=i;
                }
            }
        }
        String res="";
        if(sum%3==0)
        {
            for(int i=digits.length-1;i>=0;i--)
            {
                res+=Integer.toString(digits[i]);
            }

            return res;
        }
        else if(sum%3==1)
        {
            if(a!=-1)
            {
                for(int i=digits.length-1;i>=0;i--)
                {
                    if(i!=a)
                    {
                    res+=Integer.toString(digits[i]);
                    }
                }
            }
            else
            {
                for(int i=digits.length-1;i>=0;i--)
                {
                    if(i!=c && i!=d)
                    {
                    res+=Integer.toString(digits[i]);
                    }
                }
            }
        }
        else
        {
            if(c!=-1)
            {
                for(int i=digits.length-1;i>=0;i--)
                {
                    if(i!=c)
                    {
                    res+=Integer.toString(digits[i]);
                    }
                }
            }
            else
            {
                for(int i=digits.length-1;i>=0;i--)
                {
                    if(i!=a && i!=b)
                    {
                    res+=Integer.toString(digits[i]);
                    }
                }
            }
        }
        if(res.length()==0)
        {
            return "";
        }
      if(res.charAt(0)=='0' && res.charAt(res.length()-1)=='0')
      {
        return "0";
      }

       return res;

    }
}
