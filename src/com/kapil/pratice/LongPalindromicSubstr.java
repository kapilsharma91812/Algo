package com.kapil.pratice;

/**
 * Created by kapilsharma on 06/09/17.
 */
public class LongPalindromicSubstr {
    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        //String str = "AA";
        int maxLen = 1;
        int dist = 2;
        int start = 0;
        boolean mat[][] = new boolean[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            mat[i][i] = true;
        }

        while(dist <= str.length()) {
            int j = dist-1;
            for(int i = 0; i <= str.length() - dist; i++) {
                    System.out.println("i:" +i + " j:" +j);
                    if(str.charAt(i) == str.charAt(j) && (mat[i+1][j-1] == true || dist < 3)) {
                        mat[i][j] = true;
                        if(maxLen < dist) {
                            start = i;
                            maxLen = dist;
                        }
                    }
                    j++;
            }
            dist++;
            System.out.println("###########################");
        }
        System.out.println(str.substring(start, start+maxLen));
        System.out.println("Max Len:" + maxLen );

    }
}
