class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        Set<Character> allowedSet = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            allowedSet.add(ch);
        }

        for (String word : words) {
            if (isContain(word, allowedSet)) {
                count++;
            }
        }
        return count;
    }

    private boolean isContain(String word, Set<Character> allowedSet) {
        for (char ch : word.toCharArray()) {
            if (!allowedSet.contains(ch)) {
                return false;
            }
        }
        return true;
    }
}