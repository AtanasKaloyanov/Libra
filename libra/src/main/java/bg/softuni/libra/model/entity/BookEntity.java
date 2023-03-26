package bg.softuni.libra.model.entity;

import bg.softuni.libra.model.entity.enums.CoverEnum;
import bg.softuni.libra.model.entity.enums.GenreEnum;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class BookEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GenreEnum genre;

    private String imageUrl;

    @Column(nullable = false)
    private Integer pages;

    @Column(nullable = false)
    private Double price;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String resume;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CoverEnum cover;

    private Integer year;

    @ManyToOne
    private WriterEntity writer;

    @ManyToOne
    private UserEntity reader;

    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public WriterEntity getWriter() {
        return writer;
    }

    public void setWriter(WriterEntity writer) {
        this.writer = writer;
    }

    public UserEntity getReader() {
        return reader;
    }

    public void setReader(UserEntity reader) {
        this.reader = reader;
    }


}
