public class tester {
    
    public static int f(int[] xs) {
        int n = 0;
        for(int i = 0; i < xs.length; i++) {
            n *= xs[i];
        }
        return n;
    }
}
