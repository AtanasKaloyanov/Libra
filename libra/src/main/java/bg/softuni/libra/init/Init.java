package bg.softuni.libra.init;

import bg.softuni.libra.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Init implements CommandLineRunner {
    private final UserRoleService userRoleService;
    private final UserService userService;
    private final PublisherService publisherService;
    private final WriterService writerService;
    private final BookService bookService;


    public Init(UserRoleService userRoleService, UserService userService, PublisherService publisherService, WriterService writerService, BookService bookService) {
        this.userRoleService = userRoleService;
        this.userService = userService;
        this.publisherService = publisherService;
        this.writerService = writerService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userRoleService.userRolesInit();
        this.userService.usersInit();
        this.publisherService.publishersInit();
        this.writerService.writersInit();
        this.bookService.booksInit();
    }
}
