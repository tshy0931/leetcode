/*
Initialize first 2 rows as special case.
Then populate each following row with values from its previous row.
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows <= 0) return res;
        res.add(Arrays.asList(1));
        if(numRows == 1) return res;
        res.add(Arrays.asList(1,1));
        if(numRows == 2) return res;

        List<Integer> lastLevel = res.get(1);
        
        for(int i=2; i<numRows; i++){
            List<Integer> level = new ArrayList(i+1); // provide capacity to improve performance
            level.add(1);
            for(int j=1; j<i; j++){
                level.add(lastLevel.get(j-1) + lastLevel.get(j));
            }
            level.add(1);
            res.add(level);
            lastLevel = level;
        }
        return res;
    }
}
