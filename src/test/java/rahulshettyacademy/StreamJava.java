package rahulshettyacademy;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJava {

    @Test
    public void streamFilter() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Ali");
        names.add("Adam");
        names.add("Elif");

        Long a = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(a);

        long d = Stream.of("ALi", "Ada", "Eda", "Dali").filter(s -> {
            s.startsWith("A");
            return true;
        }).count();
        System.out.println(d);

        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));


    }

    @Test
    public void streamMap() {
        Stream.of("ALi", "Ada", "Eda", "Dali").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        Stream<String> names1 = Stream.of("Li", "da", "Ed");

        List<String> names = Arrays.asList("ALi", "Ada", "Eda", "Dali");
        names.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));


        Stream<String> newStream = Stream.concat(names.stream(), names1);
        newStream.forEach(s -> System.out.println(s));

        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("ali"));
        System.out.println(flag);
        Assert.assertTrue(flag);
    }

    @Test
    public void streamCollect() {
        List<String> ls = Stream.of("ALi", "Ada", "Eda", "Dali").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(ls.get(0));

        List<Integer> values = Arrays.asList(3, 2, 2, 7, 6, 6);
        values.stream().distinct().forEach(s -> System.out.println(s));
    }
}
