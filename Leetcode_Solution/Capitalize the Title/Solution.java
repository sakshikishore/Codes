class Solution {
    public String capitalizeTitle(String title) {
        String arr[]=title.split(" ");
        String res="";
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].length()<3)
            {
              res=res+arr[i].toLowerCase()+" ";
            }
            else
            {
                res+=arr[i].substring(0,1).toUpperCase()+arr[i].substring(1).toLowerCase()+" ";
            }
        }
        
        res=res.substring(0,res.length()-1);
        return res;
        
    }
}
