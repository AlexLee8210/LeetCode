public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String k : strs) {
            sb.append(k.length()).append("_").append(k);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int n = 0;
        int i = 0;
        char[] chars = s.toCharArray();

        while (i < chars.length) {
            while (i < chars.length && chars[i] != '_' && Character.isDigit(chars[i])) {
                n = n * 10 + (chars[i] - '0');
                i++;
            }
            i++;
            StringBuilder sb = new StringBuilder("");
            for (int j = 0; j < n; j++) {
                sb.append(chars[j + i]);
            }
            res.add(sb.toString());
            i += n;
            n = 0;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));