package org.chiu.micro.exhibit.convertor;

import org.chiu.micro.exhibit.dto.BlogExhibitDto;
import org.chiu.micro.exhibit.vo.BlogExhibitVo;

public class BlogExhibitVoConvertor {

    private BlogExhibitVoConvertor() {}

    public static BlogExhibitVo convert(BlogExhibitDto dto, String newContent, String newtitle, String newDescription) {
        return BlogExhibitVo.builder()
                .title(newtitle)
                .description(newDescription)
                .content(newContent)
                .readCount(dto.getReadCount())
                .nickname(dto.getNickname())
                .avatar(dto.getAvatar())
                .created(dto.getCreated())
                .readCount(dto.getReadCount())
                .build();
    }

    public static BlogExhibitVo convert(BlogExhibitDto dto) {
        return BlogExhibitVo.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .content(dto.getContent())
                .readCount(dto.getReadCount())
                .nickname(dto.getNickname())
                .avatar(dto.getAvatar())
                .created(dto.getCreated())
                .readCount(dto.getReadCount())
                .build();
    }
}
