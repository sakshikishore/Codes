class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> list=new ArrayList();
        StringBuffer sb1=new StringBuffer("");
        StringBuffer sb2=new StringBuffer("");
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)==s2.charAt(i))
            {
                if(sb1.length()>0)
                {
                    ArrayList<String> l=new ArrayList<String>();
                    l.add(new String(sb1));
                    l.add(new String(sb2));
                    list.add(l);
                    sb1=new StringBuffer("");
                    sb2=new StringBuffer("");
                }
            }else
                {
                    sb1.append(s1.charAt(i));
                    sb2.append(s2.charAt(i));
                }
        }
        if(sb1.length()>0)
                {
                    ArrayList<String> l=new ArrayList<String>();
                    l.add(new String(sb1));
                    l.add(new String(sb2));
                    list.add(l);
                }

                return list;
    }
}
