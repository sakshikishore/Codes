class TextEditor {
    StringBuilder sb;
    int index=0;
    public TextEditor() {
        sb=new StringBuilder("");
    }
    
    public void addText(String text) {
        if(sb.length()==0)
        {
            sb.append(text);
            index=sb.length();
        }
        else
        {
            sb.insert(index,text);
            index=index+text.length();
        }
    }
    
    public int deleteText(int k) {
        if(index-k>=0)
        {
            sb.delete(index-k,index);
            index=index-k;
            return k;
        }
        else
        {
            sb.delete(0,index);
            int p=index;
            index=0;
            return p;
        }
    }
    
    public String cursorLeft(int k) {
        index=index-k;
        if(index<0)
        {
            index=0;
            return "";
        }
        else
        {
           if(index>=10)
           {
               return sb.substring(index-10,index);
           }
           else
           {
               return sb.substring(0,index);
           }
        }
    }
    
    public String cursorRight(int k) {
        if(index+k>sb.length())
        {
             index=sb.length();
        }
        else
        {
            index=index+k;
        }
        if(index>=10)
           {
               return sb.substring(index-10,index);
           }
           else
           {
               return sb.substring(0,index);
           }

    }
}
