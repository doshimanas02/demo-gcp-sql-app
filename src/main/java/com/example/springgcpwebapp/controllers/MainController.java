package com.example.springgcpwebapp.controllers;
import com.example.springgcpwebapp.domains.Author;
import com.example.springgcpwebapp.domains.Book;
import com.example.springgcpwebapp.domains.Publisher;
import com.example.springgcpwebapp.services.AuthorService;
import com.example.springgcpwebapp.services.BookService;
import com.example.springgcpwebapp.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PublisherService publisherService;

    @RequestMapping(value = {"/"})
    public String dashboard() {
        return "dashboard/dashboard";
    }

    @RequestMapping(value={"/books"})
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.listAll());
        return "books/list";
    }

    @RequestMapping("/authors")
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.listAll());
        return "authors/list";
    }

    @RequestMapping("/publishers")
    public String listPublishers(Model model) {
        model.addAttribute("publishers", publisherService.listAll());
        return "publishers/list";
    }

    @GetMapping("/book_form")
    public ModelAndView bookForm() {
        Book book = new Book();
        ModelAndView modelAndView = new ModelAndView("books/form.html");
        modelAndView.addObject("book", book);
        modelAndView.addObject("authors", authorService.listAll());
        modelAndView.addObject("publishers", publisherService.listAll());
        return modelAndView;
    }

    @GetMapping("/author_form")
    public ModelAndView authorForm() {
        Author author = new Author();
        ModelAndView modelAndView = new ModelAndView("authors/form.html");
        modelAndView.addObject("author", author);
        return modelAndView;
    }

    @GetMapping("/publisher_form")
    public ModelAndView publisherForm() {
        Publisher publisher = new Publisher();
        ModelAndView modelAndView = new ModelAndView("publishers/form.html");
        modelAndView.addObject("publisher", publisher);
        return modelAndView;
    }

    @PostMapping("/save_author")
    public String saveAuthor(@ModelAttribute Author author) {
        authorService.save(author);
        return "redirect:authors";
    }

    @PostMapping("/save_publisher")
    public String saveAuthor(@ModelAttribute Publisher publisher) {
        publisherService.save(publisher);
        return "redirect:publishers";
    }

    @PostMapping("/save_book")
    public String saveBook(@ModelAttribute Book book,
                           @RequestParam("publisher_id") Long publisher_id,
                           @RequestParam("author_id") Long author_id) {
        Publisher publisher = publisherService.get(publisher_id);
        Author author = authorService.get(author_id);
        book.getAuthors().add(author);
        book.setPublisher(publisher);
        bookService.save(book);
        return "redirect:books";
    }
}
