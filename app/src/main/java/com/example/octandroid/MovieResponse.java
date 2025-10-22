package com.example.octandroid;

import java.util.ArrayList;
import java.util.List;

public class MovieResponse {
    private List<Search> Search =new ArrayList<>();
    private String totalResults;
    private String Response;

    public MovieResponse(List<Search> search, String totalResults, String response) {
        Search = search;
        this.totalResults = totalResults;
        Response = response;
    }

    public List<Search> getSearch() {
        return Search;
    }

    public void setSearch(List<Search> search) {
        Search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }
}
