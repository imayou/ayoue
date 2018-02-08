package io.ayoue.admin.site.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import io.ayoue.admin.site.bo.Movie;

public interface MovieRepository extends GraphRepository<Movie> {
	Movie findByTitle(@Param("title") String title);
}
