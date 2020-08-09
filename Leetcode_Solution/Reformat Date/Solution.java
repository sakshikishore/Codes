class Solution {
    public String reformatDate(String date) {
        String p[]=date.split(" ");
        HashMap<String,String> h=new HashMap<String,String>();
        h.put("Jan","01");
        h.put("Feb","02");
        h.put("Mar","03");
        h.put("Apr","04");
        h.put("May","05");
        h.put("Jun","06");
        h.put("Jul","07");
        h.put("Aug","08");
        h.put("Sep","09");
        h.put("Oct","10");
        h.put("Nov","11");
        h.put("Dec","12");
        
        String k=p[0].substring(0,p[0].length()-2);
        if(k.length()==1)
        {
            k="0"+k;
        }
        
        String result=p[2]+"-"+h.get(p[1])+"-"+k;
        
        return result;
        
    }
}
