package bg.softuni.libra.service;

import bg.softuni.libra.model.entity.PublisherEntity;
import bg.softuni.libra.model.entity.enums.UserRoleEnum;
import bg.softuni.libra.repository.PublisherRepository;
import org.springframework.stereotype.Service;

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
}
