package org.chiu.micro.exhibit.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SensitiveUtils {
  
    private SensitiveUtils() {}

    public static String deal(String[] sensitiveWords, String rawContent) {
        List<String> words = Arrays.stream(sensitiveWords)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());

        for (String str : words) {
            rawContent = rawContent.replaceAll(str, getStar(str));
        }
        return rawContent;
    }

    private static String getStar(String item) {
        var sb = new StringBuilder();
        for (int i = 0; i < item.length(); i++) {
          sb.append("*");
        }
        return sb.toString();
    }
}
