package com.miw.bg0094.dasm1.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Result;

public class Show {
    private Object backdropPath;
    private String firstAirDate;
    private List<Integer> genreIds = new ArrayList<Integer>();
    private Integer id;
    private String originalLanguage;
    private String originalName;
    private String overview;
    private List<String> originCountry = new ArrayList<String>();
    private String posterPath;
    private Double popularity;
    private String name;
    private Integer voteAverage;
    private Integer voteCount;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The backdropPath
     */
    public Object getBackdropPath() {
        return backdropPath;
    }

    /**
     *
     * @param backdropPath
     * The backdrop_path
     */
    public void setBackdropPath(Object backdropPath) {
        this.backdropPath = backdropPath;
    }

    /**
     *
     * @return
     * The firstAirDate
     */
    public String getFirstAirDate() {
        return firstAirDate;
    }

    /**
     *
     * @param firstAirDate
     * The first_air_date
     */
    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    /**
     *
     * @return
     * The genreIds
     */
    public List<Integer> getGenreIds() {
        return genreIds;
    }

    /**
     *
     * @param genreIds
     * The genre_ids
     */
    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The originalLanguage
     */
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    /**
     *
     * @param originalLanguage
     * The original_language
     */
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    /**
     *
     * @return
     * The originalName
     */
    public String getOriginalName() {
        return originalName;
    }

    /**
     *
     * @param originalName
     * The original_name
     */
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    /**
     *
     * @return
     * The overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     *
     * @param overview
     * The overview
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     *
     * @return
     * The originCountry
     */
    public List<String> getOriginCountry() {
        return originCountry;
    }

    /**
     *
     * @param originCountry
     * The origin_country
     */
    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    /**
     *
     * @return
     * The posterPath
     */
    public String getPosterPath() {
        return posterPath;
    }

    /**
     *
     * @param posterPath
     * The poster_path
     */
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    /**
     *
     * @return
     * The popularity
     */
    public Double getPopularity() {
        return popularity;
    }

    /**
     *
     * @param popularity
     * The popularity
     */
    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The voteAverage
     */
    public Integer getVoteAverage() {
        return voteAverage;
    }

    /**
     *
     * @param voteAverage
     * The vote_average
     */
    public void setVoteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
    }

    /**
     *
     * @return
     * The voteCount
     */
    public Integer getVoteCount() {
        return voteCount;
    }

    /**
     *
     * @param voteCount
     * The vote_count
     */
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    @Override
    public String toString() {
        return name;
    }
}
