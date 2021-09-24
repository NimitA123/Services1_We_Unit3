package com.example.reevalution_unit3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SneakerDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SneakerDetailsFragment extends Fragment implements  ItemCickListener1 {
    private ImageView img;
    private TextView tv;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private Bitmap img1;
    private String name;
    private String brand;
    private int year;
    private int price;
    private NavController navController;
    private LinearLayout linearLayout;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SneakerDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SneakerDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SneakerDetailsFragment newInstance(String param1, String param2) {
        SneakerDetailsFragment fragment = new SneakerDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
           img1 = getArguments().getParcelable("image");
            name = getArguments().getString("name");
            brand = getArguments().getString("brand");
            year = getArguments().getInt("Year");
            price = getArguments().getInt("Price");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sneaker_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        initView(view);
    }

    private void initView(View view) {
        img = view.findViewById(R.id.imageView);
        tv = view.findViewById(R.id.Name);
        tv1 = view.findViewById(R.id.brand);
        tv2 = view.findViewById(R.id.Years);
        tv3 = view.findViewById(R.id.Price);
        linearLayout = view.findViewById(R.id.linearLayout);
        setData();
    }

    private void setData() {
     img.setImageBitmap(img1);
       tv.setText(name);
       tv1.setText(brand);
       tv2.setText(year+" ");
       tv3.setText(price+" ");
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
        navController.navigate(R.id.action_sneakerDetailsFragment_to_checkOutFragment, bundle);
    }
}