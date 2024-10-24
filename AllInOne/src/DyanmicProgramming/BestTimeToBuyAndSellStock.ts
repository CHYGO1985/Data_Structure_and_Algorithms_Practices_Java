function maxProfit(prices: number[]): number {
  if (!prices || prices.length < 1) return NaN;

  // idx 0: sell, idx 1: buy
  let profits: number[] = [0, 0];
  profits[0] = 0;
  profits[1] = -prices[0];

  for (let idx = 1; idx < prices.length; idx++) {
    profits[0] = Math.max(profits[0], profits[1] + prices[idx]);
    profits[1] = Math.max(profits[1], -prices[idx]);
    console.log(`idx: ${idx} : ${profits[0]}`);
  }

  return profits[0];
}
