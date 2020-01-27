import java.util.ArrayList;
import java.util.List;

public class FactorialandPrimeFactors {
    public List<Integer> PrimeFactors(int n) {
        boolean[] isPrime = SieveofEratosthenes(n);
        List<Integer> ans = new ArrayList<>();
        for(int i = 2 ; i <= n ; i++){
            int sum = 0;
            if(isPrime[i]){
                int fac = i;
                while(n / fac > 0){
                    sum += n/fac;
                    fac *= i;
                }
                ans.add(sum);
            }
        }
        return ans;
    }

    public boolean[] SieveofEratosthenes(int n){
        boolean[] isPrime = new boolean[n + 1]; // True is Prime; False is not prime
        for(int i = 0 ; i <= n ; i++)
            isPrime[i] = true;

        for(int i = 2 ; i * i <= n ; i++) {
            if(isPrime[i]){
                for(int p = i * i; p <= n ; p +=i ){
                    isPrime[p] = false;
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        FactorialandPrimeFactors test = new FactorialandPrimeFactors();
        System.out.println(test.PrimeFactors(100));
        System.out.println(test.PrimeFactors(42));
    }
}
/* A factorial number's prime factors can be calculated by the below formula:
   For instance, if we want to calculate the prime factors of n!,
        The number of 'p' = n/p + n/p^2 + n/p^3 ....., which p is all the prime factors

   5! = 2^3 * 3 * 5
   The number of '2' is:
        5/2 + 5/4 = 2 + 1 = 3;
   The number of '3' is:
        5/3 = 1
   The number of '5' is:
        5/5 = 1

   10!:
   The number of '2' is:
        10/2 + 10/4 + 10/8 = 5 + 2 + 1 = 8
   The number of '3' is:
        10/3 + 10/9 = 3 + 1 = 4
   The number of '5' is:
        10/5 = 2
   10! = 2^8 + 3^4 + 5^2
 */
