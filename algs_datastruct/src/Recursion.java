public class Recursion {

    static final long N = 15;

    public static void main(String[] args) {
        System.out.println("Rekursiv:");
        System.out.println(recF(N));
        System.out.println("Iterativ:");
        System.out.println(algF(N));
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
}
