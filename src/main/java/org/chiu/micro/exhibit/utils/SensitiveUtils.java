package org.chiu.micro.exhibit.utils;

import java.util.Comparator;
import java.util.List;

public class SensitiveUtils {
  
    private SensitiveUtils() {}

    public static String deal(List<String> sensitiveWords, String rawContent) {
        List<String> words = sensitiveWords.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toList();

        for (String str : words) {
            rawContent = rawContent.replaceAll(str, getStar(str));
        }
        return rawContent;
    }

    private static String getStar(String item) {
        return "[" +
                "+".repeat(item.length()) +
                "]";
    }
}
