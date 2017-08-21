/**
 * 
 * round 1: 
 * 
 * idea: from divide two to divide three
 * 
 * 1) cann't find any regulation when draw from 1 to 14
 * 2) so go back to try to find the best strategy first
 * 
 * 1) the best strategy is binary search and I did not explore it well for best strategy
 * and then I went for divide for 3 parts, however, I still can't find any regulation.
 * 
 * at the beginning, from 1 to 14, I only find out that compare the n-1 + n- 3 with n- 3 + min[n - 4], in which use n -3 first,
 * however it cannot be scaled to larger number like 50.
 * 
 * 2) I go back to binary search
 * for 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * I find that the matching point is 13 --> 13 can identify 12 and 14, so next point to divide the part is 11
 * 8 9 10 *11* 12 13 14, 
 * 3) and 11 it still does not cover all eles so go to next point, which is 7, so 1 2 3 4 5 6 *7* 8 9 10 11 12 13 14
 * so 7 is the
 * 
 * divide three still does not work, so go back and start from scratch and draw from 1 to 15 and try to find regulation
 *  
 * 
 * @author jingjiejiang
 *
 */
public class GuessNumHigherOrLowerII {

}
