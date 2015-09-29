import retrofit.*;

import java.util.List;

/**
 * Created by claudiug on 9/29/15.
 */
public class Main {
    private static final String BASE_URL = "https://api.github.com/users/";

    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IRedditService servive = retrofit.create(IRedditService.class);

        Call<GitHub> user = servive.getUser("claudiug");

        user.enqueue(new Callback<GitHub>() {
            @Override
            public void onResponse(Response<GitHub> response, Retrofit retrofit) {
                System.out.println(response.code());
                System.out.println(response.raw());
                System.out.println(response.body().getEmail());
                System.out.println(response.body().getClass());
                System.out.println(retrofit.client());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
