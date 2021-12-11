package com.example.whatsupapp.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.whatsupapp.Controller.ControllerActivity;
import com.example.whatsupapp.R;
import com.example.whatsupapp.databinding.FragmentMapsBinding;
import com.example.whatsupapp.model.Event;
import com.example.whatsupapp.model.EventCollection;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.shape.MarkerEdgeTreatment;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsFragment extends Fragment implements IMap {
    IMap.Listener listener;
    ControllerActivity activity;
    FragmentMapsBinding binding;
    GoogleMap map;
    ArrayList<Event> curEvents;

    Map<String,LatLng> locMap = makeMap();


    public MapsFragment(IMap.Listener listener){
        this.listener = listener;
    }

    private Map<String, LatLng> makeMap() {
        Map<String,LatLng> locMap = new HashMap<String, LatLng>();
        locMap.put("Main Building", new LatLng(41.68685306877263, -73.89522853176274));
        locMap.put("Strong House", new LatLng(41.688796491813065, -73.89628877096887));
        locMap.put("Raymond House", new LatLng(41.68842060798536, -73.89752036196587));
        locMap.put("Davison House", new LatLng(41.689196365814524, -73.89757390940052));
        locMap.put("Lathrop House", new LatLng(41.68930033264778, -73.89638515635123));
        locMap.put("Jewett House", new LatLng(41.690188042612675, -73.89708127300173));
        locMap.put("Josselyn House", new LatLng(41.69000410371617, -73.8984413778419));
        locMap.put("Cushing House", new LatLng(41.689513224165985, -73.8930046471482));
        locMap.put("Noyes House", new LatLng(41.68959847224618, -73.894039198147));
        locMap.put("ALANA Intercultural Center", new LatLng(41.68650815716506, -73.8934541417201));
        locMap.put("Alumnae House", new LatLng(41.68879460815983, -73.90017454292531));
        locMap.put("Athletic and Fitness Center", new LatLng(41.68642681640813, -73.8899076361747));
        locMap.put("Blodgett Hall", new LatLng(41.68852603371093, -73.89181478383105));
        locMap.put("Bridge for Laboratory Sciences", new LatLng(41.68450819933851, -73.89698826364398));
        locMap.put("Vogelstein Center", new LatLng(41.68562500506057, -73.89378681482411));
        locMap.put("Chapel", new LatLng(41.68542626363962, -73.89692438253283));
        locMap.put("Class of 1951 Observatory", new LatLng(41.68304972788788, -73.89062345703428));
        locMap.put("College Center", new LatLng(41.6870755256282, -73.89484453569897));
        locMap.put("Ely Hall/Aula", new LatLng(41.68812362098985, -73.8945893571399));
        locMap.put("Ferry House", new LatLng(41.68605917442571, -73.89439797322059));
        locMap.put("Kenyon Hall", new LatLng(41.68956006006064, -73.89095732024113));
        locMap.put("Maria Mitchell Observatory", new LatLng(41.68830932150412, -73.893292921562));
        locMap.put("New England", new LatLng(41.685434825580586, -73.89539035301469));
        locMap.put("Olmsted Hall", new LatLng(41.68476373594768, -73.89584618535156));
        locMap.put("President's House", new LatLng(41.68583336312676, -73.89596047883157));
        locMap.put("Rockefeller Hall", new LatLng(41.687807739876085, -73.89684292054778));
        locMap.put("Sanders Classroom", new LatLng(41.68515003148409, -73.89439086600906));
        locMap.put("Skinner Hall of Music", new LatLng(41.68384268783241, -73.89652498840542));
        locMap.put("Susan Stein Shiva Theater", new LatLng(41.685599073657635, -73.8941043148291));
        locMap.put("Swift Hall", new LatLng(41.68623732256726, -73.89731621870516));
        locMap.put("Terrace Apartments", new LatLng(41.686512307343335, -73.89141123606197));
        locMap.put("The Gordon Commons", new LatLng(41.69032884583028, -73.89552863858941));
        locMap.put("Main Library", new LatLng(41.687375162728145, -73.89764890012808));
        locMap.put("Town Houses", new LatLng(41.6876694505934, -73.90268952032642));
        locMap.put("Walker Field House", new LatLng(41.68538719461441, -73.88982585034508));
        locMap.put("Weinberg Field Sports Pavilion", new LatLng(41.68617358145602, -73.90306781006771));
        return locMap;
    }

    public MapsFragment(ControllerActivity activity) {
        this.activity = activity;
    }

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            EventCollection ec = activity.getEventCollection();
            ArrayList<Event> ecs = ec.getEventCollection();
            for (Event event : ecs) {
                String loc = event.getEventLocation();
                if (locMap.containsKey(loc)) {
                    googleMap.addMarker(new MarkerOptions().position(locMap.get(loc)).title(event.getEventName()));
                }
                LatLng vassar = new LatLng(41.686229, -73.897296);
                googleMap.addMarker(new MarkerOptions().position(vassar).title("Marker in Vassar"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(vassar));
                googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                map = googleMap;
            }
        };
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        this.binding = FragmentMapsBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }

        this.binding.svLocation.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String location = binding.svLocation.getQuery().toString();
                List<Address> addressList = null;

                if (location != null || !location.equals("")) {
                    Geocoder geocoder = new Geocoder(getContext());
                    try {
                        addressList = geocoder.getFromLocationName(location, 1);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Address address = addressList.get(0);
                    LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                    map.addMarker(new MarkerOptions().position(latLng).title(location));
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17));
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}