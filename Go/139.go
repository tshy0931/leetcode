/*
Dynamic Programming

traverse the string and track checkpoints: indexes that are reachable by composing words in the wordDict. Initial checkpoint is -1.
for each index i, search checkPoints we have to find a path to i, if there exists a path, add i to checkPoints.
search starting from the nearest checkPoint from i for better performance.
Return true if the last byte of input string s is a checkpoint, otherwise false.
*/
func wordBreak(s string, wordDict []string) bool {
    
    checkPoints := make([]int, 0, len(s))
    checkPoints = append(checkPoints, -1)
    
    dict := make(map[string]bool)
    for _, str := range wordDict {
        dict[str] = true
    }
    
    for i:=0; i<len(s); i++ {
        leng := len(checkPoints)
        for j:=1; j<=leng; j++ {
            tail := s[checkPoints[leng-j]+1:i+1]
            if dict[tail] {
                checkPoints = append(checkPoints, i)
                break
            }
        }
        fmt.Println(checkPoints)
    }
    return checkPoints[len(checkPoints)-1] == len(s)-1
}

