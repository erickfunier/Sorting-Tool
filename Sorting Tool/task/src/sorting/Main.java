package sorting;

import java.util.*;

public class Main {
    public static void mergeSort(long[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        long[] l = new long[mid];
        long[] r = new long[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            long[] a, long[] l, long[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void main(final String[] args) {
        String dataType = "long";
        boolean sort = false;

        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-dataType"))
                    dataType = args[i + 1];
                if (args[i].equals("-sortIntegers")) {
                    sort = true;
                }
            }
        }

        Scanner scanner = new Scanner(System.in);

        switch (dataType) {
            case "long" -> {
                if (sort) {
                    ArrayList<Long> nums = new ArrayList<>();
                    while (scanner.hasNextLong()) {
                        nums.add(scanner.nextLong());
                    }
                    System.out.println("Total numbers: " + nums.size() + ".");

                    long[] numsLong = new long[nums.size()];
                    int index = 0;
                    for (Long num : nums)
                        numsLong[index++] = num;

                    mergeSort(numsLong, nums.size());

                    System.out.print("Sorted data:");
                    for (Long num : numsLong)
                        System.out.printf(" %d", num);

                } else {
                    long numCount = 0;
                    long greatest = Long.MIN_VALUE;
                    long occurs = 0;
                    while (scanner.hasNextLong()) {
                        long number = scanner.nextLong();

                        if (number > greatest) {
                            greatest = number;
                            occurs = 1;
                        } else if (number == greatest)
                            occurs++;

                        numCount++;
                    }
                    long percent = Math.round(((double) occurs / numCount) * 100);
                    System.out.println("Total numbers: " + numCount + ".");
                    System.out.println("The greatest number: " + greatest + " (" + occurs + " time(s), " + percent + "%).");
                }
            }
            case "line" -> {
                if (sort) {
                    ArrayList<Long> nums = new ArrayList<>();
                    while (scanner.hasNext()) {
                        nums.add(Long.valueOf(scanner.nextLine()));
                    }
                    System.out.println("Total numbers: " + nums.size() + ".");

                    long[] numsLong = new long[nums.size()];
                    int index = 0;
                    for (Long num : nums)
                        numsLong[index++] = num;

                    mergeSort(numsLong, nums.size());

                    System.out.print("Sorted data:");
                    for (Long num : numsLong)
                        System.out.printf(" %d", num);

                } else {
                    long lineCount = 0;
                    String longestLine = "";
                    long occurs = 0;
                    while (scanner.hasNext()) {
                        String line = scanner.nextLine();

                        if (line.length() > longestLine.length()) {
                            longestLine = line;
                            occurs = 1;
                        } else if (line.length() == longestLine.length())
                            occurs++;

                        lineCount++;
                    }
                    long percent = Math.round(((double) occurs / lineCount) * 100);
                    System.out.println("Total lines: " + lineCount + ".");
                    System.out.println("The longest line: \n" + longestLine + "\n (" + occurs + " time(s), " + percent + "%).");
                }
            }
            case "word" -> {
                if (sort) {
                    ArrayList<Long> nums = new ArrayList<>();
                    while (scanner.hasNext()) {
                        nums.add(Long.valueOf(scanner.next()));
                    }
                    System.out.println("Total numbers: " + nums.size() + ".");

                    long[] numsLong = new long[nums.size()];
                    int index = 0;
                    for (Long num : nums)
                        numsLong[index++] = num;

                    mergeSort(numsLong, nums.size());

                    System.out.print("Sorted data:");
                    for (Long num : numsLong)
                        System.out.printf(" %d", num);

                } else {
                    long wordCount = 0;
                    String longestWord = "";
                    long occurs = 0;
                    while (scanner.hasNext()) {
                        String word = scanner.next();

                        if (word.length() > longestWord.length()) {
                            longestWord = word;
                            occurs = 1;
                        } else if (word.length() == longestWord.length())
                            occurs++;

                        wordCount++;
                    }
                    long percent = Math.round(((double) occurs / wordCount) * 100);
                    System.out.println("Total words: " + wordCount + ".");
                    System.out.println("The longest word: " + longestWord + " (" + occurs + " time(s), " + percent + "%).");
                }
            }
        }

    }
}
