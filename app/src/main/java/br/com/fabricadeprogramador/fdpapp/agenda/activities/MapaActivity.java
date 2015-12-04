package br.com.fabricadeprogramador.fdpapp.agenda.activities;

import android.location.Location;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import br.com.fabricadeprogramador.fdpapp.R;
import butterknife.ButterKnife;

/**
 * Created by Virmerson on 12/3/15.
 */
public class MapaActivity extends AppCompatActivity implements OnMapReadyCallback {


    Marker marker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa);
        ButterKnife.bind(this);
        MapFragment map =  (MapFragment) getFragmentManager().findFragmentById(R.id.mapa);
        map.getMapAsync(this);

    }


    @Override
    public void onMapReady(final GoogleMap googleMap) {

        googleMap.setMyLocationEnabled(true);
        googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {

                if (marker!=null){
                    marker.remove();
                }

                double latitude = location.getLatitude();
                double longitude = location.getLongitude();

                LatLng latLng = new LatLng(latitude, longitude);

                marker =  googleMap.addMarker(new MarkerOptions().position(latLng));


            }
        });


    }
}
