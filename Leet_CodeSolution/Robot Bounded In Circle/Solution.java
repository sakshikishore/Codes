class Solution {
    public boolean isRobotBounded(String instructions) {
       int ch[]=new int[2];
       char direction='N';
       for(int j=0;j<4;j++)
       {
            for(int i=0;i<instructions.length();i++)
            {
                if(instructions.charAt(i)=='G')
                {
                    if(direction=='N')
                    {
                        ch[0]++;
                    }
                    else if(direction=='S')
                    {
                        ch[0]--;
                    }
                    else if(direction=='E')
                    {
                        ch[1]++;
                    }
                    else
                    {
                         ch[1]--;
                    }
                }
                else
                {
                    if(instructions.charAt(i)=='L')
                    {
                        if(direction=='N')
                        {
                           direction='W'; 
                        }
                        else if(direction=='S')
                        {
                            direction='E';
                        }
                        else if(direction=='E')
                        {
                            direction='N';
                        }
                        else
                        {
                            direction='S';
                        }
                    }
                    else
                    {
                        if(direction=='N')
                        {
                           direction='E'; 
                        }
                        else if(direction=='S')
                        {
                            direction='W';
                        }
                        else if(direction=='E')
                        {
                            direction='S';
                        }
                        else
                        {
                            direction='N';
                        }
                    }
                }
            }
       }

       if(ch[0]==0 && ch[1]==0)
       {
           return true;
       }

       return false;
    }
}
