package com.jizumer.huffmandecoder;

class Decoding {

    void decode(String s, Node root) {

        while (s != null && !s.isEmpty()) {
            s = processSubString(s, root);
        }

    }

    String processSubString(String s, Node root) {
        //System.out.println(String.format("processSubString(%s)", s));
        String remaining = s;
        if (root.left == null && root.right == null) {
            System.out.print(Character.toString(root.data));
        } else {

            char c = s.charAt(0);

            if (c == '0') {
                remaining = processSubString(s.substring(1), root.left);
            } else if (c == '1') {
                remaining = processSubString(s.substring(1), root.right);
            }
        }
        return remaining;
    }


}