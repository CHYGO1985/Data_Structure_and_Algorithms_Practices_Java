/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function (fn, t) {
  // check the execution time: always need to wait until the end of fn execution
  // improve ==> do not need to wait?
  return async function (...args) {
    // method 1
    // return new Promise((res, rej) => {
    //     const timeoutId = setTimeout(() => {
    //         rej("Time Limit Exceeded")
    //     }, t)

    //     fn(...args).then(res).catch(rej).finally(() => clearTimeout(timeoutId))
    // })

    // method 2
    // return new Promise(async (res, rej) => {
    //     const timeoutId = setTimeout(() => {
    //         rej("Time Limit Exceeded")
    //     }, t)

    //     try {
    //         const result = await fn(...args)
    //         res(result)
    //     } catch (err) {
    //         rej(err)
    //     }
    //     clearTimeout(timeoutId)
    // })

    // method 3
    const timeoutPromise = new Promise((resolve, reject) => {
      setTimeout(() => reject('Time Limit Exceeded'), t);
    });
    const returnedPromise = fn(...args);

    return Promise.race([timeoutPromise, returnedPromise]);
  };
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */
