package org.chiu.micro.exhibit.rpc.wrapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.chiu.micro.exhibit.dto.BlogEntityDto;
import org.chiu.micro.exhibit.lang.Result;
import org.chiu.micro.exhibit.rpc.BlogHttpService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * BlogHttpServiceWrapper
 */
@Component
@RequiredArgsConstructor
public class BlogHttpServiceWrapper {

    private final BlogHttpService blogHttpService;

    public BlogEntityDto findById(Long blogId, Integer year) {
        Result<BlogEntityDto> result = blogHttpService.findById(blogId);
        BlogEntityDto data = result.getData();
        if (Objects.isNull(data)) {
            return BlogEntityDto.builder()
                    .id(blogId)
                    .created(LocalDateTime.of(year, 1, 1, 1, 1, 1))
                    .build();
        }
        return data;
    }

    public BlogEntityDto findById(Long blogId) {
      Result<BlogEntityDto> result = blogHttpService.findById(blogId);
      return result.getData();
  }

    public List<BlogEntityDto> findAllById(List<Long> ids) {
        Result<List<BlogEntityDto>> result = blogHttpService.findAllById(ids);
        return result.getData();
    }

  public List<Integer> getYears() {
      Result<List<Integer>> result = blogHttpService.getYears();
      return result.getData();
  }

  public Long count() {
      Result<Long> result = blogHttpService.count();
      return result.getData();
  }

  public List<Long> findIds(Pageable pageRequest) {
      Result<List<Long>> result = blogHttpService.findIds(pageRequest);
      return result.getData();
  }

  public void setReadCount(Long id) {
      blogHttpService.setReadCount(id);
  }

  public Integer findStatusById(Long blogId) {
      Result<Integer> result = blogHttpService.findStatusById(blogId);
      return result.getCode();
  }

  public Page<BlogEntityDto> findPage(PageRequest pageRequest) {
      Result<Page<BlogEntityDto>> result = blogHttpService.findPage(pageRequest);
      return result.getData();
  }

  public Page<BlogEntityDto> findPageByCreatedBetween(PageRequest pageRequest, LocalDateTime start, LocalDateTime end) {
      Result<Page<BlogEntityDto>> result = blogHttpService.findPageByCreatedBetween(pageRequest, start, end);
      return result.getData();
  }

  public Long countByCreatedBetween(LocalDateTime start, LocalDateTime end) {
      Result<Long> result = blogHttpService.countByCreatedBetween(start, end);
      return result.getData();
  }

  public long countByCreatedGreaterThanEqual(LocalDateTime created) {
      Result<Long> result = blogHttpService.countByCreatedGreaterThanEqual(created);
      return result.getData();
  }

  public long getPageCountYear(LocalDateTime created, LocalDateTime start, LocalDateTime end) {
      Result<Long> result = blogHttpService.getPageCountYear(created, start, end);
      return result.getData();
  }

  
}