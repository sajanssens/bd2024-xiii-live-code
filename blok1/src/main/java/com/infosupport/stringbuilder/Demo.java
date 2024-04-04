package com.infosupport.stringbuilder;

public class Demo {
    public static void main(String[] args) {
        String initialText = 10 + 2 + "ABC" + 4 + 5;

        StringBuilder s = new StringBuilder(initialText);
        StringBuilder deleted = s.delete(3, 6);
        s.append(deleted);

        // 12A512A5
        System.out.println(s);
    }
}
