class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int n1 = arr1.length - 1, n2 = arr2.length - 1;
        while (n1 >= 0 && n2 >= 0) {
            int dig = arr1[n1] - '0' + arr2[n2] - '0' + carry;
            if (dig >= 2) {
                dig -= 2;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.insert(0, dig);
            n1--;
            n2--;
        }
        while (n1 >= 0) {
            int dig = arr1[n1] - '0' + carry;
            if (dig >= 2) {
                dig -= 2;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.insert(0, dig);
            n1--;
        }
        while (n2 >= 0) {
            int dig = arr2[n2] - '0' + carry;
            if (dig >= 2) {
                dig -= 2;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.insert(0, dig);
            n2--;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}