package com.dh.serieservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Season {

    private String id;
    private Integer seasonNumber;
    private List<Chapter> chapters;

}
