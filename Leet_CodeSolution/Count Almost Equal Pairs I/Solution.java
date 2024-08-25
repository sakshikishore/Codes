class Solution {
    public int countPairs(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            
            String str1=Integer.toString(nums[i]);
            for(int j=i+1;j<nums.length;j++)
            {
                
                if(nums[j]==nums[i])
                {
                    
                    result++;
                   
                }
                else
                {
                   
                    int count=0;
                     String str2=Integer.toString(nums[j]);
                     if(str1.length()==str2.length())
                     {
                        
                        int a1=-1,b1=-1,a2=-1,b2=-1;
                        for(int k=0;k<str1.length();k++)
                        {
                            if(str1.charAt(k)!=str2.charAt(k))
                            {
                                if(count==0)
                                {
                                    a1=str1.charAt(k);
                                    b1=str2.charAt(k);
                                }
                                else if(count==1)
                                {
                                    a2=str1.charAt(k);
                                    b2=str2.charAt(k);
                                }
                                else
                                {
                                    count=3;
                                    break;
                                }

                                count++;
                            }
                        }
                        if(count==2)
                        {
                            if(a1==b2 && a2==b1)
                            {
                              
                                result++;
                            }
                        }
                     }
                     else
                     {
                       
                            if(str1.length()<str2.length())
                            {
                                while(str1.length()<str2.length())
                                {
                                    str1="0"+str1;
                                }
                            }
                            else
                            {
                                while(str2.length()<str1.length())
                                {
                                  str2="0"+str2;
                                }
                            }
                           
                        int a1=-1,b1=-1,a2=-1,b2=-1;
                        for(int k=0;k<str1.length();k++)
                        {
                            if(str1.charAt(k)!=str2.charAt(k))
                            {
                                if(count==0)
                                {
                                    a1=str1.charAt(k);
                                    b1=str2.charAt(k);
                                }
                                else if(count==1)
                                {
                                    a2=str1.charAt(k);
                                    b2=str2.charAt(k);
                                }
                                else
                                {
                                    count=3;
                                    break;
                                }

                                count++;
                            }
                        }
                        if(count==2)
                        {
                            if(a1==b2 && a2==b1)
                            {
                                
                                result++;
                            }
                        }
                        
                     }

                }
            }
        }

        return result;
    }
}
