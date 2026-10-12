class BusBooking {
    int totalBookingCost=0;
    int total=0;
    int booking[][];
    public BusBooking(int n) {
       booking=new int[n+1][4];
    }
    
    public void toggle(String seat) {
        int col=seat.charAt(0)-'A';
        int row=Integer.parseInt(seat.substring(1));
        if(booking[row][col]!=0)
        {
            totalBookingCost-=booking[row][col];
            booking[row][col]=0;
            total--;
        }
        else
        {
            if(col==1 || col==2)
            {
                totalBookingCost+=1;
                booking[row][col]=1;
                total++;
            }
            else if(col==0)
            {
                if(booking[row][1]==1)
                {
                    totalBookingCost+=3;
                    booking[row][col]=3;
                    total++;
                }
                else
                {
                    totalBookingCost+=1;
                    booking[row][col]=1;
                    total++;
                }
            }
            else
            {
                if(booking[row][2]==1)
                {
                    totalBookingCost+=3;
                    booking[row][col]=3;
                    total++;
                }
                else
                {
                    totalBookingCost+=1;
                    booking[row][col]=1;
                    total++;
                }
            }
        }
        
    }
    
    public int getTotalTime() {
        return totalBookingCost;
    }
    
    public int getMinTime() {
        return total;
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */
