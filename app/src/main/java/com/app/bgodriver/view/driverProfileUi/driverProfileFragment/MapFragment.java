package com.app.bgodriver.view.driverProfileUi.driverProfileFragment;

import static com.app.bgodriver.utilites.Constants.KEY_LOCATION;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.bgodriver.R;
import com.app.bgodriver.databinding.FragmentMapBinding;
import com.app.bgodriver.view.driverProfileUi.PersonalInfoActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class MapFragment extends Fragment {
      private FragmentMapBinding binding;
    private FusedLocationProviderClient client;
    SupportMapFragment supportMapFragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding=FragmentMapBinding.inflate(inflater, container, false);
       initViews();
        supportMapFragment= (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.fragment);
        client=new FusedLocationProviderClient(getActivity());
        checkPermission();
        return binding.getRoot();
    }

    private void checkPermission() {
        Dexter.withContext(getActivity()).withPermission(Manifest.permission.ACCESS_FINE_LOCATION).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                Toast.makeText(getActivity(), "Permission Granted", Toast.LENGTH_SHORT).show();
                getCurrenLocation();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                Intent intent=new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri=Uri.fromParts("package",getActivity().getPackageName(),"");
                intent.setData(uri);
                startActivity(intent);
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();
    }
    @SuppressLint("MissingPermission")
    private void getCurrenLocation() {

        Task<Location> task=client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(@NonNull GoogleMap googleMap) {
                        double latitude=location.getLatitude();
                        double longitude=location.getLongitude();
                        LatLng latLng=new LatLng(latitude,longitude);
                        if (location!=null){
                            try {
                                Geocoder geocoder=new Geocoder(getActivity(),
                                        Locale.getDefault());
                                List<Address> addresses=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                                passLocation(addresses);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        MarkerOptions markerOptions=new MarkerOptions().position(latLng).title("Your Current Location");
                        googleMap.addMarker(markerOptions);
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
                    }
                });

            }
        });

    }

    private void passLocation(List<Address> addresses) {
        binding.mapButton.setOnClickListener(v -> {
            Spanned value= Html.fromHtml(
                    "<font color='#6200EE'><br></font>"
                            +addresses.get(0).getAddressLine(0)
            );
            Intent intent=new Intent(getActivity(), PersonalInfoActivity.class);
            intent.putExtra(KEY_LOCATION,value.toString());
            startActivity(intent);
        });

    }

    private void initViews() {
       /* String name="mas";
        binding.mapButton.setOnClickListener(v -> {
            Intent intent=new Intent(getActivity(), PersonalInfoActivity.class);
            intent.putExtra(KEY_LOCATION,name);
            startActivity(intent);
        });*/
    }
}