package mx.com.serviciosinformaticosintegrales.nasa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import mx.com.serviciosinformaticosintegrales.nasa.data.ApodService;
import mx.com.serviciosinformaticosintegrales.nasa.data.Data;
import mx.com.serviciosinformaticosintegrales.nasa.model.Apod;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView txvTitulo, txvDescripcion, txvFecha;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView)findViewById(R.id.imagen);
        txvTitulo = (TextView)findViewById(R.id.titulo);
        txvDescripcion = (TextView)findViewById(R.id.descripcion);
        txvFecha = (TextView) findViewById(R.id.fecha);


        ApodService apodService = Data.getRetrofitInstance().create(ApodService.class);
        Call<Apod> callApodService = apodService.getTodayApodWithQuery("K41viBmlCl1h6q5XdIg85oTJF6bcBangI5jWrdwe");
        callApodService.enqueue(new Callback<Apod>()
        {
            @Override
            public void onResponse(Call<Apod> call, Response<Apod> response)
            {
                txvTitulo.setText(response.body().getTitle());
                txvDescripcion.setText(response.body().getExplanation());
                txvFecha.setText(response.body().getDate());
                Picasso.with(getApplicationContext()).load(response.body().getUrl()).into(img);
                //Log.d("APOD", response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Apod> call, Throwable t)
            {

            }
        });



        Log.d("Hola", BuildConfig.URL);
    }
}
