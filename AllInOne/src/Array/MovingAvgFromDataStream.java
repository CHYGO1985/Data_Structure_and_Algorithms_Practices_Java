/**
 * 
 * 346. Moving Average from Data Stream
 * 
 * @author jingjiejiang
 * @history Sep 11, 2020
 * 
 */
class MovingAverage {
    
    private int count;
    private int[] windows;
    private int idx;
    private int sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        
        windows = new int[size];
        sum = 0;
        count = 0;
        idx = -1;
    }
    
    public double next(int val) {
        
        if (count < windows.length) count ++;
        
        idx += 1;
        int newIdx = idx % windows.length;
        if (idx >= windows.length) {
            sum -= windows[newIdx];
        } 
        windows[newIdx] = val;
        sum += val;     
        
        return (double)sum / count;
    }
}