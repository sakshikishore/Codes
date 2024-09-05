class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            // Left to Right
            int k = 0;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#') {
                    if (k != 0) {
                        k = 0;
                    }
                } else if (k == -1) {
                    continue;
                } else if (board[i][j] == ' ') {
                    k++;
                    if (k == word.length()) {

                        if (j + 1 < board[0].length) {
                            if (board[i][j + 1] == '#') {
                                return true;
                            } else {
                                k = -1;
                            }
                        } else {
                            return true;
                        }
                    }
                } else if (board[i][j] == word.charAt(k)) {
                    k++;
                    if (k == word.length()) {
                        if (j + 1 < board[0].length) {
                            if (board[i][j + 1] == '#') {
                                return true;
                            } else {
                                k = -1;
                            }
                        } else {
                            return true;
                        }
                    }
                } else {
                    k = -1;
                }
            }
            k = 0;
            // Right to Left
            for (int j = board[0].length - 1; j >= 0; j--) {
                if (board[i][j] == '#') {
                    if (k != 0) {
                        k = 0;
                    }
                } else if (k == -1) {
                    continue;
                } else if (board[i][j] == ' ') {
                    k++;
                    if (k == word.length()) {
                        if (j - 1 >= 0) {
                            if (board[i][j - 1] == '#') {
                                return true;
                            } else {
                                k = -1;
                            }
                        } else {
                            return true;
                        }
                    }
                } else if (board[i][j] == word.charAt(k)) {
                    k++;
                    if (k == word.length()) {
                        if (j - 1 >= 0) {
                            if (board[i][j - 1] == '#') {
                                return true;
                            } else {
                                k = -1;
                            }
                        } else {
                            return true;
                        }
                    }
                } else {
                    k = -1;
                }
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            // Top to Bottom
            int k = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == '#') {
                    if (k != 0) {
                        k = 0;
                    }
                } else if (k == -1) {
                    continue;
                } else if (board[i][j] == ' ') {
                    k++;
                    if (k == word.length()) {
                        if (i + 1 < board.length) {
                            if (board[i + 1][j] == '#') {
                                return true;
                            } else {
                                k = -1;
                            }
                        }

                        else {
                            return true;
                        }
                    }
                } else if (board[i][j] == word.charAt(k)) {
                    k++;
                    if (k == word.length()) {
                        if (i + 1 < board.length) {
                            if (board[i + 1][j] == '#') {
                                return true;
                            } else {
                                k = -1;
                            }
                        }

                        else {
                            return true;
                        }
                    }
                } else {
                    k = -1;
                }
            }
            // Bottom to Top
            k = 0;
            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][j] == '#') {
                    if (k != 0) {
                        k = 0;
                    }
                } else if (k == -1) {
                    continue;
                } else if (board[i][j] == ' ') {
                    k++;
                    if (k == word.length()) {
                        if (i - 1 >= 0) {
                            if (board[i - 1][j] == '#') {
                                return true;
                            } else {
                                k = -1;
                            }
                        }

                        else {
                            return true;
                        }
                    }
                } else if (board[i][j] == word.charAt(k)) {
                    k++;
                    if (k == word.length()) {
                        if (i - 1 >= 0) {
                            if (board[i - 1][j] == '#') {
                                return true;
                            } else {
                                k = -1;
                            }
                        } else {
                            return true;
                        }
                    }
                } else {
                    k = -1;
                }
            }
        }

        return false;
    }
}
