package com.example.midexamproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.midexamproject.data.DataManager;
import com.example.midexamproject.data.NewsData;
import com.example.midexamproject.data.ScheduleData;

import java.util.Vector;

public class ScheduleFragment extends Fragment {

    private Vector<ScheduleData> scheduleData =new Vector<>();
    private RecyclerView scheduleRecycler;
    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(DataManager.scheduleData.isEmpty()){
            dataInitialize();
        }

        scheduleRecycler = view.findViewById(R.id.schedule_rv);
        scheduleRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        scheduleRecycler.setHasFixedSize(true);

        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(getContext(), scheduleData);
        scheduleRecycler.setAdapter(scheduleAdapter);

    }

    private void dataInitialize() {
        scheduleData.add(
                new ScheduleData
                        ("Bina Kasih", "Xaverius 1", "2 Mei 2023", "7 PM", "Binus Hall Syahdan", R.drawable.teamlogobasket, R.drawable.binakasih));
    }

}