/**
 * 274. H-Index
 */
function hIndex(citations: number[]): number {
  let n = citations.length;
  let buckets = new Array<number>(n + 1).fill(0);

  for (const citation of citations) {
    if (citation >= n) {
      buckets[n]++;
      continue;
    }

    buckets[citation]++;
  }

  let count = 0;
  for (let idx = n; idx >= 0; idx--) {
    count += buckets[idx];
    if (count >= idx) {
      return idx;
    }
  }

  return 0;
}

// sort then one loop
// 0 1 3 5 6
// 1 3 1
