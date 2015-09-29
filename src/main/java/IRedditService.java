import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Part;
import retrofit.http.Path;

/**
 * Created by claudiug on 9/29/15.
 */
public interface IRedditService {

    @GET("/users/{user}")
    Call<GitHub> getUser(@Path("user") String user);
}
