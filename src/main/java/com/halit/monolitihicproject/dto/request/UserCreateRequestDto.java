package com.halit.monolitihicproject.dto.request;


import com.halit.monolitihicproject.repository.entity.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequestDto {

    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String city;
    @Enumerated(EnumType.STRING)
    private EGender gender;
    private String password;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
}
