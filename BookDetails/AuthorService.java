package group6.bookstore.BookDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getBooks(){
        return authorRepository.findAll();
    }

    public void addNewAuthor(Author author) {
        Optional<Author> authorOptional = authorRepository.findAuthorByfirstName(author.getFirstName());
        if (authorOptional.isPresent()){
            throw new IllegalStateException("Author Already Present");
        }
        authorRepository.save(author);
    }

}
