/**
 * 2633.Convert Object to JSON String
 */
/**
 * @param {null|boolean|number|string|Array|Object} object
 * @return {string}
 */
var jsonStringify = function (object) {
  // if it is null
  if (object === null) {
    return 'null';
  }

  // if it is Array
  if (Array.isArray(object)) {
    const elements = object.map((ele) => jsonStringify(ele));
    return `[${elements.join(',')}]`;
  }

  // if it is object
  if (typeof object === 'object') {
    const keys = Object.keys(object);
    const keyValuePairs = keys.map(
      (key) => `"${key}":${jsonStringify(object[key])}`
    );
    return `{${keyValuePairs.join(',')}}`;
  }

  // if it is string
  if (typeof object === 'string') {
    return `"${object}"`;
  }

  // other primitives
  return String(object);
};
