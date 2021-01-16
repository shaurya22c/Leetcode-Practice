package BasicsJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

// sample input: b;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32
//output: 4|2|3|2|11

public class patternRecognitionClass {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            String[] splittedInput = line.split(";");
            String pattern = splittedInput[0];
            String blobs = splittedInput[1];

            String[] words = blobs.split("\\|");
            StringBuilder result= new StringBuilder();
            int globalCount = 0;

            for(String word: words){
                if(pattern.equals("")){
                    result.append(0 + "|");
                }
                else {
                    int tempRes = doSomething(pattern, word);
                    globalCount+= tempRes;
                    result.append(tempRes + "|");
                }
            }
            result.append(globalCount);
            System.out.println(result);

        }
    }

    public static int doSomething(String pattern, String blobs) {
        int patternLength = pattern.length();
        int blobsLength = blobs.length();
        int count = 0;
        int[] lps = new int[patternLength];
        int j = 0;
        computeLPSArray(pattern, patternLength, lps);

        int i = 0;
        while (i < blobsLength) {
            if (pattern.charAt(j) == blobs.charAt(i)) {
                j++;
                i++;
            }
            if (j == patternLength) {
                count += 1;
                j = lps[j - 1];
            } else if (i < blobsLength && pattern.charAt(j) != blobs.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return count;
    }

    static void computeLPSArray(String pattern, int patternLength, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
// sample input: b;bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32
//output: 4|2|3|2|11