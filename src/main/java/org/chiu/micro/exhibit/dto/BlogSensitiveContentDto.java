package org.chiu.micro.exhibit.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BlogSensitiveContentDto implements Serializable {

    private Long id;

    private Long blogId;

    private String sensitiveContentList;

}
