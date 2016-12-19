
public class IntegerToEnglishWords {
	// Idea: use hash table to build dictionary
    // Method 1: use HashMap, 14ms, beart 9 %
    // case 1: num >= 20
    // case 2: num < 20
    
    /*
    // constants
    public int billion = 1000000000;
    public int million = 1000000;
    public int thousand = 1000;
    public int hundred = 100;
    
    public void initZeroToNine(Map<Integer, String> map) {
        
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
    }
    
    public void initTenToNitn(Map<Integer, String> map) {
        
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
    }
    
    public void initTwtyToNity(Map<Integer, String> map) {
        
        map.put(2, "Twenty");
        map.put(3, "Thirty");
        map.put(4, "Forty");
        map.put(5, "Fifty");
        map.put(6, "Sixty");
        map.put(7, "Seventy");
        map.put(8, "Eighty");
        map.put(9, "Ninety");
    }
    
    public void initBigUnit(Map<Integer, String> map) {
        
        map.put(0, "Hundred");
        map.put(1, "Thousand");
        map.put(2, "Million");
        map.put(3, "Billion");
    }

    // conver the number thas is less than 100.
    public String convertHundredLess(int num, Map<Integer, String> zeroToNine,
        Map<Integer, String> tenToNitn, Map<Integer, String> twtyToNity) {
    
        String res = "";
        
        // get the digit at 20 ... 90
        if (num >= 20) {
            
            res += twtyToNity.get(num / 10);
            num = num % 10;
            
            // get the digit from 1 to 9
            if (num != 0 ) {
                
                res += " " + zeroToNine.get(num);
            }
        }
        // if num < 20
        else {
            if (num >= 10) {
                
                res += tenToNitn.get(num);
            }
            else {
                res += zeroToNine.get(num);
            }
        }
        
        return res;
    }
    
    // conver the number that is more than 100.
    public String convertHundredMore(int num, Map<Integer, String> zeroToNine,
        Map<Integer, String> tenToNitn, Map<Integer, String> twtyToNity) {
        
        String res = "";
        // get the digit at hundred
        int hunDigit = num / hundred;
        
        if (hunDigit != 0) {
            res += zeroToNine.get(hunDigit) + " " + "Hundred";
        }
        
        num = num % hundred;
        if (0 == num) {
            return res;
        }
        
        String temp = convertHundredLess(num, zeroToNine, tenToNitn, twtyToNity);
        res = addSpace(res);
        res += temp;

        return res;
    }
    
    public String addSpace(String res) {
        
        if (false == res.equals("")) {
            
            res += " ";
        }
        
        return res;
    }
    
    public String numberToWords(int num) {
        
        if (num < 0) {
            return "Negative One";
        }
        
        if (0 == num) {
            return "Zero";    
        }
        
        String res = "";
               
        // dictionary for 0 to 9
        Map<Integer, String> zeroToNine = new HashMap<Integer, String>();
        initZeroToNine(zeroToNine);
        
        // dictionary for 10 to 19
        Map<Integer, String> tenToNitn = new HashMap<Integer, String>();
        initTenToNitn(tenToNitn);
        
        // dictionary for 20, 30,...,90
        Map<Integer, String> twtyToNity = new HashMap<Integer, String>();
        initTwtyToNity(twtyToNity);
        
        // dictionary for unit like hundred, thousand, million, billion
        Map<Integer, String> bigUnit = new HashMap<Integer, String>();
        initBigUnit(bigUnit);
        
        // num / 10 0000 0000
        if (num / billion > 0) {
            
            res += zeroToNine.get(num / billion) + " " + "Billion";
            num = num % billion;
            if (0 == num) {
                return res;
            }
        }
        
        // num / 100 0000
        if (num / million > 0) {
            
            res = addSpace(res);
            res += convertHundredMore(num / million, zeroToNine, 
                tenToNitn, twtyToNity) + " " + "Million";
            num = num % million; 
            if (0 == num) {
                return res;
            }
        }
        
        // num / 1000
        if (num / thousand > 0) {
            
            res = addSpace(res);
            res += convertHundredMore(num / thousand, zeroToNine, 
                tenToNitn, twtyToNity) + " " + "Thousand";
            num = num % thousand;
            if (0 == num) {
                return res;
            }
        }
        
        res = addSpace(res);
        
        // num / 100
        if (num / hundred > 0) {
            
            res += convertHundredMore(num, zeroToNine, 
                tenToNitn, twtyToNity);
            //num = num % hundred;
        }
        else {
            res += convertHundredLess(num, zeroToNine, 
                tenToNitn, twtyToNity);
        }
        
        return res;
    }
    */
	
