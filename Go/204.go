/**
keep an slice, dict, of boolean, if i is not a prime number, dict[i] is true.
starting from 2, if a number , j, is prime, imcrement count and set times of j to be non-prime.
*/
func countPrimes(n int) int {
    if n < 2 {
        return 0
    }
    dict := make([]bool, n)
    count := 0
    for i:=2; i<n; i++ {
        if !dict[i] {
            count++
            for j:=2; i*j < n; j++ {
                dict[i*j] = true
            }
        }
    }
    return count
}
