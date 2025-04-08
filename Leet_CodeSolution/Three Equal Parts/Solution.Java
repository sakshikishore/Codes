class Solution {
    public int[] threeEqualParts(int[] arr) {
        int result[] = new int[2];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        if (count == 0) {
            result[0] = 0;
            result[1] = 2;
            return result;
        }
        if (count % 3 != 0) {
            result[0] = -1;
            result[1] = -1;
            return result;
        } else {
            int i = -1, j = -1;
            int ch = 0;
            int y = arr.length - 1;
            while (y >= 0 && arr[y] == 0) {
                ch++;
                y--;
            }
            int x = 0;
            int n = count / 3;
            int c = 0;
            StringBuffer sb1 = new StringBuffer("");
            while (x < arr.length && c < n) {
                if (c == 0) {
                    if (arr[x] == 1) {
                        c = 1;
                        sb1.append("1");
                    }
                } else {
                    if (arr[x] == 1) {
                        c++;
                        sb1.append("1");
                    } else {
                        sb1.append("0");
                    }
                }
                x++;
            }
            c = 0;
            while (x < arr.length && c < ch) {
                if (arr[x] == 1) {
                    result[0] = -1;
                    result[1] = -1;
                    return result;
                } else {
                    sb1.append("0");
                    c++;
                }
                x++;
            }
            i = x-1;
            StringBuffer sb2 = new StringBuffer("");
            c = 0;
            while (x < arr.length && c < n) {
                if (c == 0) {
                    if (arr[x] == 1) {
                        c = 1;
                        sb2.append("1");
                    }
                } else {
                    if (arr[x] == 1) {
                        c++;
                        sb2.append("1");
                    } else {
                        sb2.append("0");
                    }
                }
                x++;
            }
            c = 0;
            while (x < arr.length && c < ch) {
                if (arr[x] == 1) {
                    result[0] = -1;
                    result[1] = -1;
                    return result;
                } else {
                    sb2.append("0");
                    c++;
                }
                x++;
            }
            j = x;
            String str1 = new String(sb1);
            String str2 = new String(sb2);
            if (str1.equals(str2)) {
                StringBuffer sb3 = new StringBuffer("");
                c = 0;
                while (x < arr.length && c < n) {
                    if (c == 0) {
                        if (arr[x] == 1) {
                            c = 1;
                            sb3.append("1");
                        }
                    } else {
                        if (arr[x] == 1) {
                            c++;
                            sb3.append("1");
                        } else {
                            sb3.append("0");
                        }
                    }
                    x++;
                }
                while (x < arr.length) {
                    sb3.append("0");
                    x++;
                }
                String str3 = new String(sb3);
                if (str3.equals(str2)) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                } else {
                    result[0] = -1;
                    result[1] = -1;
                    return result;
                }

            } else {
                result[0] = -1;
                result[1] = -1;
                return result;
            }

        }
    }
}
