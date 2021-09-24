package com.example.evalution_1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

   private RecyclerView recyclerView;
   private List<NowShowingModel> arrayList = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           // mParam1 = getArguments().getString(ARG_PARAM1);
          //  mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recylerView);
        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.getListOfPages().enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
               if(response.body().getNowShowing()!= null)
                arrayList.addAll(response.body().getNowShowing());
              //  Log.d("Nimit1", "Nimit");
                setRecycleView();
                Log.d("Nimit1", "Nimit");
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getContext(), "Response Fails", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setRecycleView() {

       HomeFragmentAdapter homeFragmentAdapter = new HomeFragmentAdapter(arrayList);
       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
       recyclerView.setAdapter(homeFragmentAdapter);
       recyclerView.setLayoutManager(linearLayoutManager);

    }
}