	// Method 2: improve: make 0-9 and 10-20 in the same collection and use Arrary
    // runtime: 5m, 23%, beat 34%, fastest in the database is 3ms
    
     // constants
    public int billion = 1000000000;
    public int million = 1000000;
    public int thousand = 1000;
    public int hundred = 100;
    
    public void initZeroToNitn(String[] zeroToNitn) {
        
        zeroToNitn[0] = "Zero";
        zeroToNitn[1] = "One";
        zeroToNitn[2] = "Two";
        zeroToNitn[3] = "Three";
        zeroToNitn[4] = "Four";
        zeroToNitn[5] = "Five";
        zeroToNitn[6] = "Six";
        zeroToNitn[7] = "Seven";
        zeroToNitn[8] = "Eight";
        zeroToNitn[9] = "Nine";
        zeroToNitn[10] = "Ten";
        zeroToNitn[11] = "Eleven";
        zeroToNitn[12] = "Twelve";
        zeroToNitn[13] = "Thirteen";
        zeroToNitn[14] = "Fourteen";
        zeroToNitn[15] = "Fifteen";
        zeroToNitn[16] = "Sixteen";
        zeroToNitn[17] = "Seventeen";
        zeroToNitn[18] = "Eighteen";
        zeroToNitn[19] = "Nineteen";
    }
    
    public void initTwtyToNity(String[] twtyToNity) {
        
        twtyToNity[0] = "";
        twtyToNity[1] = "";
        twtyToNity[2] = "Twenty";
        twtyToNity[3] = "Thirty";
        twtyToNity[4] = "Forty";
        twtyToNity[5] = "Fifty";
        twtyToNity[6] = "Sixty";
        twtyToNity[7] = "Seventy";
        twtyToNity[8] = "Eighty";
        twtyToNity[9] = "Ninety";
    }
    

    // conver the number thas is less than 100.
    public String convertHundredLess(int num, String[] zeroToNitn, String[] twtyToNity) {
    
        String res = "";
        
        // get the digit at 20 ... 90
        if (num >= 20) {
            
            res += twtyToNity[num / 10];
            num = num % 10;
            
            // get the digit from 1 to 9
            if (num != 0 ) {
                
                res += " " + zeroToNitn[num];
            }
        }
        // if num < 20
        else {
                
            res += zeroToNitn[num];
        }
        
        return res;
    }
    
    // conver the number that is more than 100.
    public String convertHundredMore(int num, String[] zeroToNitn, String[] twtyToNity) {
        
        String res = "";
        // get the digit at hundred
        int hunDigit = num / hundred;
        
        if (hunDigit != 0) {
            res += zeroToNitn[hunDigit] + " " + "Hundred";
        }
        
        num = num % hundred;
        if (0 == num) {
            return res;
        }
        
        String temp = convertHundredLess(num, zeroToNitn, twtyToNity);
        res = addSpace(res);
        res += temp;

        return res;
    }
    
    public String addSpace(String res) {
        
        if (false == res.equals("")) {
            
            res += " ";
        }
        
        return res;
    }
    
    public String numberToWords(int num) {
        
        if (num < 0) {
            return "Negative One";
        }
        
        if (0 == num) {
            return "Zero";    
        }
        
        String res = "";
               
        // dictionary for 0 to 19
        String[] zeroToNitn = new String[20];
        initZeroToNitn(zeroToNitn);
        
        // dictionary for 20, 30,...,90
        String[] twtyToNity = new String[10];
        initTwtyToNity(twtyToNity);
        
        // num / 10 0000 0000
        if (num / billion > 0) {
            
            res += zeroToNitn[num / billion] + " " + "Billion";
            num = num % billion;
            if (0 == num) {
                return res;
            }
        }
        
        // num / 100 0000
        if (num / million > 0) {
            
            res = addSpace(res);
            res += convertHundredMore(num / million, zeroToNitn, twtyToNity) + " " + "Million";
            num = num % million; 
            if (0 == num) {
                return res;
            }
        }
        
        // num / 1000
        if (num / thousand > 0) {
            
            res = addSpace(res);
            res += convertHundredMore(num / thousand, zeroToNitn, twtyToNity) + " " + "Thousand";
            num = num % thousand;
            if (0 == num) {
                return res;
            }
        }
        
        res = addSpace(res);
        
        // num / 100
        if (num / hundred > 0) {
            
            res += convertHundredMore(num, zeroToNitn, twtyToNity);
            //num = num % hundred;
        }
        else {
            res += convertHundredLess(num, zeroToNitn, twtyToNity);
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
