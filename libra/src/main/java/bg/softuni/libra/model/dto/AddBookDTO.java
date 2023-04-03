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
    private Long bookId;
    @NotEmpty
    private String name;

    @NotNull
    private GenreEnum genre;

    @Positive
    @NotNull
    private Double price;

    @Positive
    @NotNull
    private Integer pages;

    @NotNull
    private Integer year;

    @NotEmpty
    private String resume;

    @NotNull
    private CoverEnum cover;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public CoverEnum getCover() {
        return cover;
    }

    public void setCover(CoverEnum cover) {
        this.cover = cover;
    }
}
