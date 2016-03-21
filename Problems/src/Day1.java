import java.io.*;
import java.util.*;

//design a data structure which can insert,update,delete and getRandom in O(1)
/*arrayindx->elemtn->hashemle->arrayinde
array 4,15,6,45
hash  4:0,15:1,6:2, 45:3*/
class Magic {
  
  // Insert : 4,15,6,45,2,0,349
  
  // all operation should happen in O(1) time
  int []array;
  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
  int index = 0;
  /*
  1. swap elements in array
  2. update location of number in map
  3. update location of a number swaped 
  4. decrement count
  */
  public void delete(int number){ 
    if(map.containsKey(number)) {
      int location = map.get(number);
      int temp = array[location];
      array[location] = array[index];
      array[index] = temp;
      map.remove(number);
      map.remove(array[location]);
      map.put(array[location], location);
      index--;
    }
  }

  public void insert(int a) {
    array[index] = a;
    map.put(a, index);
    index++;
  }
  
  public void update(int oldNumber,int newNumber) {//hashmap
    if(map.containsKey(oldNumber)) {
      map.put(newNumber, map.get(oldNumber));
      map.remove(oldNumber);
      array[map.get(newNumber)] = newNumber;
    }
  }
  
  public int getRandom() {//array
    int random = (int)Math.random()%index;
    return array[random];
  }
}

class Solution {
  
  /*
    Test Cases/Test Input/ Scenarios :
    ""
    "a"
    null
  */
  public static String reverse(String str) {
    /*if(str == null)
      throw new NullPointerException();*/
    StringBuilder rev = new StringBuilder();
    for(int i=0; i<str.length(); i++) {
      rev.insert(0, str.charAt(i));
    }
    return rev.toString();
  }
  
  /*
  Dormitory = Dirty Room
    types : null,a,aa,"", a aa,
  
    test cases:
    "" ,""
    "a", "a"
    "a d", "da"
    
    "", a
    "ds", "d d"
    null, "d"
  */
  public static boolean isAnagram(String first,String second) {
    if(first == null || second == null) {
      return false;
    }
    char[] firstString = first.replaceAll("[\\s]","").toCharArray();
    char[] secondString = second.replaceAll("[\\s]","").toCharArray();
    Arrays.sort(firstString);
    Arrays.sort(secondString);
    return Arrays.equals(firstString, secondString);     
  }
  
  /*
  Test cases:
  "", ""
  "a", "a"
  "aa", "aa"
  
  Assumption :  null, null
  
  "", null
  "", "a"
  
  */
  
  public static boolean equals(String first,String second) {
    if(first == null && second == null)
      return true;
    if(first == null || second == null || first.length()!=second.length())
      return false;
    for(int i=0; i<first.length(); i++) {
      if(first.charAt(i) != second.charAt(i))
        return false;
    }
    return true;
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
    
    System.out.println(equals("",""));
    System.out.println(equals("a a a","a   a a"));
    System.out.println(equals("Prasad","dasarP"));
    System.out.println(equals("Prasad",null));
    System.out.println(equals(null,null));
    System.out.println(equals("Prasad","Prasad"));
    System.out.println(equals("","a"));
  }
}


