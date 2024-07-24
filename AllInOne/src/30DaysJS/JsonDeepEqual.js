/**
 * 2628. JSON Deep Equal
 */
/**
 * @param {null|boolean|number|string|Array|Object} o1
 * @param {null|boolean|number|string|Array|Object} o2
 * @return {boolean}
 */
var areDeeplyEqual = function (o1, o2) {
  // check if typeof equals
  // if not return false
  // if yes
  // check if it is Object
  // if yes, check if it is Array
  // if yes, compare length and all ele
  // if not, check keys size and all key-value pairs
  // if not, check they are primitive types, check if they are equal

  // if all undefined, null, primitive
  if (o1 === o2) return true;
  // if one of them is null
  if (o1 === null || o2 === null) return false;
  // if the type is not equal
  if (String(o1) !== String(o2)) return false;

  // if it is not an object
  // if (typeof o1 !== 'object') {
  // return o1 === o2;
  // }

  // if they are arrays
  if (Array.isArray(o1)) {
    if (o1.length !== o2.length) return false;

    for (let i = 0; i < o1.length; i++) {
      if (!areDeeplyEqual(o1[i], o2[i])) return false;
    }

    return true;
  }

  // if they are objects
  if (Object.keys(o1).length !== Object.keys(o2).length) return false;

  for (const key in o1) {
    if (!areDeeplyEqual(o1[key], o2[key])) return false;
  }

  return true;
};
