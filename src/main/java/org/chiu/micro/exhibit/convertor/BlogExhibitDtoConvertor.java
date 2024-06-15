package org.chiu.micro.exhibit.convertor;

import org.chiu.micro.exhibit.dto.BlogEntityDto;
import org.chiu.micro.exhibit.dto.BlogExhibitDto;
import org.chiu.micro.exhibit.dto.UserEntityDto;

public class BlogExhibitDtoConvertor {

    private BlogExhibitDtoConvertor() {}

    public static BlogExhibitDto convert(BlogEntityDto blogEntity, UserEntityDto user) {
        return BlogExhibitDto.builder()
                .userId(blogEntity.getUserId())
                .title(blogEntity.getTitle())
                .description(blogEntity.getDescription())
                .content(blogEntity.getContent())
                .readCount(blogEntity.getReadCount())
                .nickname(user.getNickname())
                .avatar(user.getAvatar())
                .created(blogEntity.getCreated())
                .readCount(blogEntity.getReadCount())
                .build();
    }
}
