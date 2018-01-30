func maxProfit(prices []int) int {
    profit := 0
    if(len(prices) < 2){
        return profit
    }
    for i:=1; i < len(prices); i++ {
        if prices[i] - prices[i-1] > 0{
            profit += prices[i] - prices[i-1] // simply accumulate all positive diff and drop negative ones
        }
    }
    return profit
}