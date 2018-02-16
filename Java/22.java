/*
DFS

Recursively search for valid parentheses, rules are:
a. number of ")" cannot be more than number of "("
b. there can be at most n instances of "(". add ")" to n instances
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        gen(n, 0, 0, "", res);
        return res;
    }
    
    private void gen(int n, int nLeft, int nRight, String s, List<String> res) {
        if(nLeft == n){
            while(nRight++ < n){
                s += ")";
            }
            res.add(s);
            return;
        }
        else if(nLeft == 0){
            gen(n, 1, 0, "(", res);
        }
        else{
            gen(n, nLeft+1, nRight, s + "(", res);
            if(nRight < nLeft){
                gen(n, nLeft, nRight+1, s + ")", res);
            }
        }
    }
}
