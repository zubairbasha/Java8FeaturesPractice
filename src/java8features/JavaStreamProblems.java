package java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamProblems {
    public static void main(String args[]){
       /*
       * Exercise 1: Filtering and Summing Prime Numbers
Problem:
Write a Java program that takes a list of integers and filters out the prime numbers.
 After filtering, calculate and return the sum of the prime numbers.

Example:
Input: [2, 3, 5, 6, 7, 11, 13, 15]
Output: 41 (as 2 + 3 + 5 + 7 + 11 + 13 are prime)
       * */

      int[] primeNumber={2, 3, 5, 6, 7, 11, 13, 15};
        List<Integer> numbers = Arrays.asList(2, 3, 5, 6, 7, 11, 13, 15);
    int sumOfPrimeNumbers= Arrays.stream(primeNumber).filter(JavaStreamProblems::isPrime).sum();
    //System.out.println(sumOfPrimeNumbers);
    /*Exercise 2: Transforming and Concatenating Strings
Problem:
Given a list of strings, transform each string by adding
 a suffix "_processed" and concatenate them into a single comma-separated string.
 Return the final processed string.

Example:
Input: ["apple", "orange", "banana"]
Output: "apple_processed, orange_processed, banana_processed"
    * */
    List<String> list=Arrays.asList("apple", "orange", "banana");
   String concatinatedString=  list.stream().map(str->str+"_processed")
            .collect(Collectors.joining(","));
   System.out.println(concatinatedString);
   /*
   * Exercise 3: Filtering and Calculating Average Salary
Problem:
Create a program that takes a list of Employee objects,
*  filters out employees with a salary less than $50,000, and
*  calculates the average salary of the remaining employees.

Example:
Input: List of Employee objects with various salaries
Output: Average salary of employees with salary >= $50,000
   * */
    List<Employee> listEmp=Arrays.asList(
            new Employee(1,"Zubair",52000),
            new Employee(2,"Ashik",58000),
            new Employee(3,"Fareed",40000),
            new Employee(4,"Nihal",25000)
    );
System.out.println(    listEmp.stream().filter(e->e.salary<50000).mapToDouble(e->e.salary).average().orElse(0.0));
    /*
    * Exercise 4: Transforming and Sorting Strings
Problem:
Given a list of strings, transform each string by reversing it, and then sort the transformed strings in descending lexicographical order. Return the sorted list.

Example:
Input: ["hello", "world", "java", "stream"]
Output: ["tpmerts", "dlrow", "avaj", "olleh"]
    * */
    List<String> listStr=Arrays.asList("hello", "world", "java", "stream");
    List<String> ans=listStr.stream().map(JavaStreamProblems::reversedString)
            .sorted().collect(Collectors.toList());
    System.out.println(ans);
    System.out.println(listStr.stream().map(str->new StringBuilder(str).reverse().toString()).sorted().collect(Collectors.toList()));
    /*
    * Exercise 5: Filtering and Counting Distinct Words
Problem:
Write a program that takes a list of sentences,
*  filters out the words that start with a vowel,
* and counts the number of distinct words that remain.

Example:
Input: ["Hello world", "Java streams", "Filter and count"]
Output: Number of distinct words remaining after filtering
    * */
        List<String> wordsList=Arrays.asList("Hello world", "Java streams", "Filter and count","Apple is good");
        String vowels="aeiou";
      List<String> distinctWords=  wordsList.stream().filter(str->vowels.contains(String.valueOf(str.toLowerCase().charAt(0))))
                .distinct().collect(Collectors.toList());
      System.out.println(distinctWords);
      /*
      * Exercise 7: Filtering and Finding Maximum
Problem:
Create a program that takes a list of integers,
*  filters out the negative numbers, and finds the maximum of the remaining numbers.

Example:
Input: [5, -3, 8, -2, 10, -7]
Output: 10 (as it is the maximum of [5, 8, 10])*/

        List<Integer> listInt=Arrays.asList(5, -3, 8, -2, 10, -7);
         System.out.println(listInt.stream().filter(i->i>=0).max(Integer::compareTo)
                 .orElse(0));
         System.out.println(listInt.stream().filter(i->i>0)
                 .min(Integer::compareTo)
                 .orElse(0));
/*
* Exercise 9: Filtering, Capitalizing, and Length Check
Problem:
Write a program that takes a list of strings,
* filters out the words with a length less than 5,
* capitalizes the remaining words, and returns a new list.

Example:
Input: ["apple", "banana", "kiwi", "grape"]
Output: ["APPLE", "BANANA", "GRAPE"]
* */
        List<String> listStr2=Arrays.asList("apple", "banana", "kiwi", "grape");
        List<String> result = listStr2.stream()
                .filter(str -> str.length() >= 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(result);

    }
    public static String reversedString(String str){
        StringBuilder sb=new StringBuilder();
        int i=str.length()-1;
        while(i>=0){
            sb.append(str.charAt(i));
            i--;
        }
        return sb.toString();
    }
    public static boolean isPrime(int num){
        if(num<2){
            return false;
        }
        for(int i=2;i<Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

}
class Employee{
    int id;
    String name;
    float salary;
    public Employee(int id,String name,float salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }
}
