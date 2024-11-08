/**
 Do not return anything, modify nums1 in-place instead.
 */
 function merge(nums1: number[], m: number, nums2: number[], n: number): void {
  let idx1 = m - 1, idx2 = n - 1, idxTail = m + n - 1

  while (idx1 >= 0 && idx2 >= 0) {
      nums1[idxTail -- ] = nums1[idx1] < nums2[idx2] ? nums2[idx2 --] : nums1[idx1 --]
  }

  while (idx1 >= 0) {
      nums1[idxTail --] = nums1[idx1 --]
  }

  while (idx2 >= 0) {
      nums1[idxTail --] = nums2[idx2 --]
  }
};