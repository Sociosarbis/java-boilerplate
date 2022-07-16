package MoveAverage;

class MovingAverage {
    int length;
    int i;
    int sum;
    int[] window;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
    }
    
    public double next(int val) {
        sum += val - window[i];
        window[i] = val;
        if (length < window.length) {
            length++;
        }
        i = (i + 1) % window.length;
        return (double)sum /(double)length;
    }
}
