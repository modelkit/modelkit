package com.afantree.demo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.afantree.config.Config;
import com.afantree.model.FindIndex;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import com.afantree.config.Config;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private Retrofit retrofit;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        retrofit = new Retrofit.Builder()
                .baseUrl(Config.getHost())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //
        String url = FindIndex.Input.getUrlWithParam("哈哈");
        ((TextView) findViewById(R.id.url)).setText(url);
        result = (TextView) findViewById(R.id.result);
        findViewById(R.id.get_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });
        progressBar = (ProgressBar) findViewById(R.id.progress);
        progressBar.setVisibility(View.GONE);

    }


    private interface FindIndexService {
        @GET(FindIndex.Input.URL+".json")
        Call<FindIndex> getFindIndex();
    }

    private void loadData() {
        progressBar.setVisibility(View.VISIBLE);
        FindIndexService service = retrofit.create(FindIndexService.class);
        service.getFindIndex().enqueue(new Callback<FindIndex>() {
            @Override
            public void onResponse(Call<FindIndex> call, Response<FindIndex> response) {
                progressBar.setVisibility(View.GONE);
                if (response.body() != null) {
                    result.setText("responce list count = " + response.body().list.size());
                } else {
                    result.setText("responce null");
                }
            }

            @Override
            public void onFailure(Call<FindIndex> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                result.setText(t.toString());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
