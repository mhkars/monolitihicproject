package com.halit.monolitihicproject.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 64)
    private String name;
    @Column(length = 64)
    private String surname;
    @Column(length = 64)
    private String email;
    @Column(length = 16)
    private String phoneNumber;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(length = 16)
    private String city;
    @Enumerated(EnumType.STRING)
    private EGender gender;
    @Column(length = 32)
    private String password;


}
