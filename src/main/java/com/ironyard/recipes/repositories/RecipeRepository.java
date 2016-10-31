package com.ironyard.recipes.repositories;

import com.ironyard.recipes.dto.Response;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by favianalopez on 10/28/16.
 */
public interface RecipeRepository extends CrudRepository<Response, Long> {
}
