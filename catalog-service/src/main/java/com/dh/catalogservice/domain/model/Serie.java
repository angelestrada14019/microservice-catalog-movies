package com.dh.catalogservice.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("serie")
@ToString
public class Serie {
    @Id
    private String id;
    private String name;
    private String genre;
    private List<Season> seasons;
}
