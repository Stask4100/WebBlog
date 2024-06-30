package com.kornevstas.WebBlog.repo;

import com.kornevstas.WebBlog.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    @Query("SELECT p FROM Post p ORDER BY p.views DESC")
    List<Post> findTop3ByOrderByViewsDesc();

    // Додаємо метод пошуку блогів за частковим збігом назви
    @Query("SELECT p FROM Post p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Post> findByTitleContainingIgnoreCase(String title);
}
