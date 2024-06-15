package org.chiu.micro.exhibit.rpc;

import java.time.LocalDateTime;
import java.util.List;

import org.chiu.micro.exhibit.dto.BlogEntityDto;
import org.chiu.micro.exhibit.lang.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

public interface BlogHttpService {

    @GetExchange("/blog/{blogId}")
    Result<BlogEntityDto> findById(@PathVariable Long blogId);

    @PostExchange("/blog/batch")
    Result<List<BlogEntityDto>> findAllById(@RequestBody List<Long> ids);

    @GetExchange("/blog/years")
    Result<List<Integer>> getYears();

    @GetExchange("/blog/count")
    Result<Long> count();

    @PostExchange("/blog/ids")
    Result<List<Long>> findIds(@RequestBody Pageable pageRequest);

    @GetExchange("/blog/{blogId}")
    void setReadCount(@PathVariable Long blogId);

    @GetExchange("/blog/status/{blogId}")
    Result<Integer> findStatusById(@PathVariable Long blogId);

    @PostExchange("/blog/page")
    Result<Page<BlogEntityDto>> findPage(@RequestBody PageRequest pageRequest);

    @PostExchange("/blog/page/year/{start}/{end}")
    Result<Page<BlogEntityDto>> findPageByCreatedBetween(@RequestBody PageRequest pageRequest,
                                                         @PathVariable(value = "start") LocalDateTime start,
                                                         @PathVariable(value = "end") LocalDateTime end);

    @PostExchange("/blog/count/{start}/{end}")
    Result<Long> countByCreatedBetween(@PathVariable(value = "start") LocalDateTime start,
                                       @PathVariable(value = "end") LocalDateTime end);

    @GetExchange("/blog/page/count/year/{created}/{start}/{end}")
    Result<Long> getPageCountYear(@PathVariable(value = "created") LocalDateTime created,
                                  @PathVariable(value = "start") LocalDateTime start,
                                  @PathVariable(value = "end") LocalDateTime end);

    @GetExchange("/blog/count/until/{created}")
    Result<Long> countByCreatedGreaterThanEqual(LocalDateTime created);
}
