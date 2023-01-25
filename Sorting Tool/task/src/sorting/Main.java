package sorting;

import java.io.*;
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

    private static void printMessage(FileWriter writer, String msg) {
        if (writer != null) {
            try {
                writer.append(msg);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.print(msg);
        }
    }

    public static void main(final String[] args) {
        String dataType = "long";
        String sortingType = "natural";
        String inputFilePath = "";
        String outputFilePath = "";

        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-dataType")) {
                    if (args.length > i + 1 && !args[i + 1].startsWith("-")) {
                        dataType = args[i + 1];
                    } else {
                        System.out.println("No data type defined!");
                    }
                }

                if (args[i].equals("-sortingType")) {
                    if (args.length > i + 1 && !args[i + 1].startsWith("-")) {
                        sortingType = args[i + 1];
                    } else {
                        System.out.println("No sorting type defined!");
                    }
                }

                if (args[i].equals("-inputFile")) {
                    if (args.length > i + 1 && !args[i + 1].startsWith("-")) {
                        inputFilePath = args[i + 1];
                    } else {
                        System.out.println("No input file defined!");
                    }
                }

                if (args[i].equals("-outputFile")) {
                    if (args.length > i + 1 && !args[i + 1].startsWith("-")) {
                        outputFilePath = args[i + 1];
                    } else {
                        System.out.println("No output file defined!");
                    }
                }
            }
        }

        File inputFile;
        File outputFile;
        Scanner scanner;
        FileWriter writer = null;

        if (!inputFilePath.isEmpty()) {
            inputFile = new File(inputFilePath);
            try {
                scanner = new Scanner(inputFile);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            scanner = new Scanner(System.in);
        }

        if (!outputFilePath.isEmpty()) {
            outputFile = new File(outputFilePath);
            try {
                writer = new FileWriter(outputFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        switch (dataType) {
            case "long" -> {
                List<Long> nums = new ArrayList<>();
                while (scanner.hasNextLong()) {
                    nums.add(scanner.nextLong());
                }
                printMessage(writer, "Total numbers: " + nums.size() + ".\n");
                //System.out.println("Total numbers: " + nums.size() + ".");
                Collections.sort(nums);

                if (sortingType.equals("natural")) {
                    printMessage(writer, "Sorted data:");
                    //System.out.print("Sorted data:");
                    for (Long num : nums)
                        printMessage(writer, " " + num);
                        //System.out.printf(" %d", num);

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

                        printMessage(writer, temp + ": " + occurs + " time(s), " + freq + "%\n");
                        //System.out.println(temp + ": " + occurs + " time(s), " + freq + "%");
                    }
                }
            }
            case "line" -> {
                List<String> lines = new ArrayList<>();
                while (scanner.hasNextLine()) {
                    lines.add(scanner.nextLine());
                }
                printMessage(writer, "Total lines: " + lines.size() + ".\n");
                //System.out.println("Total lines: " + lines.size() + ".");
                Collections.sort(lines);

                if (sortingType.equals("natural")) {
                    printMessage(writer, "Sorted data:");
                    //System.out.print("Sorted data:");
                    for (String line : lines)
                        printMessage(writer, " " + line);
                        //System.out.printf(" %s", line);

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

                        printMessage(writer, temp + ": " + occurs + " time(s), " + freq + "%\n");
                        //System.out.println(temp + ": " + occurs + " time(s), " + freq + "%");
                    }
                }
            }
            case "word" -> {
                List<String> words = new ArrayList<>();
                while (scanner.hasNext()) {
                    words.add(scanner.next());
                }
                printMessage(writer, "Total words: " + words.size() + ".\n");
                //System.out.println("Total words: " + words.size() + ".");
                Collections.sort(words);

                if (sortingType.equals("natural")) {
                    printMessage(writer, "Sorted data:");
                    //System.out.print("Sorted data:");
                    for (String word : words) {
                        printMessage(writer, " " + word);
                        //System.out.printf(" %s", word);
                    }


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

                        printMessage(writer, temp + ": " + occurs + " time(s), " + freq + "%\n");
                        //System.out.println(temp + ": " + occurs + " time(s), " + freq + "%");
                    }
                }
            }
        }

        scanner.close();
    }
}
