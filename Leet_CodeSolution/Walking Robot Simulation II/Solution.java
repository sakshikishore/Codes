class Robot {
    int index=0;
    int m=0,n=0;
    int total=0;
    int flag=0;
    public Robot(int width, int height) {
        m=height;
        n=width;
        total=(2*m+2*n)-4;
    }
    
    public void step(int num) {
      num=num%total;
      index=(index+num)%total; 
      flag=1;
    }
    
    public int[] getPos() {
        int result[]=new int[2];
         if(index<n)
         {
            result[1]=0;
            result[0]=index;
         }
         else if(index>=n && index<m+n-1)
         {
            result[1]=index-n+1;
            result[0]=n-1;
         }
         else if(index>=m+n-1 && index<m+n-2+n)
         {
            result[1]=m-1;
            int p=index-(m+n-1);
            result[0]=n-2-p;
         }
         else
         {
             int p=index-(m+n-2+n);
            result[1]=m-1-(p+1);
            result[0]=0;
         }
        return result;
    }
    
    public String getDir() {
        if(index==0 && flag==1)
        {
            return "South";
        }
          if(index<n)
         {
           return "East";
         }
         else if(index>=n && index<m+n-1)
         {
            return "North";
         }
         else if(index>=m+n-1 && index<m+n-2+n)
         {
            return "West";
         }
         
            return "South";

    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
