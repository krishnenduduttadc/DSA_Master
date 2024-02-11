package java_coding_interview.logicalQuestions;

public class Garland {
    public static void main(String[] args) {
        String s = "aaabbac";
        String t = "aabbccac";
        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq1[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            freq2[t.charAt(i) - 'a']++;
        }
        int flag = 1;
        long area = 0;
        for (int i = 0; i < 26; i++) {
            if (freq1[i] == 0 && freq2[i] > 0) {
                flag = 0;
                break;
            }
            if(freq1[i]==freq2[i]){
                area+=freq1[i];
            }else if(freq1[i]<freq2[i]){
                area+=freq1[i];
            }else{
                area+=freq2[i];
            }
        }
        System.out.println((flag==1)?area:-1);
    }
}
