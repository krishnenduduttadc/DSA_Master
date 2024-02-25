package Maths;

public class PythagorasTriplet {
    public static void main(String[] args) {

        int a = 3;
        int b = 4;
        int c = 5;


        if ( a > b && a > c){
            if(a * a  ==  b * b  +  c * c){
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }

        if ( b > c && b > a){
            if(b * b  ==  a * a  +  c * c){
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }

        if ( c > a && c > b){
            if(c * c  ==  b * b  +  a * a){
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }


    }
}
