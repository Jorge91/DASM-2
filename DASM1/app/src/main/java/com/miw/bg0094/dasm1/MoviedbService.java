package com.miw.bg0094.dasm1;

import com.miw.bg0094.dasm1.models.APIShowsList;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface MoviedbService {
    @GET("/3/discover/tv?api_key=3e7cd0eb6202c57f54dc4da2b5d7995f")
    Call<APIShowsList> listShows(@Query("page") int page);
}
