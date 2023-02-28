/**
 * Author:	Bryson Davis
 * Class:   CS-2463-TW01S.23SP
 * Date:	02/09/23
 * File:	Fibonacci 
 * Description:	Fibonacci 
 */

import java.math.BigInteger;
import java.util.Vector;

public class Fibonacci {

  private static Vector<BigInteger> memo = new Vector<BigInteger>();

  public static BigInteger fibonacci(int n) {
    if (n == 0 || n == 1) {
      return BigInteger.valueOf(n);
    }
    if (memo.size() > n && memo.get(n) != null) {
      return memo.get(n);
    }
    BigInteger result = fibonacci(n - 1).add(fibonacci(n - 2));
    if (memo.size() <= n) {
      memo.setSize(n + 1);
    }
    memo.set(n, result);
    return result;
  }

  public static void main(String[] args) {
    int n = 250;
    System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
  }

}
