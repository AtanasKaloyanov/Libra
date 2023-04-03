package bg.softuni.libra.model.dto;

import bg.softuni.libra.model.entity.enums.CoverEnum;
import bg.softuni.libra.model.entity.enums.GenreEnum;

import java.math.BigDecimal;
import java.util.UUID;

public class BookDetailDTO {

    private Long id;
    private String name;
    private int year;
    private String publisher;
    private String writer;
    private int pages;
    private Double price;
    private GenreEnum genre;
    private CoverEnum cover;
    private String readerFirstName;
    private String readerLastName;

    public String getReaderFirstName() {
        return readerFirstName;
    }

    public void setReaderFirstName(String readerFirstName) {
        this.readerFirstName = readerFirstName;
    }

    public String getReaderLastName() {
        return readerLastName;
    }

    public void setReaderLastName(String readerLastName) {
        this.readerLastName = readerLastName;
    }

    public String getSellerFullName() {
        return readerFirstName + " " + readerLastName;
    }

    public BookDetailDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }

    public CoverEnum getCover() {
        return cover;
    }

    public void setCover(CoverEnum cover) {
        this.cover = cover;
    }

    public String getBookHighlight() {
        return this.writer + " - " +this.name;
    }


}
