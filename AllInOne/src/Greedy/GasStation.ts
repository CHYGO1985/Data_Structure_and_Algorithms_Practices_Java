/**
 * 134. Gas Station
 */
function canCompleteCircuit(gas: number[], cost: number[]): number {
  // binary search where left < mid and mid > right
  let curGas = 0,
    totalGas = 0,
    pos = 0;

  if (!gas || !cost || gas.length !== cost.length) return undefined;

  for (let idx = 0; idx < gas.length; idx++) {
    curGas += gas[idx] - cost[idx];
    totalGas += gas[idx] - cost[idx];

    if (curGas < 0) {
      pos = idx + 1;
      curGas = 0;
    }
  }

  return totalGas >= 0 ? pos : -1;
}
