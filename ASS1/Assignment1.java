import java.util.*;
public class Assignment1{
    //check leap year
    public boolean checkLeapYear(int year){
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    //check alphabet
    public boolean isAlphabet(char ch){
        return(ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'); 
    }

    //factorial
    public int factorial(int n){
        if(n < 0) return -1;
        if(n == 0) return 1;
        return n * factorial(n-1);
    }

    //fibonacci series
    public List<Integer> fibonacciSeries(int n){
        if(n < 0) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if(n == 0) {
            ans.add(0);
            return ans;
        }
        
        int a = 0;
        int b = 1;
        ans.add(a);
        ans.add(b);

        
        for(int i = 2; i <= n; i++){
            int c = a + b;
            ans.add(c);
            a = b;
            b = c;
        }
        return ans;
    }
    //gcd
    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    //lcm
    public int lcm(int a, int b){
        if(a == 0 || b == 0) return 0;
        int denom = gcd(a,b);
        return (a * b)/denom;
    }

    //count digits
    public int countDigits(int n){
        if(n == 0) return 1;
        n = Math.abs(n);

        int count = 0;
        while(n > 0){
            count++;
            n = n /10;
        }
        return count;
    }

    //reverse a number
    public int reverseNumber(int n){
        boolean neg = n < 0;
        n = Math.abs(n);

        int rev = 0;
        while(n > 0){
            int m = n % 10;
            rev = (rev * 10) + m;
            n = n / 10;
        }
        return neg? -rev : rev;
    }

    //calculate power
    public double calcPow(int base, int exp){
        if(exp == 0) return 1;
        
        double sol = 1;
        if(exp > 0){
            for(int i = 0; i < exp; i++) sol *= base;
        }
        else{
            for(int i = 0; i < -exp; i++) sol *= base;
            sol = 1.0/sol;
        }
        return sol;
    }

    //check palindrone
    public boolean isPalindrome(int n){
        if(n < 0) return false;
        
        int rev = reverseNumber(n);
        return n == rev;
    }


    public static void main(String[] args) {
        Assignment1 assignment = new Assignment1();
        System.out.println(assignment.checkLeapYear(1600));

        System.out.println(assignment.isAlphabet('f'));

        System.out.println(assignment.factorial(5));

        System.out.println(assignment.fibonacciSeries(10));

        System.out.println(assignment.gcd(5,10));

        System.out.println(assignment.lcm(3,100));

        System.out.println(assignment.countDigits(100));

        System.out.println(assignment.reverseNumber(377));

        System.out.println(assignment.isPalindrome(101));

        System.out.println(assignment.calcPow(2,5));
    }
}