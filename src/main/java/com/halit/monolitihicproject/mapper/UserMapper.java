package com.halit.monolitihicproject.mapper;

import com.halit.monolitihicproject.dto.request.LoginRequestDto;
import com.halit.monolitihicproject.dto.request.UserCreateRequestDto;
import com.halit.monolitihicproject.dto.response.UserCreateResponseDto;
import com.halit.monolitihicproject.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.annotation.CreatedBy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserCreateResponseDto toUserCreateResponseDto(final User user);

    User toUser(final UserCreateResponseDto userCreateResponseDto);
    User toUser(final UserCreateRequestDto userCreateRequestDto);
    User toUser(final LoginRequestDto loginRequestDto);
}
