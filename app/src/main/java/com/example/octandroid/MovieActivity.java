package com.example.octandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {
    RecyclerView rvMovie;
    ProgressBar progressBar;
    ApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_movie);
        rvMovie = findViewById(R.id.rvmovie);
        progressBar = findViewById(R.id.rvprogress);
        apiService = ApiClient.getClient().create(ApiService.class);
        getMovie();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void getMovie(){
        progressBar.setVisibility(View.VISIBLE);
        Call<MovieResponse> call = apiService.getMovie("dhoom","c8d30391");
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                progressBar.setVisibility(View.GONE);
                List<Search> movieList = response.body().getSearch();
                MovieAdapter adapter = new MovieAdapter(movieList);
                rvMovie.setHasFixedSize(true);
                rvMovie.setLayoutManager(new LinearLayoutManager(MovieActivity.this));
                rvMovie.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });

    }

}