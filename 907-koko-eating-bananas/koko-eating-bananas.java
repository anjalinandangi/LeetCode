import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Find the maximum value in piles to set the upper limit
        int max = 0;
        for (int p : piles) max = Math.max(max, p);
        
        int left = 1, right = max;
        
        // Binary search for the best speed
        while (left < right) {
            int mid = left + (right - left) / 2;
            long hours = 0;
            
            // Calculate total hours taken at speed 'mid'
            for (int p : piles) {
                hours += (p + mid - 1) / mid;
            }
            
            // If Koko finishes in time, try a slower speed (left half)
            if (hours <= h) {
                right = mid;
            } else { // Too slow, increase speed (right half)
                left = mid + 1;
            }
        }
        
        return left;
    }
}
