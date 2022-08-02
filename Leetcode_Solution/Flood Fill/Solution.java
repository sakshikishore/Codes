class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<String> q=new LinkedList();
        int startColor=image[sr][sc];
        if(startColor==color)
        {
            return image;
        }
        image[sr][sc]=color; 
        q.add(Integer.toString(sr)+" "+sc);
        while(q.size()>0)
        {
            String s[]=q.poll().split(" ");
            sr=Integer.parseInt(s[0]);
            sc=Integer.parseInt(s[1]);
            if(sr+1<image.length)
            {
                if(image[sr+1][sc]==startColor)
                {
                    image[sr+1][sc]=color;
                    q.add(Integer.toString(sr+1)+" "+Integer.toString(sc));
                }
            }
            if(sr-1>=0)
            {
                if(image[sr-1][sc]==startColor)
                {
                    image[sr-1][sc]=color;
                    q.add(Integer.toString(sr-1)+" "+Integer.toString(sc));
                }
            }
            if(sc+1<image[0].length)
            {
                if(image[sr][sc+1]==startColor)
                {
                    image[sr][sc+1]=color;
                    q.add(Integer.toString(sr)+" "+Integer.toString(sc+1));
                }
            }
             if(sc-1>=0)
            {
                if(image[sr][sc-1]==startColor)
                {
                    image[sr][sc-1]=color;
                    q.add(Integer.toString(sr)+" "+Integer.toString(sc-1));
                }
            }
        }
        
        return image;
    }
}
