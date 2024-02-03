package java8features;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsAPI {
    public static void main(String[] args) {
        //toList
        List<String> list= Arrays.asList("apple","banana","custard apple");
        List<String> collectList=list.stream()
                .collect(Collectors.toList());
        System.out.println(collectList);

        //Convert to Map
        Map<Integer,String> map=list.stream()
                .collect(Collectors.toMap(
                        String::length
                        , Function.identity()

                ));
        System.out.println(map);
        //Basic Join
        String concatenateString=list.stream()
                .collect(Collectors.joining());
        System.out.println(concatenateString);
        //Join with delimeter
        concatenateString=list.stream()
                .collect(Collectors.joining(","));
        System.out.println(concatenateString);
        //Join with delimeter,prefix,suffix
        concatenateString=list.stream()
                .collect(Collectors.joining(",","{","}"));
        System.out.println(concatenateString);
        //counting the number of elements in the stream
        long count=list.stream()
                .collect(Collectors.counting());
        System.out.println(count);
        //grouping by
        Map<Integer,List<String>> group=list.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(group);
        //partition
        Map<Boolean,List<String>> partition=list.stream()
                .collect(Collectors.partitioningBy(s->s.length()<2));
        System.out.println(partition);
        IntSummaryStatistics stats=list.stream()
                .collect(Collectors.summarizingInt(String::length));
        System.out.println("Summarizing"+stats);
        //reducing
        Optional<String> reduce= list.stream()
                .collect(Collectors.reducing((s1,s2)->s1+"," +s2));
        System.out.println(reduce);
        //mapping
        List<String> upperCastList=list.stream()
                .collect(Collectors.mapping(String::toUpperCase,Collectors.toList()));
        System.out.println(upperCastList);
        //reducing (with identity and binaryOperator)
        int totalLenght=list.stream()
                .collect(Collectors.reducing(0,String::length,Integer::sum));
        System.out.println(totalLenght);
    }
}
