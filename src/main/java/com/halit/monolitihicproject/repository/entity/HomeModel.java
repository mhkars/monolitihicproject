package com.halit.monolitihicproject.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HomeModel {
    String nameSurname;
    List<String> photoList;
    String backgroundColor;

}
