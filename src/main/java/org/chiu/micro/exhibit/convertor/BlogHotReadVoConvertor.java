package org.chiu.micro.exhibit.convertor;

import org.chiu.micro.exhibit.vo.BlogHotReadVo;
import org.chiu.micro.exhibit.dto.BlogEntityDto;
import org.chiu.micro.exhibit.exception.MissException;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.chiu.micro.exhibit.lang.ExceptionMessage.NO_FOUND;
import static org.chiu.micro.exhibit.lang.StatusEnum.NORMAL;

public class BlogHotReadVoConvertor {

    private BlogHotReadVoConvertor() {}

    public static List<BlogHotReadVo> convert(List<BlogEntityDto> blogs, Set<ZSetOperations.TypedTuple<String>> set) {

        List<Long> ids = blogs.stream()
                .filter(item -> NORMAL.getCode().equals(item.getStatus()))
                .map(BlogEntityDto::getId)
                .toList();

        List<BlogHotReadVo> items = Optional.ofNullable(set).orElseGet(LinkedHashSet::new).stream()
                .filter(item -> ids.contains(Long.valueOf(item.getValue())))
                .map(item -> BlogHotReadVo.builder()
                        .id(Long.valueOf(item.getValue()))
                        .readCount(item.getScore().longValue())
                        .build())
                .toList();

        items.forEach(item -> {
            String title = blogs.stream()
                    .filter(blog -> blog.getId().equals(item.getId()))
                    .findAny()
                    .orElseThrow(() -> new MissException(NO_FOUND))
                    .getTitle();
            item.setTitle(title);
        });

        return items;
    }
}
