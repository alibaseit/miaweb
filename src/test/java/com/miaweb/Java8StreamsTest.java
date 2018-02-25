package com.miaweb;

import org.assertj.core.util.Arrays;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by dogan on 5/23/17.
 */
public class Java8StreamsTest {

    @Test
    public void streamTest1() {
        Stream<String> streamOfStrings = Stream.of(Arrays.array("ali", "türkan", "ozan", "rubar"));
        streamOfStrings
                //.map(String::toUpperCase)
                .flatMap(n -> Stream.of(n))
                .forEach(System.out::println);
    }

    @Test
    public void testJava8Features1() {
        File[] hiddenFiles = new File(System.getProperty("user.dir"))
                .listFiles();
        java.util.Arrays.stream(hiddenFiles).forEach(System.out::println);
    }

    @Test
    public void testPredicate() {
        Predicate<Apple> greenPredicate = (Apple a) -> a.getColor().contains("green");
        Predicate<Apple> yellowPredicate = (Apple a) -> a.getColor().contains("yellow");
        Predicate<Apple> green_and_yellow = greenPredicate.and(yellowPredicate);
        Apple[] apples = Arrays.array(new Apple("green"), new Apple("lightgreen"), new Apple("yellowgreen"), new Apple("greenish"));
        printAppleThat(green_and_yellow, apples);
    }

    private void printAppleThat(Predicate<Apple> predicate, Apple[] apples) {
        Stream.of(apples)
                .filter(predicate)
                .map(Apple::getColor)
                .forEach(System.out::println);
    }


    @Test
    public void testOS() {
        String osName = System.getProperty("os.name");
        System.getProperties().forEach(
                (k, v) -> System.out.println(k + " : " + v)
        );
        System.out.println(String.format("os.name %s ", osName));
    }

//    @Test
//    public void testWriting2TextFile() throws IOException {
//        Path logFile = Paths.get(Optional.ofNullable(System.getenv("user.dir")).orElse(System.getProperty("user.dd", "/home/dogan")));
//        System.out.println(logFile.toString());
//        Path path = Paths.get(System.getProperty("user.dir") + "/ali.txt");
//        System.out.println("path is: " + path.toString());
//        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
//            bufferedWriter.append("\nthis should be third line in the text file");
//        }
//    }
}


class Apple {
    private final String color;

    public Apple(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}


@FunctionalInterface
interface MyFirstFunctionalInterface {
    public boolean test(String color);
}

