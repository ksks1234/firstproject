package com.example.firstproject.repository;

import com.example.firstproject.enetity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
