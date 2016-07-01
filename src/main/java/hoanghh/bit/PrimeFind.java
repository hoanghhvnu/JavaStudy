package hoanghh.bit;

public class PrimeFind {

    public static void useBit(final int upperLimit) {
        int n = upperLimit;
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            primes[i]=true;
        }

        for (int i = 2; i < n; i++) {
            if (primes[i] == true) {
                for (int j = i * i; j < n; j=j+i)
                {
                    try {
                        if (Math.pow(i, 2) < n) {
                            primes[j] = false;
                        } else {
                            break;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(j);
                        System.out.println(i);
                        System.out.println(Integer.MAX_VALUE);
                        System.out.println(46349 * 46349);
                        System.out.println(Math.pow(46349, 2));
                        e.printStackTrace();
                        System.exit(1);
                    }

                        
                    
                    
                }
                
            }
        }
//        for (int i = 0; i < primes.length; i ++) {
//            if (primes[i]) {
//                System.out.println(i);
//            }
//        }
    }
    
    public static void useCaculus(final int upperLimit) {
        for (int index = 2; index < upperLimit; index ++) {
            if (isPrime(index)) {
                //
            }
        }
    }
    public static boolean isPrime(long n) {
        if (n <= 3) {
            return n > 1;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        } else {
            double sqrtN = Math.floor(Math.sqrt(n));
            for (int i = 5; i <= sqrtN; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(System.currentTimeMillis());
        int upperLimit = 99999999;
        useCaculus(upperLimit);
//        useBit(upperLimit);
        System.out.println(System.currentTimeMillis());
        
    }

}
