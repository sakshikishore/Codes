class Solution {
    public int minimizeXor(int num1, int num2) {
        int x=Integer.bitCount(num1);
        int y=Integer.bitCount(num2);
        if(x==y)
        {
            return num1;
        }
        else
        {
            if(x>y)
            {
                String str=Integer.toString(num1,2);
                int count=0;
                for(int i=0;i<str.length();i++)
                {
                    if(str.charAt(i)=='1')
                    {
                        count++;
                        if(count==y)
                        {
                            int p=Integer.parseInt(str.substring(i+1),2);
                            return num1^p;
                        }
                    }
                }
            }
            else
            {
                int arr[]=new int[32];
                int count=0;
                String str=Integer.toString(num1,2);
                for(int i=str.length()-1;i>=0;i--)
                {
                    if(str.charAt(i)=='1')
                    {
                        int j=str.length()-1-i;
                        arr[31-j]=1;
                        count++;
                    }
                }
                for(int i=31;i>=0;i--)
                {
                    if(arr[i]==0)
                    {
                        arr[i]=1;
                        count++;
                        if(count==y)
                        {
                            break;
                        }
                    }
                }
                int j=0;
                int result=0;
                for(int i=31;i>=0;i--)
                {
                    result+=((int)Math.pow(2,j))*arr[i];
                    j++;
                }
                
                return result;
            }
        }
        
        return 0;
        
    }
}
