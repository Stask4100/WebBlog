package com.kornevstas.WebBlog.repo;

import com.kornevstas.WebBlog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long>{
}
