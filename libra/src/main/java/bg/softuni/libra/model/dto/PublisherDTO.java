package bg.softuni.libra.model.dto;

import java.util.ArrayList;
import java.util.List;

public class PublisherDTO {
    private String name;

    private List<WriterDTO> writers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WriterDTO> getWriters() {
        return writers;
    }

    public void setWriters(List<WriterDTO> writers) {
        this.writers = writers;
    }

    public PublisherDTO addWriter(WriterDTO writer) {
        if (this.writers == null) {
            this.writers = new ArrayList<>();
        }
        this.writers.add(writer);

        return this;
    }
}
