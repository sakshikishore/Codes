class Solution {
    public char[][] rotateTheBox(char[][] box) {
        char arr[][]=new char[box[0].length][box.length];
         int p=0;
        for(int i=box.length-1;i>=0;i--)
        {
            int l=arr.length-1;
            for(int j=box[i].length-1;j>=0;j--)
            {
                if(box[i][j]=='*')
                {
                    arr[l][p]='*';
                    l--;
                }
                else
                {
                    if(box[i][j]=='#')
                    {
                        arr[l][p]='#';
                        int r=l;
                        for(int k=l+1;k<arr.length;k++)
                        {
                            if(arr[k][p]=='*' || arr[k][p]=='#')
                            {
                                break;
                            }
                            else if(arr[k][p]=='.')
                            {
                                arr[r][p]='.';
                                arr[k][p]='#';
                                r=k;
                            }
                        }
                    }
                    else
                    {
                        arr[l][p]='.';
                    }
                    l--;
                }
            }
            p++;
        }
        
        return arr;
        
    }
}
