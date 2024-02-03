package java8features;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        //all match
        List<String> words= Arrays.asList("apple","banana","cherry");
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
    }
    public static boolean checkTheWord(String word){
       return word.startsWith("a");
    }
}
