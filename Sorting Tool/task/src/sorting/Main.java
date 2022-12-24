package sorting;

import java.util.*;

public class Main {

    //Method for sorting the TreeMap based on values
    public static <K, V extends Comparable<V>> Map<K, V>
    sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator =
                (k1, k2) -> {
                    int compare =
                            map.get(k1).compareTo(map.get(k2));
                    if (compare == 0)
                        return 1;
                    else
                        return compare;
                };

        Map<K, V> sortedByValues =
                new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    public static void main(final String[] args) {
        String dataType = "long";
        String sortingType = "natural";

        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-dataType"))
                    dataType = args[i + 1];
                if (args[i].equals("-sortingType")) {
                    sortingType = args[i + 1];
                }
            }
        }

        Scanner scanner = new Scanner(System.in);

        switch (dataType) {
            case "long" -> {
                List<Long> nums = new ArrayList<>();
                while (scanner.hasNextLong()) {
                    nums.add(scanner.nextLong());
                }
                System.out.println("Total numbers: " + nums.size() + ".");
                Collections.sort(nums);

                if (sortingType.equals("natural")) {
                    System.out.print("Sorted data:");
                    for (Long num : nums)
                        System.out.printf(" %d", num);

                } else {
                    TreeMap<Integer, Long> frequencies = new TreeMap<>();

                    int i = 0;
                    for (long temp : nums.stream().distinct().toList()) {
                        long freq = Math.round(((double) nums.stream().filter(n -> n == temp).count() / nums.size()) * 100);
                        frequencies.put(i, freq);
                        i++;
                    }

                    Map<Integer, Long> sortedMap = sortByValues(frequencies);
                    Set<Map.Entry<Integer, Long>> set = sortedMap.entrySet();

                    for (Map.Entry<Integer, Long> integerLongEntry : set) {
                        List<Long> dist = nums.stream().distinct().toList();
                        long temp = dist.get(integerLongEntry.getKey());
                        long freq = integerLongEntry.getValue();
                        long occurs = nums.stream().filter(n -> n == temp).count();

                        System.out.println(temp + ": " + occurs + " time(s), " + freq + "%");
                    }
                }
            }
            case "line" -> {
                List<String> lines = new ArrayList<>();
                while (scanner.hasNextLine()) {
                    lines.add(scanner.nextLine());
                }
                System.out.println("Total lines: " + lines.size() + ".");
                Collections.sort(lines);

                if (sortingType.equals("natural")) {
                    System.out.print("Sorted data:");
                    for (String line : lines)
                        System.out.printf(" %s", line);

                } else {
                    TreeMap<Integer, Long> frequencies = new TreeMap<>();

                    int i = 0;
                    for (String temp : lines.stream().distinct().toList()) {
                        long freq = Math.round(((double) lines.stream().filter(n -> Objects.equals(n, temp)).count() / lines.size()) * 100);
                        frequencies.put(i, freq);
                        i++;
                    }

                    Map<Integer, Long> sortedMap = sortByValues(frequencies);
                    Set<Map.Entry<Integer, Long>> set = sortedMap.entrySet();

                    for (Map.Entry<Integer, Long> integerLongEntry : set) {
                        List<String> dist = lines.stream().distinct().toList();
                        String temp = dist.get(integerLongEntry.getKey());
                        long freq = integerLongEntry.getValue();
                        long occurs = lines.stream().filter(n -> Objects.equals(n, temp)).count();

                        System.out.println(temp + ": " + occurs + " time(s), " + freq + "%");
                    }
                }
            }
            case "word" -> {
                List<String> words = new ArrayList<>();
                while (scanner.hasNext()) {
                    words.add(scanner.next());
                }
                System.out.println("Total words: " + words.size() + ".");
                Collections.sort(words);

                if (sortingType.equals("natural")) {
                    System.out.print("Sorted data:");
                    for (String word : words)
                        System.out.printf(" %s", word);

                } else {
                    TreeMap<Integer, Long> frequencies = new TreeMap<>();

                    int i = 0;
                    for (String temp : words.stream().distinct().toList()) {
                        long freq = Math.round(((double) words.stream().filter(n -> Objects.equals(n, temp)).count() / words.size()) * 100);
                        frequencies.put(i, freq);
                        i++;
                    }

                    Map<Integer, Long> sortedMap = sortByValues(frequencies);
                    Set<Map.Entry<Integer, Long>> set = sortedMap.entrySet();

                    for (Map.Entry<Integer, Long> integerLongEntry : set) {
                        List<String> dist = words.stream().distinct().toList();
                        String temp = dist.get(integerLongEntry.getKey());
                        long freq = integerLongEntry.getValue();
                        long occurs = words.stream().filter(n -> Objects.equals(n, temp)).count();

                        System.out.println(temp + ": " + occurs + " time(s), " + freq + "%");
                    }
                }
            }
        }
    }
}
