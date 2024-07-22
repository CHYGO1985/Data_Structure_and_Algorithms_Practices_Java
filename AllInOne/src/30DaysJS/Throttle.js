/**
 * 2676. Throttle
 */
/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var throttle = function (fn, t) {
  let timeoutId = null;
  let nextTimeToCallFn = 0;

  return function (...args) {
    const delay = Math.max(0, nextTimeToCallFn - Date.now());
    clearTimeout(timeoutId);
    timeoutId = setTimeout(() => {
      fn(...args);
      nextTimeToCallFn = t + Date.now();
    }, delay);
  };
};

/**
 * const throttled = throttle(console.log, 100);
 * throttled("log"); // logged immediately.
 * throttled("log"); // logged at t=100ms.
 */
