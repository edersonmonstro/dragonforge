package com.dmset.dragonforge.services;

import com.dmset.dragonforge.dtos.BookRecordDto;
import com.dmset.dragonforge.models.BookModel;
import com.dmset.dragonforge.models.ReviewModel;
import com.dmset.dragonforge.repositories.AuthorRepository;
import com.dmset.dragonforge.repositories.BookRepository;
import com.dmset.dragonforge.repositories.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    public BookModel saveBook(BookRecordDto bookRecordDto){
        BookModel book = new BookModel();
        book.setTitle(bookRecordDto.title());
        book.setPublisher(publisherRepository.findById(bookRecordDto.publisherId()).get());
        System.out.println(bookRecordDto.publisherId());
        book.setAuthors(authorRepository.findAllById(bookRecordDto.authorIds()).stream().collect(Collectors.toSet()));

        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setComment(bookRecordDto.reviewComment());
        reviewModel.setBook(book);
        book.setReview(reviewModel);

        return bookRepository.save(book);
    }

}
