package src.DyanmicProgramming;

/**
 * 2272. Substring With Largest Variance
 */
public class SubstringWithLargestVariance {
  public int largestVariance(String s) {

        assert s != null && s.length() > 0;

        int[] counter = new int[26];
        int globalMax = 0;

        for (char c : s.toCharArray()) {
            counter[c - 'a'] += 1;
        }

        // head as major, tail as minor
        for (int head = 0; head < 26; head ++) {
            for (int tail = 0; tail < 26; tail ++) {

                // exclude unnecessary case
                if (head == tail || counter[head] == 0 || counter[tail] == 0) {
                    continue;
                }

                char major = (char)('a' + head);
                char minor = (char)('a' + tail);
                int majorCharCnt = 0;
                int minorChatCnt = 0;
                int minorRest = counter[tail];

                for (char c : s.toCharArray()) {
                    if (c == major) {
                        majorCharCnt ++;
                    }
                    else if (c == minor) {
                        minorChatCnt ++;
                        minorRest --;
                    }

                    if (minorChatCnt > 0) {
                        globalMax = Math.max(globalMax, majorCharCnt - minorChatCnt);
                    }

                    if (minorRest > 0 && majorCharCnt < minorChatCnt) {
                        majorCharCnt = 0;
                        minorChatCnt = 0;
                    }
                }
            }
        }

        return globalMax;
    }
}
