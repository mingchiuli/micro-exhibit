package org.chiu.micro.exhibit.utils;

import java.util.List;

import org.chiu.micro.exhibit.convertor.BlogExhibitDtoConvertor;
import org.chiu.micro.exhibit.dto.BlogDescriptionDto;
import org.chiu.micro.exhibit.dto.BlogExhibitDto;
import org.chiu.micro.exhibit.dto.SensitiveContent;
import org.chiu.micro.exhibit.lang.SensitiveTypeEnum;

public class SensitiveUtils {

    private SensitiveUtils() {
    }

    public static BlogExhibitDto deal(List<SensitiveContent> sensitiveWords, BlogExhibitDto blog) {
        List<SensitiveContent> titleSensitiveList = sensitiveWords.stream()
                .filter(item -> SensitiveTypeEnum.TITLE.getCode().equals(item.getType()))
                .toList();

        List<SensitiveContent> descSensitiveList = sensitiveWords.stream()
                .filter(item -> SensitiveTypeEnum.DESCRIPTION.getCode().equals(item.getType()))
                .toList();

        List<SensitiveContent> contentSensitiveList = sensitiveWords.stream()
                .filter(item -> SensitiveTypeEnum.CONTENT.getCode().equals(item.getType()))
                .toList();

        String title = blog.getTitle();
        String description = blog.getDescription();
        String content = blog.getContent();

        for (SensitiveContent item : titleSensitiveList) {
            Integer index = item.getStartIndex();
            String sensitiveContent = item.getContent();
            title = title.substring(0, index) +
                    getStar(sensitiveContent) +
                    title.substring(index + sensitiveContent.length());
        }

        for (SensitiveContent item : descSensitiveList) {
            Integer index = item.getStartIndex();
            String sensitiveContent = item.getContent();
            description = description.substring(0, index) +
                    getStar(sensitiveContent) +
                    description.substring(index + sensitiveContent.length());
        }

        for (SensitiveContent item : contentSensitiveList) {
            Integer index = item.getStartIndex();
            String sensitiveContent = item.getContent();
            content = content.substring(0, index) +
                    getStar(sensitiveContent) +
                    content.substring(index + sensitiveContent.length());
        }

        return BlogExhibitDtoConvertor.convert(blog, title, description, content);
    }

    public static BlogDescriptionDto deal(List<SensitiveContent> sensitiveWords, BlogDescriptionDto blog) {
        List<SensitiveContent> titleSensitiveList = sensitiveWords.stream()
                .filter(item -> SensitiveTypeEnum.TITLE.getCode().equals(item.getType()))
                .toList();

        List<SensitiveContent> descSensitiveList = sensitiveWords.stream()
                .filter(item -> SensitiveTypeEnum.DESCRIPTION.getCode().equals(item.getType()))
                .toList();

        String title = blog.getTitle();
        String description = blog.getDescription();

        for (SensitiveContent item : titleSensitiveList) {
            Integer index = item.getStartIndex();
            String sensitiveContent = item.getContent();
            title = title.substring(0, index) +
                    getStar(sensitiveContent) +
                    title.substring(index + sensitiveContent.length());
        }

        for (SensitiveContent item : descSensitiveList) {
            Integer index = item.getStartIndex();
            String sensitiveContent = item.getContent();
            description = description.substring(0, index) +
                    getStar(sensitiveContent) +
                    description.substring(index + sensitiveContent.length());
        }

        return BlogExhibitDtoConvertor.convert(blog, title, description);

    }

    private static String getStar(String item) {
        return "+".repeat(item.length());
    }
}
