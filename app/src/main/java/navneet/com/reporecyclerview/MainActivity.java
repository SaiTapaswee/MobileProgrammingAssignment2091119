package navneet.com.reporecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<RepoModel> repoModels =new ArrayList<>();
    private RepoAdapter repoAdapter;
    private RecyclerView repo_recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repo_recyclerview=(RecyclerView)findViewById(R.id.repo_recyclerview);
        repo_recyclerview.setLayoutManager(new LinearLayoutManager(this));

        getCarsResponse();

    }

    private void getCarsResponse() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInteface requestInteface=retrofit.create(RequestInteface.class);
        Call<List<RepoModel>> call=requestInteface.getCarsJson();



        call.enqueue(new Callback<List<RepoModel>>() {
            @Override
            public void onResponse(Call<List<RepoModel>> call, Response<List<RepoModel>> response) {
                repoModels =new ArrayList<>(response.body());
                repoAdapter =new RepoAdapter(MainActivity.this, repoModels);
                repo_recyclerview.setAdapter(repoAdapter);
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<RepoModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
