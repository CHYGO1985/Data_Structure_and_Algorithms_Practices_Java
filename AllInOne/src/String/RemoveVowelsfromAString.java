/**
 * 
 * @author jingejiejiang
 * @history Aug 26, 2020
 */
class Solution {
    public String removeVowels(String S) {
        return S.replaceAll("[aeiou]", "");
    }
}