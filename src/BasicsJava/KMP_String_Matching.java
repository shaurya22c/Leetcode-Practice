package BasicsJava;

   public class KMP_String_Matching {
        int KMPSearch(String pat, String txt)
        {
            int M = pat.length();
            int N = txt.length();
            int count= 0;
            int lps[] = new int[M];
            int j = 0;
            computeLPSArray(pat, M, lps);

            int i = 0;
            while (i < N) {
                if (pat.charAt(j) == txt.charAt(i)) {
                    j++;
                    i++;
                }
                if (j == M) {
                    count +=1;
                    j = lps[j - 1];
                }
                else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                    if (j != 0)
                        j = lps[j - 1];
                    else
                        i = i + 1;
                }
            }
            return count;
        }

        void computeLPSArray(String pat, int M, int lps[])
        {
            int len = 0;
            int i = 1;
            lps[0] = 0; // lps[0] is always 0
            while (i < M) {
                if (pat.charAt(i) == pat.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                }
                else
                {
                    if (len != 0) {
                        len = lps[len - 1];
                    }
                    else
                    {
                        lps[i] = len;
                        i++;
                    }
                }
            }
        }

        public static void main(String args[])
        {
            String txt = "bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32";
            String pat = "b";
            String[] words = txt.split("\\|");
            StringBuilder result= new StringBuilder();
            int globalCount = 0;


            for(String word: words){ System.out.println(word);
                if(pat.equals("")){
                    result.append(0 + "|");
                    continue;
                }
                else {
                    int tempRes = new KMP_String_Matching().KMPSearch(pat, word);
                    globalCount+= tempRes;
                    result.append(tempRes + "|");
                }
            }
            result.append(globalCount);
            System.out.println(result);
        }
    }



