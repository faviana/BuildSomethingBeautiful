package com.ironyard.recipes.dto;

import javax.persistence.*;
import java.util.List;

/**
 * Created by favianalopez on 10/28/16.
 * {
 "title": "Recipe Puppy",
 "version": 0.1,
 "href": "http:\/\/www.recipepuppy.com\/",
 "results": [
 {
 "title": "Ginger Champagne",
 "href": "http:\/\/allrecipes.com\/Recipe\/Ginger-Champagne\/Detail.aspx",
 "ingredients": "champagne, ginger, ice, vodka",
 "thumbnail": "http:\/\/img.recipepuppy.com\/1.jpg"
 },
 */
@Entity
public class Response {

    private String title;
    private String href;
    @OneToMany(cascade = CascadeType.ALL)
    List<Results> results;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
