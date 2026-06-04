class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        res.add("");
        for (int d = 0; d < digits.length(); d++) {
            String letters = map[digits.charAt(d) - '0'];
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < res.size(); i++) {
                String curr = res.get(i);
                for (int j = 0; j < letters.length(); j++) {
                    temp.add(curr + letters.charAt(j));

                }
            }
            res = temp;
        }
        return res;
    }
}