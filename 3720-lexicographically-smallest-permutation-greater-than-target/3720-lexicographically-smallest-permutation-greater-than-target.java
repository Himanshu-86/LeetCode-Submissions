class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] total = new int[26];

        for (char c : s.toCharArray())
            total[c - 'a']++;

        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            int[] rem = total.clone();
            boolean valid = true;

            for (int j = 0; j < i; j++) {
                int x = target.charAt(j) - 'a';
                rem[x]--;

                if (rem[x] < 0) {
                    valid = false;
                    break;
                }
            }

            if (!valid)
                continue;

            int x = target.charAt(i) - 'a';

            for (int c = x + 1; c < 26; c++) {
                if (rem[c] > 0) {
                    StringBuilder ans =
                        new StringBuilder(target.substring(0, i));

                    ans.append((char)('a' + c));
                    rem[c]--;

                    for (int k = 0; k < 26; k++) {
                        while (rem[k] > 0) {
                            ans.append((char)('a' + k));
                            rem[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}