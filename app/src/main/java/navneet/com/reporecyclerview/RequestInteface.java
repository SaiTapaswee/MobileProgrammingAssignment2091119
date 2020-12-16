package navneet.com.reporecyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface RequestInteface {
    @GET("repositories")
    Call<List<RepoModel>> getCarsJson();
}
