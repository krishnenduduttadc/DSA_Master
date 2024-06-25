package Concepts;

public class NoofFactors {
    public static void main(String[] args) {
        int n = 12;
        int count = 0;
        for(int i =1;i*i<=n;i++){
            if(n%i==0){
                if(i != n/i){count = count+2;}
                else{count++;}
            }
        }

        System.out.println(count);

    }
}
