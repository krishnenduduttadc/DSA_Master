package StringsL1;

public class StringCompression {
    public static String compression1(String str){
        // write your code here
        String s=str.charAt(0)+"";
        for(int i=1;i<str.length();i++){
            char curr=str.charAt(i);
            char prev=str.charAt(i-1);
            if(curr!=prev){
                s=s+curr;
            }
        }

        return s;
    }

    public static String compression2(String str){
        // write your code here
        String s=str.charAt(0)+"";
        int count=1;
        for(int i=1;i<str.length();i++){
            char curr=str.charAt(i);
            char prev=str.charAt(i-1);

            if(curr==prev){
                count++;
            }else{
                if(count>1){
                    s=s+count;
                    count=1;
                }
                s=s+curr;
            }
        }

        if(count>1){
            s+=count;
            count=1;
        }

        return s;
    }
    public static void main(String[] args) {
        String str = "wwwwaaadexxxxxx";
        System.out.println(compression1(str));
        System.out.println(compression2(str));
    }
}


