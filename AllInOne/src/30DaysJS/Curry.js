/**
 * @param {Function} fn
 * @return {Function}
 */
var curry = function (fn) {
  return function curried(...args) {
    // method 1
    //   if(args.length >= fn.length) {
    //     return fn(...args);
    //   }

    //   return (...nextArgs) => {
    //     console.log(`args: ${args}`)
    //     console.log(`nextArgs: ${nextArgs}`)
    //     return curried(...args, ...nextArgs);
    //   }

    // method 2
    if (args.length >= fn.length) {
      return fn.apply(this, args);
    }

    return curried.bind(this, ...args);
  };
};

/**
 * function sum(a, b) { return a + b; }
 * const csum = curry(sum);
 * csum(1)(2) // 3
 */
