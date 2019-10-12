package com.ead.exam.repository;

import com.ead.exam.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT b FROM Book b " +
            "where (:search is null or b.name like concat('%', :search, '%'))" +
            " or (:search is null or b.genre like concat('%', :search, '%')) " +
            "or (:search is null or b.author like concat('%', :search, '%'))")
    List<Book> searchBook(@Param("search") String search);
}
