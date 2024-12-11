class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int arr[]=new int[s.length()];
        char res[]=new char[s.length()];
        for(int i=0;i<shifts.length;i++)
        {
            if(shifts[i][2]==1)
            {
               arr[shifts[i][0]]+=1;
                if(shifts[i][1]<s.length()-1)
                {
                    arr[shifts[i][1]+1]-=1;
                }
            }
            else
            {
                 arr[shifts[i][0]]-=1;
                if(shifts[i][1]<s.length()-1)
                {
                    arr[shifts[i][1]+1]+=1;
                }
            }
        }
       
        for(int i=0;i<arr.length;i++)
        {
            if(i>0)
            {
                 arr[i]=arr[i-1]+arr[i];
            }
            int p=s.charAt(i)-'a';
            if(arr[i]>0)
            {
                arr[i]=arr[i]%26;
                p=(p+arr[i])%26;
                res[i]=(char)(97+p);
            }
            else if(arr[i]<0)
            {
               int x=-1*arr[i];
               x=x%26;
               p=(p-x+26)%26;  
               res[i]=(char)(97+p);
            }
            else
            {
                res[i]=(char)(97+p);
            }
        }

        return new String(res);
    }
}
