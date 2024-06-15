package org.chiu.micro.exhibit.convertor;

import org.chiu.micro.exhibit.dto.BlogDescriptionDto;
import org.chiu.micro.exhibit.dto.BlogEntityDto;
import org.chiu.micro.exhibit.page.PageAdapter;
import org.springframework.data.domain.Page;

/**
 * @Author limingjiu
 * @Date 2024/5/10 11:16
 **/
public class BlogDescriptionDtoConvertor {

    private BlogDescriptionDtoConvertor() {}

    public static PageAdapter<BlogDescriptionDto> convert(Page<BlogEntityDto> page) {
        return new PageAdapter<>(page.map(blogEntity -> BlogDescriptionDto.builder()
                .id(blogEntity.getId())
                .description(blogEntity.getDescription())
                .title(blogEntity.getTitle())
                .created(blogEntity.getCreated())
                .link(blogEntity.getLink())
                .build()));
    }

}
