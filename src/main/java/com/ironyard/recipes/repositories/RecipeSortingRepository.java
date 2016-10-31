package com.ironyard.recipes.repositories;

import com.ironyard.recipes.dto.Response;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by favianalopez on 10/28/16.
 */
public interface RecipeSortingRepository extends PagingAndSortingRepository<Response, Long> {
}
