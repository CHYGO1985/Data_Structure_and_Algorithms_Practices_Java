/**
 * 2636. Promise Pool
 */
/**
 * @param {Function[]} functions
 * @param {number} n
 * @return {Promise<any>}
 */
var promisePool = async function (functions, n) {
  const executeNext = async () => {
    if (functions.length === 0) return;
    const fn = functions.shift();
    await fn();
    await executeNext();
  };

  const executeAll = Array(n).fill().map(executeNext);
  await Promise.all(executeAll);
};

/**
 * const sleep = (t) => new Promise(res => setTimeout(res, t));
 * promisePool([() => sleep(500), () => sleep(400)], 1)
 *   .then(console.log) // After 900ms
 */
