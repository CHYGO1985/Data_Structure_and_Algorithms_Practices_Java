/**
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function (fn, args, t) {
  // method 1
  // const timeoutId = setTimeout(() => fn.apply(null, args), t)
  // const cancelFn = () => clearTimeout(timeoutId)
  // return cancelFn

  // method 2
  // const timeoutId = setTimeout(() => fn(...args), t)
  // const cancelFn = () => clearTimeout(timeoutId)
  // return cancelFn

  let isCancelled = false;

  console.log(1);

  setTimeout(() => {
    if (!isCancelled) {
      fn(...args);
      console.log(2);
    }
  }, t);

  console.log(3);

  return () => {
    console.log(4);
    isCancelled = true;
  };
};

// Console (1, 3 will always print out no matter cancelTimeMs > t)
// 1
// 3
// 2
// 4

/**
 *  const result = [];
 *
 *  const fn = (x) => x * 5;
 *  const args = [2], t = 20, cancelTimeMs = 50;
 *
 *  const start = performance.now();
 *
 *  const log = (...argsArr) => {
 *      const diff = Math.floor(performance.now() - start);
 *      result.push({"time": diff, "returned": fn(...argsArr)});
 *  }
 *
 *  const cancel = cancellable(log, args, t);
 *
 *  const maxT = Math.max(t, cancelTimeMs);
 *
 *  setTimeout(cancel, cancelTimeMs);
 *
 *  setTimeout(() => {
 *      console.log(result); // [{"time":20,"returned":10}]
 *  }, maxT + 15)
 */
