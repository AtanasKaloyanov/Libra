package bg.softuni.libra.model.dto;

import bg.softuni.libra.model.entity.enums.CoverEnum;
import bg.softuni.libra.model.entity.enums.GenreEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AddBookDTO {
    @NotNull
    @Min(1)
    private Long modelId;
    @NotNull
    private GenreEnum genre;

    @Positive
    @NotNull
    private Double price;

    @Positive
    @NotNull
    private Integer pages;

    @Min(1900)
    @NotNull
    private Integer year;

    @NotEmpty
    private String description;

    @NotNull
    private CoverEnum cover;

}
