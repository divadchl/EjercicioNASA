package mx.com.serviciosinformaticosintegrales.nasa.data;


import mx.com.serviciosinformaticosintegrales.nasa.model.Apod;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApodService
{
    @GET("planetary/apod?api_key=K41viBmlCl1h6q5XdIg85oTJF6bcBangI5jWrdwe")
    Call<Apod> getTodayApod();

    @GET("planetary/apod")
    Call<Apod> getTodayApodWithQuery(@Query("api_key") String apiKey);
}
