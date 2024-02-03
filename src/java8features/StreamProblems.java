package java8features;

import java.util.*;
import java.util.stream.Collectors;

public class StreamProblems {
    public static void main(String[] args) {
//Problem 1: Filtering and Counting
        List<Integer> numbers= Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
       long countOdd=numbers.stream()
                .filter(number->number%2!=0)
                .collect(Collectors.counting());
       System.out.println(countOdd);
       //Problem 2: Mapping and Summing
        List<String> numberStrings = Arrays.asList("1", "2", "3", "4", "5");
        int sum=numberStrings.stream()
                .map(s->Integer.parseInt(s))
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println(sum);
        //Problem 3: Filtering and Joining
        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie", "Alex");
        String concatinateString= names.stream()
                .filter(s->!s.startsWith("A"))
                .collect(Collectors.joining(","));
        System.out.println(concatinateString);
        //Problem 4: Grouping and Counting
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig");
        // Expected Output: Word Length Count: {5=2, 6=1, 7=2}
        Map<Integer,Long> map=words
                .stream().collect(Collectors.groupingBy(String::length,Collectors.counting()));
        System.out.println(map);
        //Problem 5: Reducing
        List<Integer> num = Arrays.asList(2, 3, 4, 5);
        Integer product = num.stream()
                .collect(Collectors.reducing(1, (s1, s2) -> s1 * s2));
        System.out.println(product);
        //Problem 6: Sorting and Limiting
        List<String> name = Arrays.asList("Charlie", "Alice", "Bob", "Anna", "David");
       List<String> sortedNames= name.stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
       System.out.println(sortedNames);

       String joiningWord= words.stream()
               .flatMapToInt(CharSequence::chars)
               .distinct()
               .mapToObj(c->String.valueOf((char) c))
               .collect(Collectors.joining(","));
       System.out.println(joiningWord);

    }

}
