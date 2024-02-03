package java8features;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class StreamAPI {
    public static void main(String[] args) {
        //all match
        List<String> words= Arrays.asList("apple","banana","cherry","apple");
       /* boolean check=words.stream().allMatch(StreamAPI::checkTheWord);
        System.out.println(check);*/
        //anymatch
        boolean check=words.stream().anyMatch(StreamAPI::checkTheWord);
        System.out.println(check);
        //Collect method
        List<String> fruits=words.stream().collect(Collectors.toList());
        //It will return the value as a list
        System.out.println(fruits);
        //Collect method for set
        String[] colorsArray={"Red","Red","Blue","Red","Yellow"};
        Set<String> set=Arrays.stream(colorsArray).collect(Collectors.toSet());
        System.out.println(set);
        //Collect as a Map
     /*  // Map<Integer,String> map=words.stream().collect(Collectors.toMap(String::length,word->word));
        System.out.println(map);*/
        //Joining a string
        String joinedString=words.stream().collect(Collectors.joining(","));
        System.out.println(joinedString);
        //count
        long count=words.stream().count();
        System.out.println(count);
        List<String> distinctWords=words.stream()
                .distinct().collect(Collectors.toList());
        System.out.println(distinctWords);
        System.out.println(words.stream().noneMatch(StreamAPI::checkTheWord));
       System.out.println( words.stream()
                       .filter(StreamAPI::checkTheWord)
               .findAny());
       List<List<Integer>> flatMap=Arrays.asList(
               Arrays.asList(1, 2, 3),
               Arrays.asList(4, 5, 6),
               Arrays.asList(7, 8, 9)

       );
       List<Integer> ans= flatMap.stream().flatMap(List::stream)
               .collect(Collectors.toList());
       System.out.println(ans);
        List<String> words2= Arrays.asList("hello", "world", "java");
        List<Character> flatternChar=words2.stream()
                .flatMap(word->word.chars().mapToObj(c->(char)c))
                .collect(Collectors.toList());
        System.out.println(flatternChar);
        String value="abababcc";
        System.out.println(value.chars()
                .mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
        //DoubleStream
        List<Integer> num2=Arrays.asList(1,2,3,4,5);
        DoubleStream resultDobleStream=num2.stream()
                .flatMapToDouble(val->DoubleStream.of(val));
        resultDobleStream.forEachOrdered(x->System.out.print(x+","));


    }
    public static boolean checkTheWord(String word){
       return word.startsWith("b");
    }
}
