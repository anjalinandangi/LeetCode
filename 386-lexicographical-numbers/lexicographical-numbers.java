class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        
        
        for (int i = 1; i <= 9
        ; i++) {
            if (i > n) break; 
            solve(i, n, ans);
        }
        
        return ans;  
    }
    
    private void solve(int curr, int n, List<Integer> ans) {
              if (curr > n) {
            return;
        }
        ans.add(curr);
        for (int append = 0; append <= 9; append++) {
            int newNumber = curr * 10 + append;
            if (newNumber > n) {
                break; 
            }
            
            solve(newNumber, n, ans);
        }
    }
}