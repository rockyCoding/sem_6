import java.util.ArrayList;

public class Recursion {

    static final long N = 15;
    static final long A = 1024;
    static final long B = 612;
    static final int F = 12;
    static final double M = 7;
    static final double K = 3;


    public static void main(String[] args) {
        System.out.println("Rekursiv:");
        System.out.println(recF(N));
        System.out.println("Iterativ:");
        System.out.println(algF(N));
        System.out.println("\nGGT rekursiv:");
        System.out.println(recGGT(A, B));
        System.out.println("GGT iterativ:");
        System.out.println(algGGT(A, B));
        System.out.println("\nFib rekursiv:");
        System.out.println(recFib(F));
        System.out.println("Fib iterativ:");
        System.out.println(itFib(F));
        System.out.println("\nBinom rekursiv:");
        System.out.println(recBinom(M, K));
    }

    public static long recF(long n){
        if (n < 0){return -1;}
        else if (n == 1){return 1;}
        else{ return n*recF(n-1);}
    }

    public static long algF(long n){
        if (n < 0){return -1;}
        else if (n == 1){return 1;}
        else{
            long result = 1;
            for (long i=n; i>=1; i--){
                result = result * n;
                n--;
            }
            return result;
        }
    }

    public static long recGGT(long a, long b){
        if (a == b){return a;}
        else if (a > b){return recGGT(a-b, b);}
        else {return recGGT(a, b-a);}
    }

    public static long algGGT(long a, long b){
        if (a == b){return a;}
        else {
            while (!(a==b)){
                if (a > b){
                    a = a-b;
                }
                else{
                    b = b-a;
                }
            }
            return a;
        }
    }

    public static int recFib(int n){
        if (n == 0){return 1;}
        else if (n == 1){return 1;}
        else {
            return recFib(n-1)+recFib(n-2);
        }
    }

    public static int itFib(int n){
        if (n == 0){return 1;}
        else if (n == 1){return 1;}
        else {
            int a = 1;
            int b = 1;
            int z;
            for (int i= 0; i<(n-1); i++){
                z = b;
                b += a;
                a = z;
            }
            return b;
        }
    }

    public static double recBinom(double n, double k){
        if (k == 0){return 1;}
        else if (k == n){return 1;}
        else {
            return (recBinom(n-1, k-1)+recBinom(n-1, k));
        }
    }
}
