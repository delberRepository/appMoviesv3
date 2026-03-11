package com.cursospring.bibliopelis.dto;

public class DTOMovieSearch {
    private  String searchTitle;
    private int generoId;

    public DTOMovieSearch() {
    }

    public DTOMovieSearch(String searchTitle, int generoId) {
        this.searchTitle = searchTitle;
        this.generoId = generoId;
    }
}
