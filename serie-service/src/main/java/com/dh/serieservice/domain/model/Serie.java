package com.dh.serieservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("serie")
public class Serie {

    @Id
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String genre;
    private List<Season> seasons;

}
