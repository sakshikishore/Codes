class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        int max=0;
        for(int i=0;i<matrix.length;i++)
        {
            StringBuffer sb=new StringBuffer("");
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    sb.append("0");
                }
                else
                {
                    sb.append("1");
                }
            }
            String s=new String(sb);
            if(!map.containsKey(s))
            {
                map.put(s,1);
            }
            else
            {
                map.put(s,map.get(s)+1);
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            StringBuffer sb1=new StringBuffer("");
            StringBuffer sb2=new StringBuffer("");
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    sb1.append("0");
                    sb2.append("1");
                }
                else
                {
                    sb1.append("1");
                    sb2.append("0");
                }
            }
            String s1=new String(sb1);
            String s2=new String(sb2);
            int res=map.get(s1);
            if(map.containsKey(s2))
            {
                res=res+map.get(s2);
            }
            if(res>max){
                max=res;
            }
        }

        return max;
    }
}
