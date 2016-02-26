import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// design a data structure which can insert,update,delete and getRandom in O(1)

class Day2 {

  /*
    Input : this is special 
    Output : siht si laiceps
    step1: get tokens based on space
    step2: reverse each token
    
  */
  public static String reverse(String original) {
    StringBuilder reverse = new StringBuilder();
    for(int i=0; i<original.length(); i++) {
      reverse.insert(0, original.charAt(i));
    }
    return reverse.toString();
  }
  
  public static String specialReverse(String str) {
    if(str == null) {
      return "";
    }
    StringTokenizer tokens = new StringTokenizer(str, " ");
    StringBuilder reverse = new StringBuilder();
    while(tokens.hasMoreElements()) {
      reverse.append(reverse(tokens.nextElement().toString()));
      reverse.append(" ");
    }
    return reverse.toString();
  }
  /*
  n=0
  n=1
  n>1
  */
  public static boolean isPrime(int number) {
    for(int i=2; i <= (number/2); i++){
      if(number % i == 0)
        return false;
    }
    return true;
  }
  
  
  // Link : https://en.wikipedia.org/wiki/Sieve_of_Eratosthenesa
  public static void printPrimes(int n) {
   if(n > 0){
      System.out.print("1, ");
    }
    for(int i=2; i<n; i++) {
      if(isPrime(i))
        System.out.print(i+", ");
    }
    System.out.println();
  }
  
  
  
  public static void main(String[] args) {
    /*ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
      
      System.out.println(reverse("Hello, World!"));
    }*/
    
    /*System.out.println(equals("",""));
    System.out.println(equals("a a a","a   a a"));
    System.out.println(equals("Prasad","dasarP"));
    System.out.println(equals("Prasad",null));
    System.out.println(equals(null,null));
    System.out.println(equals("Prasad","Prasad"));
    System.out.println(equals("","a"));*/
    
    /*System.out.println(specialReverse("Hello World"));
    System.out.println(specialReverse("Hello"));
    System.out.println(specialReverse(""));
    System.out.println(specialReverse(null));*/
    
    printPrimes(0);
    printPrimes(1);
    printPrimes(10);
  }
}


