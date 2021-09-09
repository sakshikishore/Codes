public class Codec {

    // Encodes a URL to a shortened URL.
    HashMap<String,String> h=new HashMap<String,String>();
    int i=0;
    public String encode(String longUrl) {
        String result="";
        if(h.containsKey(longUrl))
        {
            result=h.get(longUrl);
        }
        else
        {
          result="http://tinyurl.com/"+Integer.toString(i);
            h.put(longUrl,result);
        }
        i++;
        return result;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String result="";
     for(Map.Entry<String, String> entry: h.entrySet()) {
         if(entry.getValue().equals(shortUrl))
         {
             result=entry.getKey();
             break;
         }
         
         
         
     }
        return result;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
