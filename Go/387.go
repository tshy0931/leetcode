/*
Count frequency of all chars appear in the string into a map.
iterate thru the string to return index of the first char that has frequency of 1.

Can be optimized with int array instead of map in specific for string input type.
*/
func firstUniqChar(s string) int {
    dict := make(map[rune]int)
    for i, ch := range s {
        if _, ok := dict[ch]; ok {
            dict[ch] = -1
        } else {
            dict[ch] = i
        }
    }
    for _, ch := range s {
        if dict[ch] != -1 {
            return dict[ch]
        }
    }
    return -1
}
