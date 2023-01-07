/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function (nums1, m, nums2, n) {
  if (!nums1 || !nums2) return;

  let idxM = m - 1,
    idxN = n - 1,
    tailIdx = m + n - 1;

  while (idxM >= 0 && idxN >= 0) {
    nums1[tailIdx--] =
      nums1[idxM] >= nums2[idxN] ? nums1[idxM--] : nums2[idxN--];
  }

  while (idxM >= 0) {
    nums1[tailIdx--] = nums1[idxM--];
  }

  while (idxN >= 0) {
    nums1[tailIdx--] = nums2[idxN--];
  }
};
