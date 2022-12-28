class Allocator {
    int arr[];
    public Allocator(int n) {
        arr=new int[n];
    }
    
    public int allocate(int size, int mID) {
        int count=0;
        int startIndex=-1;
        int flag=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            {
                if(count==0)
                {
                    startIndex=i;
                    count++;
                    if(count==size)
                    {
                        flag=1;
                        break;

                    }
                }
                else
                {
                    count++;
                    if(count==size)
                    {
                        flag=1;
                        break;

                    }
                }
            }
            else
            {
               count=0; 
            }
        }

        if(flag==1)
        {
            for(int i=startIndex;i<startIndex+size;i++)
            {
                arr[i]=mID;
            }

            return startIndex;
        }

        return -1;
    }
    
    public int free(int mID) {
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==mID)
            {
                arr[i]=0;
                count++;
            }
        }

        return count;
    }
}
