package ru.sber.streams;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        Random random = new Random();

        // первое задание
        Double average = Stream.generate(random::nextInt).limit(10).filter(value -> value >= 10 && value <= 99).collect(Collectors.averagingInt(value -> value));

        // второе задание
        Stream.Builder<String> builder = Stream.builder();
        Stream<String> words = builder.add("yay").add("aya").add(";-;").add("why").add("idk").add("xd").build();
        Stream<StreamContainer> streamContainers = words
                .map(word -> new StreamContainer(word, random.nextInt()))
                .peek(System.out::println);
        Map<Integer, String> map = streamContainers
                .collect(Collectors.toMap(container -> container.count, container -> container.name));

        // третье задание
        Map<String, List<StreamContainer>> containers = Map.of(
                "bla", List.of(
                        new StreamContainer("yay", random.nextInt()),
                        new StreamContainer("aya", random.nextInt()),
                        new StreamContainer(";-;", random.nextInt())
                ),
                "bla-bla", List.of(
                        new StreamContainer("why", random.nextInt()),
                        new StreamContainer("idk", random.nextInt()),
                        new StreamContainer("xd", random.nextInt())
                )
        );
        Stream<StreamContainer> streamWithContainers = containers
                .values()
                .stream()
                .flatMap(List::stream);
        List<StreamContainer> listOfContainers = streamWithContainers.toList();
        long count = listOfContainers.stream().count();

        // четвертое задание
        String binaryString = Stream.generate(() -> random.nextInt(0, 1)).limit(10).toString();
        Stream<Boolean> booleans = binaryString.chars().mapToObj(ch -> ch == '1');
        boolean result = booleans.reduce(true, (identity, value) -> identity && value);
    }
}
