package bg.softuni.libra.service;

import bg.softuni.libra.model.entity.PublisherEntity;
import bg.softuni.libra.model.entity.WriterEntity;
import bg.softuni.libra.model.entity.enums.CategoryEnum;
import bg.softuni.libra.repository.PublisherRepository;
import bg.softuni.libra.repository.WriterRepository;
import org.springframework.stereotype.Service;
@Service
public class WriterService {
    private final PublisherRepository publisherRepository;
    private final WriterRepository writerRepository;

    public WriterService(PublisherRepository publisherRepository, WriterRepository writerRepository) {
        this.publisherRepository = publisherRepository;
        this.writerRepository = writerRepository;
    }

    public void writersInit() {
        // Writer - George Orwell
        WriterEntity georgeOrwell = new WriterEntity();
        georgeOrwell.setName("George Orwell");
        georgeOrwell.setCategory(CategoryEnum.PROSAIST);
        georgeOrwell.setYearOfBirth(1903);
        georgeOrwell.setYearOfDeath(1950);

        PublisherEntity fama = this.publisherRepository.findById(1L).orElseThrow();
        georgeOrwell.setPublisher(fama);

        this.writerRepository.save(georgeOrwell);

        // Writer - Fyodor Dostoevsky
        WriterEntity fyodorDostoevsky = new WriterEntity();
        fyodorDostoevsky.setName("Fyodor Dostoevsky");
        fyodorDostoevsky.setCategory(CategoryEnum.PROSAIST);
        fyodorDostoevsky.setYearOfBirth(1821);
        fyodorDostoevsky.setYearOfDeath(1881);

        PublisherEntity zaharyStoyanov = this.publisherRepository.findById(2L).orElseThrow();
        fyodorDostoevsky.setPublisher(zaharyStoyanov);

        this.writerRepository.save(fyodorDostoevsky);

        // Writer - Georgi Gospodinov
        WriterEntity georgiGospodinov = new WriterEntity();
        georgiGospodinov.setName("Georgi Gospodinov");
        georgiGospodinov.setCategory(CategoryEnum.PROSAIST);
        georgiGospodinov.setYearOfBirth(1968);

        PublisherEntity zhanet45 = this.publisherRepository.findById(3L).orElseThrow();
        georgiGospodinov.setPublisher(zhanet45);

        this.writerRepository.save(georgiGospodinov);
    }
}
