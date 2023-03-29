package bg.softuni.libra.service;

import bg.softuni.libra.model.dto.PublisherDTO;
import bg.softuni.libra.model.dto.WriterDTO;
import bg.softuni.libra.model.entity.PublisherEntity;
import bg.softuni.libra.model.entity.WriterEntity;
import bg.softuni.libra.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public void publishersInit() {
        // Publisher - Fama
        PublisherEntity fama = new PublisherEntity();
        fama.setName("Fama");
        this.publisherRepository.save(fama);

        // Publisher - Zahary Stoyanov
        PublisherEntity zaharyStoyanov = new PublisherEntity();
        zaharyStoyanov.setName("Zahary Stoyanov");
        publisherRepository.save(zaharyStoyanov);

        // Publisher - Zhanet-45
        PublisherEntity zhanet45 = new PublisherEntity();
        zhanet45.setName("Zhanet-45");
        publisherRepository.save(zhanet45);
    }

    public List<PublisherDTO> getAllPublishers() {
        return publisherRepository.
                findAll().
                stream().
                map(this::mapPublisher).
                collect(Collectors.toList());
    }

    private PublisherDTO mapPublisher(PublisherEntity publisherEntity) {
        List<WriterDTO> writers = publisherEntity.
                getWriters().
                stream().
                map(this::mapWriter).
                toList();

        PublisherDTO publisherDTO = new PublisherDTO();
        publisherDTO.setWriters(writers);
        publisherDTO.setName(publisherEntity.getName());

        return publisherDTO;
    }

    private WriterDTO mapWriter(WriterEntity writerEntity) {
        WriterDTO writerDTO = new WriterDTO();
        writerDTO.setId(writerEntity.getId());
        writerDTO.setName(writerEntity.getName());

        return writerDTO;
    }


}
