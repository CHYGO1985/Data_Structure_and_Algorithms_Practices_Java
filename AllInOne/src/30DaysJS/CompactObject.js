/**
 * 2705. Compact Object
 */
/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function (obj) {
  function dfs(obj) {
    if (!obj) return false;
    if (typeof obj !== 'object') return obj;

    if (Array.isArray(obj)) {
      const newArr = [];
      for (let idx = 0; idx < obj.length; idx++) {
        const curr = obj[idx];
        const subRes = dfs(curr);

        if (subRes) {
          newArr.push(subRes);
        }
      }

      return newArr;
    }

    const newObj = {};

    for (const key in obj) {
      const subRes = dfs(obj[key]);
      if (subRes) {
        newObj[key] = subRes;
      }
    }

    return newObj;
  }

  return dfs(obj);
};
