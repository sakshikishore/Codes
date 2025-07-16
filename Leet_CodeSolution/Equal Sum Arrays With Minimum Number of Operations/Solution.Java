class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int count = 0;
        if (nums1.length > 6 * nums2.length || nums2.length > 6 * nums1.length) {
            return -1;
        }
        int sum1 = 0, sum2 = 0;
        int arr1[] = new int[7];
        int arr2[] = new int[7];
        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
            arr1[nums1[i]]++;
            ;
        }
        for (int i = 0; i < nums2.length; i++) {
            sum2 += nums2[i];
            arr2[nums2[i]]++;
            ;
        }

        if (sum1 == sum2) {
            return 0;
        }
        if (sum1 > sum2) {
            int diff = sum1 - sum2;
            while (diff > 0) {
                if (arr1[6] != 0) {
                    arr1[6]--;
                    diff = diff - 5;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }
                } else if (arr2[1] != 0) {
                    arr2[1]--;
                    count++;
                    diff = diff - 5;
                    if (diff <= 0) {
                        return count;
                    }
                } else if (arr1[5] != 0) {
                    arr1[5]--;
                    diff = diff - 4;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }
                } else if (arr2[2] != 0) {
                    arr2[2]--;
                    diff = diff - 4;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }

                } else if (arr1[4] != 0) {
                    arr1[4]--;
                    diff = diff - 3;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }
                } else if (arr2[3] != 0) {
                    arr2[3]--;
                    diff = diff - 3;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }

                } else if (arr1[3] != 0) {
                    arr1[3]--;
                    diff = diff - 2;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }
                } else if (arr2[4] != 0) {
                    arr2[4]--;
                    diff = diff - 2;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }

                } else if (arr1[2] != 0) {
                    arr1[2]--;
                    diff = diff - 1;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }
                } else if (arr2[5] != 0) {
                    arr2[5]--;
                    diff = diff - 1;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }

                }

            }
        } else {
            int diff = sum2 - sum1;
            while (diff > 0) {
                if (arr2[6] != 0) {
                    arr2[6]--;
                    diff = diff - 5;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }
                } else if (arr1[1] != 0) {
                    arr1[1]--;
                    count++;
                    diff = diff - 5;
                    if (diff <= 0) {
                        return count;
                    }
                } else if (arr2[5] != 0) {
                    arr2[5]--;
                    diff = diff - 4;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }
                } else if (arr1[2] != 0) {
                    arr1[2]--;
                    diff = diff - 4;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }

                } else if (arr2[4] != 0) {
                    arr2[4]--;
                    diff = diff - 3;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }
                } else if (arr1[3] != 0) {
                    arr1[3]--;
                    diff = diff - 3;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }

                } else if (arr2[3] != 0) {
                    arr2[3]--;
                    diff = diff - 2;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }
                } else if (arr1[4] != 0) {
                    arr1[4]--;
                    diff = diff - 2;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }

                } else if (arr2[2] != 0) {
                    arr2[2]--;
                    diff = diff - 1;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }
                } else if (arr1[5] != 0) {
                    arr1[5]--;
                    diff = diff - 1;
                    count++;
                    if (diff <= 0) {
                        return count;
                    }

                }

            }
        }

        return -1;

    }
}
