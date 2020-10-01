package com.example.ir;

import java.util.Arrays;

public class Convertation {
    public static int[] convert(String str){
        String[] s = str.split(" ");
        int[] arr = new int[100];
        int i=0;
        for (String word:s) {
            arr[i] = Integer.parseInt(word);
            i++;
        }
        int array_copy[] = Arrays.copyOf(arr,i);
        return array_copy;
    }
}
