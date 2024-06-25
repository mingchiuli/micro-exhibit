package org.chiu.micro.exhibit.rpc.wrapper;

import org.chiu.micro.exhibit.dto.UserEntityDto;
import org.chiu.micro.exhibit.exception.MissException;
import org.chiu.micro.exhibit.lang.Result;
import org.chiu.micro.exhibit.rpc.UserHttpService;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import static org.chiu.micro.exhibit.lang.ExceptionMessage.NO_FOUND;;


@Component
@RequiredArgsConstructor
public class UserhttpServiceWrapper {

    private final UserHttpService userHttpService;

    public UserEntityDto findById(Long userId) {
        Result<UserEntityDto> result = userHttpService.findById(userId);
        if (result.getCode() != 200) {
            throw new MissException(NO_FOUND.getMsg());
        }
        return result.getData();
    }
}
