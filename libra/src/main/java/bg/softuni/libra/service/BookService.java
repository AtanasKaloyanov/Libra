package bg.softuni.libra.service;

import bg.softuni.libra.mapper.BookMapper;
import bg.softuni.libra.model.dto.AddBookDTO;
import bg.softuni.libra.model.entity.BookEntity;
import bg.softuni.libra.model.entity.UserEntity;
import bg.softuni.libra.model.entity.WriterEntity;
import bg.softuni.libra.model.entity.enums.CoverEnum;
import bg.softuni.libra.model.entity.enums.GenreEnum;
import bg.softuni.libra.repository.BookRepository;
import bg.softuni.libra.repository.UserRepository;
import bg.softuni.libra.repository.WriterRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final WriterRepository writerRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(WriterRepository writerRepository, UserRepository userRepository, BookRepository bookRepository, BookMapper bookMapper) {
        this.writerRepository = writerRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public void booksInit() {

        WriterEntity georgeOrwell = this.writerRepository.findById(1L).orElseThrow();
        WriterEntity fyodorDostoevsky = this.writerRepository.findById(2L).orElseThrow();
        WriterEntity georgiGospodinov = this.writerRepository.findById(3L).orElseThrow();

        UserEntity mariaGeorgieva = this.userRepository.findById(3L).orElseThrow();
        UserEntity sofiaIvanova = this.userRepository.findById(4L).orElseThrow();
        UserEntity dimitarDimitrov = this.userRepository.findById(5L).orElseThrow();

        // 1984
        BookEntity b1984 = new BookEntity();
        b1984.setGenre(GenreEnum.DISTOPIAN);
        b1984.setPages(316);
        b1984.setPrice(16.00);
        b1984.setResume("To Winston Smith, a young man who works in the Ministry of Truth (Minitru for short), come two people who transform this life completely. One is Julia, whom he meets after she hands him a slip reading, \"I love you.\" The other is O'Brien, who tells him, \"We shall meet in the place where there is no darkness.\" The way in which Winston is betrayed by the one and, against his own desires and instincts, ultimately betrays the other, makes a story of mounting drama and suspense.");
        b1984.setCover(CoverEnum.PAPERBOUND);
        b1984.setYear(1948);
        b1984.setWriter(georgeOrwell);
        b1984.setReader(mariaGeorgieva);

        // Animal Farm
        BookEntity animalFarm = new BookEntity();
        animalFarm.setGenre(GenreEnum.DISTOPIAN);
        animalFarm.setPages(110);
        animalFarm.setPrice(12.00);
        animalFarm.setResume("A farm is taken over by its overworked, mistreated animals. With flaming idealism and stirring slogans, they set out to create a paradise of progress, justice, and equality. Thus the stage is set for one of the most telling satiric fables ever penned –a razor-edged fairy tale for grown-ups that records the evolution from revolution against tyranny to a totalitarianism just as terrible.\n" +
                "When Animal Farm was first published, Stalinist Russia was seen as its target. Today it is devastatingly clear that wherever and whenever freedom is attacked, under whatever banner, the cutting clarity and savage comedy of George Orwell’s masterpiece have a meaning and message still ferociously fresh.");
        animalFarm.setCover(CoverEnum.PAPERBOUND);
        animalFarm.setYear(1945);
        animalFarm.setWriter(georgeOrwell);
        animalFarm.setReader(mariaGeorgieva);

        // Crime and Punishment
        BookEntity crimeAndPunishment = new BookEntity();
        crimeAndPunishment.setGenre(GenreEnum.REALISM);
        crimeAndPunishment.setPages(512);
        crimeAndPunishment.setPrice(30.00);
        crimeAndPunishment.setResume("Raskolnikov, a destitute and desperate former student, wanders through the slums of St Petersburg and commits a random murder without remorse or regret. He imagines himself to be a great man, a Napoleon: acting for a higher purpose beyond conventional moral law. But as he embarks on a dangerous game of cat and mouse with a suspicious police investigator, Raskolnikov is pursued by the growing voice of his conscience and finds the noose of his own guilt tightening around his neck. Only Sonya, a downtrodden sex worker, can offer the chance of redemption.");
        crimeAndPunishment.setCover(CoverEnum.HARDBOUND);
        crimeAndPunishment.setYear(1886);
        crimeAndPunishment.setWriter(fyodorDostoevsky);
        crimeAndPunishment.setReader(sofiaIvanova);

        // Karamazov Brothers
        BookEntity karamazovBrothers = new BookEntity();
        karamazovBrothers.setGenre(GenreEnum.REALISM);
        karamazovBrothers.setPages(928);
        karamazovBrothers.setPrice(30.00);
        karamazovBrothers.setResume("To Winston Smith, a young man who works in the Ministry of Truth (Minitru for short), come two people who transform this life completely. One is Julia, whom he meets after she hands him a slip reading, \"I love you.\" The other is O'Brien, who tells him, \"We shall meet in the place where there is no darkness.\" The way in which Winston is betrayed by the one and, against his own desires and instincts, ultimately betrays the other, makes a story of mounting drama and suspense.");
        karamazovBrothers.setCover(CoverEnum.HARDBOUND);
        karamazovBrothers.setYear(1948);
        karamazovBrothers.setWriter(fyodorDostoevsky);
        karamazovBrothers.setReader(sofiaIvanova);

        // The Physics of Sorrow
        BookEntity thePhysicsOfSorrow = new BookEntity();
        thePhysicsOfSorrow.setGenre(GenreEnum.FICTION);
        thePhysicsOfSorrow.setPages(344);
        thePhysicsOfSorrow.setPrice(24.00);
        thePhysicsOfSorrow.setResume("Using the myth of the Minotaur as its organizing image, the narrator of Gospodinov's long-awaited novel constructs a labyrinth of stories about his family, jumping from era to era and viewpoint to viewpoint, exploring the mindset and trappings of Eastern Europeans. Incredibly moving—such as with the story of his grandfather accidentally being left behind at a mill—and extraordinarily funny—see the section on the awfulness of the question \"how are you?\"—Physics is a book that you can inhabit, tracing connections, following the narrator down various \"side passages,\" getting pleasantly lost in the various stories and empathizing with the sorrowful, misunderstood Minotaur at the center of it all.");
        thePhysicsOfSorrow.setCover(CoverEnum.HARDBOUND);
        thePhysicsOfSorrow.setYear(2011);
        thePhysicsOfSorrow.setWriter(georgiGospodinov);
        thePhysicsOfSorrow.setReader(dimitarDimitrov);

        // Time Shelter
        BookEntity timeShelter = new BookEntity();
        timeShelter.setGenre(GenreEnum.FICTION);
        timeShelter.setPages(372);
        timeShelter.setPrice(20.00);
        timeShelter.setResume("In Time Shelter, an enigmatic flâneur named Gaustine opens a “clinic for the past” that offers a promising treatment for Alzheimer’s sufferers: each floor reproduces a decade in minute detail, transporting patients back in time. As Gaustine’s assistant, the unnamed narrator is tasked with collecting the flotsam and jetsam of the past, from 1960s furniture and 1940s shirt buttons to scents and even afternoon light. But as the rooms become more convincing, an increasing number of healthy people seek out the clinic as a “time shelter”—a development that results in an unexpected conundrum when the past begins to invade the present. Intricately crafted, and eloquently translated by Angela Rodel, Time Shelter announces Gospodinov to American readers as an essential voice in international literature.");
        timeShelter.setCover(CoverEnum.PAPERBOUND);
        timeShelter.setYear(2020);
        timeShelter.setWriter(georgiGospodinov);
        timeShelter.setReader(dimitarDimitrov);

        this.bookRepository.save(b1984);
        this.bookRepository.save(animalFarm);
        this.bookRepository.save(crimeAndPunishment);
        this.bookRepository.save(karamazovBrothers);
        this.bookRepository.save(thePhysicsOfSorrow);
        this.bookRepository.save(timeShelter);
    }

    public void addBook(AddBookDTO addBookDTO, UserDetails userDetails) {
        BookEntity newBook = this.bookMapper.
                addBookDtoToBookEntity(addBookDTO);

        UserEntity reader = this.userRepository.findByEmail(userDetails.getUsername()).
                orElseThrow();

        WriterEntity writer = this.writerRepository.findById(addBookDTO.getBookId())
                        .orElseThrow();


        newBook.setWriter(writer);
        newBook.setReader(reader);

        this.bookRepository.save(newBook);
    }
}
