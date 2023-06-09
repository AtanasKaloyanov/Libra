package bg.softuni.libra.web;

import bg.softuni.libra.exception.ObjectNotFoundException;
import bg.softuni.libra.model.dto.AddBookDTO;
import bg.softuni.libra.model.dto.SearchBookDTO;
import bg.softuni.libra.service.BookService;
import bg.softuni.libra.service.PublisherService;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class BookController {

    private final BookService bookService;

    private final PublisherService publisherService;

    public BookController(BookService bookService, PublisherService publisherService) {
        this.bookService = bookService;
        this.publisherService = publisherService;
    }

    // Adding Book logic - GET And POST
    @GetMapping("/books/add")
    public String addBook(Model model) {
        if (!model.containsAttribute("addBookModel")) {
            model.addAttribute("addBookModel", new AddBookDTO());
        }
        model.addAttribute("publishers", publisherService.getAllPublishers());

        return "book-add";
    }

    @PostMapping("/books/add")
    public String addBook(@Valid AddBookDTO addBookModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal UserDetails userDetails) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addBookModel", addBookModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addBookModel",
                    bindingResult);
            return "redirect:/books/add";
        }

        bookService.addBook(addBookModel, userDetails);

        return "redirect:/books/all";
    }


    @GetMapping("/books/all")
    public String allOffers(
            Model model,
            @PageableDefault(
                    sort = "price",
                    direction = Sort.Direction.ASC,
                    page = 0,
                    size = 5) Pageable pageable) {

        model.addAttribute("books", bookService.getAllBooks(pageable));

        return "books";
    }

    @GetMapping("/books/{id}")
    public String getBookDetail(@PathVariable("id") Long id,
                                 Model model) {

        var bookDto =
                this.bookService.findBookById(id).
                        orElseThrow(() -> new ObjectNotFoundException("Book with ID " +
                                id + " not found!"));

        model.addAttribute("book", bookDto);

        return "details";
    }

   // @PreAuthorize("@bookService.isOwner(#principal.name, #id)")
    @PreAuthorize("isOwner(#id)")
    @DeleteMapping("/books/{id}")
    public String deleteBook(
            @PathVariable("id") Long id) {
        bookService.deleteBookById(id);

        return "redirect:/books/all";
    }

    @GetMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id,
                       Model model) {
        var book = bookService.getBookEditDetails(id).
                orElseThrow(() -> new ObjectNotFoundException("Book with ID "+ id + "not found"));

        model.addAttribute("book", book);

        return "details";
    }

    @GetMapping("/books/search")
    public String searchQuery(@Valid SearchBookDTO searchBookDTO,
                              BindingResult bindingResult,
                              Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("searchBookModel", searchBookDTO);
            model.addAttribute(
                    "org.springframework.validation.BindingResult.searchBookModel",
                    bindingResult);
            return "book-search";
        }

        if (!model.containsAttribute("searchBookModel")) {
            model.addAttribute("searchBookModel", searchBookDTO);
        }

        if (!searchBookDTO.isEmpty()) {
            model.addAttribute("books", bookService.searchBook(searchBookDTO));
        }

        return "book-search";
    }
}
