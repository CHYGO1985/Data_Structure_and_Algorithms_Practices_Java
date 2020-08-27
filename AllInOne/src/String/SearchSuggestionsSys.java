import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * ref: https://leetcode.com/problems/search-suggestions-system/discuss/436674/C%2B%2BJavaPython-Sort-and-Binary-Search-the-Prefix
 * 
 * @author jingjiejiang 
 * @history Aug 27, 2020
 */
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> res = new ArrayList<>();
        TreeMap<String, Integer> productsMap = new TreeMap<>();
        Arrays.sort(products);
        List<String> productsList = Arrays.asList(products);

        for (int idx = 0; idx < productsList.size(); idx ++) {
            productsMap.put(products[idx], idx);
        }

        String key = "";
        for (char c : searchWord.toCharArray()) {
            key += c;
            String ceiling = productsMap.ceilingKey(key);
            String floor = productsMap.floorKey(key + "~");
            if (ceiling == null || floor == null) break;
            res.add(productsList.subList(productsMap.get(ceiling), Math.min(productsMap.get(ceiling) + 3, productsMap.get(floor) + 1)));
        }

        while (res.size() < searchWord.length()) res.add(new ArrayList<>());

        return res;
    }
}