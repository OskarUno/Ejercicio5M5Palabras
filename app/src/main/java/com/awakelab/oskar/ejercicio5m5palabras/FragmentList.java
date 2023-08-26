package com.awakelab.oskar.ejercicio5m5palabras;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.awakelab.oskar.ejercicio5m5palabras.databinding.FragmentListBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentList extends Fragment {
    private FragmentListBinding binding;
    private List<String> data = new ArrayList<>();
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public FragmentList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentList.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentList newInstance(String param1, String param2) {
        FragmentList fragment = new FragmentList();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(getActivity().getLayoutInflater());
        initRecycler();
        initListener();
        return binding.getRoot();
    }

    private void initListener() {
        binding.floatingActionButton.setOnClickListener(v -> {
           // mParam1 = data.get(data.size());
            data.add("mParam1");
            binding.RecyclerView.getAdapter().notifyItemInserted(data.size());
            binding.RecyclerView.smoothScrollToPosition(data.size());
        });
    }

    private void initRecycler() {
        AdapterWords adapter = new AdapterWords();
        adapter.setData(getData());
        binding.RecyclerView.setAdapter(adapter);
    }

    public List<String> getData() {

        for (int i = 0; i < 20; i++) {
            data.add("word " + i);
        }
        return data;
    }
}