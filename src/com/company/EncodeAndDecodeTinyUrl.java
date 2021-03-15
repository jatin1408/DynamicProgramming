package com.company;
import java.util.HashMap;
import java.util.Map;
public class EncodeAndDecodeTinyUrl {
    static String baseHost="http://tinyurl.com/";
    static int counter=0;
    static Map<String,String> shortToLong=new HashMap<>();
    static Map<String,String> longToShort=new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(longToShort.containsKey(longUrl)) return longToShort.get(longUrl);
        String encoded=baseHost+ getStringBase62(counter++);
        shortToLong.put(encoded,longUrl);
        longToShort.put(longUrl,encoded);
        return encoded;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLong.get(shortUrl);
    }
    public String getStringBase62(int n){
        StringBuilder sb=new StringBuilder();
        char[] arr= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        while(n>0){
            sb.append(arr[n%62]);
            n/=62;
        }
        return sb.reverse().toString();
    }
}
