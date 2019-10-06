package HashTable;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * @jingjiejiang May 29, 2019
 */
public class EncodeAndDecodeTinyURL {
	
	private static final String BASE_HOST = "http://tinyurl.com/";
    private static final String SEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LEN = 6;

    private Map<String, String> urlToKey = new HashMap<>();
    private Map<String, String> keyToUrl = new HashMap<>();
	
	// Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
    	if (urlToKey.containsKey(longUrl)) return urlToKey.get(longUrl);
    	
    	StringBuilder builder = new StringBuilder();
    	
    	String key = null;
    	do {
    		for (int count = 0; count < SHORT_URL_LEN; count ++) {
        		
        		builder.append(SEED.charAt((int)Math.random() * SEED.length()));
        	}
    		key = BASE_HOST + builder.toString();
    	}
    	while (keyToUrl.containsKey(key));
    	
    	urlToKey.put(longUrl, key);
    	keyToUrl.put(key, longUrl);
    	
    	return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        
    	return keyToUrl.getOrDefault(shortUrl, "");
    }
}
