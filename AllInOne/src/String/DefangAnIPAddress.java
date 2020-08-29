/**
 * @history Aug 25, 2020
 * @author CHYGO1985
 */
class Solution {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}