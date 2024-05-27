class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int n1 = arr1.length - 1, n2 = arr2.length - 1;
        while (n1 >= 0 || n2 >= 0 || carry > 0) {
            int dig = carry;
            if (n1 >= 0) dig += arr1[n1] - '0';
            if (n2 >= 0) dig += arr2[n2] - '0';
            if (dig >= 2) {
                dig -= 2;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(dig);
            n1--;
            n2--;
        }
        return sb.reverse().toString();
    }
}