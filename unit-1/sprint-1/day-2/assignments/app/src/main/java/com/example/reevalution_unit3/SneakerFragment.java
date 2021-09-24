package com.example.reevalution_unit3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SneakerFragment extends Fragment  implements ItemClickListener  {
    private List<ResponseDTO> list = new ArrayList<>();
    private RecyclerView recycleView;
    private ItemClickListener itemClickListener;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sneaker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        navController = Navigation.findNavController(view);
        callApiService();
    }

    private void callApiService() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.getUsers().enqueue(new Callback<List<ResponseDTO>>() {
            @Override
            public void onResponse(Call<List<ResponseDTO>> call, Response<List<ResponseDTO>> response) {
                if(response.body()!= null){
                    list.addAll(response.body());
                    setRecyclerview();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseDTO>> call, Throwable t) {

            }
        });
    }

    private void setRecyclerview() {
        SneakerFragmentAdapter sneakerFragmentAdapter = new SneakerFragmentAdapter(list, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recycleView.setAdapter(sneakerFragmentAdapter);
        recycleView.setLayoutManager(gridLayoutManager);
    }

    private void initView(View view) {

        //recycleView = view.findViewById(R.id.rvRecyclerView);
    }


    @Override
    public void OnItemClick(ResponseDTO responseDTO, int position) {
        Bundle bundle = new Bundle();
        Bitmap image = BitmapFactory.decodeResource(getResources(), Integer.parseInt(responseDTO.getMedia().getImageUrl()));
     //   int image =Integer.parseInt( responseDTO.getMedia().getImageUrl());
         String name = responseDTO.getName().toString();
         String brand = responseDTO.getBrand().toString();
         int  Year = responseDTO.getYear();
        int  Price = responseDTO.getRetailPrice();
        bundle.putParcelable("image", image);
        bundle.putString("name", name);
        bundle.putString("brand", brand);
        bundle.putInt("Year", Year);
        bundle.putInt("Price", Price);
        navController.navigate(R.id.action_sneakerFragment_to_sneakerDetailsFragment, bundle);


    }
}