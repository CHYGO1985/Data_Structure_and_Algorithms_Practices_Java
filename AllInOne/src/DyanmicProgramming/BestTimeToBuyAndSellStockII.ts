function maxProfit(prices: number[]): number {
  if (!prices || prices.length === 0) return NaN

  // idx 0: sell, idx 1: buy
  let profits: number[] = [0, - prices[0]]
  let prevProfit = 0

  for (let idx = 0; idx < prices.length; idx ++) {

      prevProfit = profits[0]
      profits[0] = Math.max(profits[0], profits[1] + prices[idx])
      profits[1] = Math.max(profits[1], prevProfit - prices[idx])
  }

  return profits[0]
};s