class Spreadsheet {
    int arr[][];
    public Spreadsheet(int rows) {
        arr=new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int x=cell.charAt(0)-'A';
        int row=Integer.parseInt(cell.substring(1))-1;
        arr[row][x]=value;
    }
    
    public void resetCell(String cell) {
        int x=cell.charAt(0)-'A';
        int row=Integer.parseInt(cell.substring(1))-1;
        arr[row][x]=0;
    }
    
    public int getValue(String formula) {
        String str[]=formula.split("\\+");
        int X=0,Y=0;
        if(str[0].charAt(1)>='A' && str[0].charAt(1)<='Z')
        {
             int row=Integer.parseInt(str[0].substring(2))-1;
              X=arr[row][str[0].charAt(1)-'A'];
        }
        else
        {
            X=Integer.parseInt(str[0].substring(1));
        }
         if(str[1].charAt(0)>='A' && str[1].charAt(0)<='Z')
        {
             int row=Integer.parseInt(str[1].substring(1))-1;
             Y=arr[row][str[1].charAt(0)-'A'];
        }
        else
        {
            Y=Integer.parseInt(str[1].substring(0));
        }

        return X+Y;
        
    }
}
