package com.example.midexamproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midexamproject.data.ScheduleData;

import java.util.Vector;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {
    Context ctx;
    static Vector<ScheduleData> scheduleData;
    LinearLayout linearLayout;


    public ScheduleAdapter(Context ctx, Vector<ScheduleData> schedule) {
        this.ctx = ctx;
        this.scheduleData = schedule;
    }


    @NonNull
    @Override
    public ScheduleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.schedule_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleAdapter.ViewHolder holder, int position) {
        ScheduleData scheduleDatas = scheduleData.get(position);

        holder.team1.setText(scheduleDatas.team1);
        holder.team2.setText(scheduleDatas.team2);
//        holder.team1_img.setImageResource(scheduleDatas.team1_img);
//        holder.team2_img.setImageResource(scheduleDatas.team2_img);
        holder.date.setText(scheduleDatas.date);
        holder.time.setText(scheduleDatas.time);
        holder.place.setText(scheduleDatas.place);

        linearLayout.setOnClickListener(v ->{
            Intent intent = new Intent(v.getContext(), ScheduleDetail.class);
            intent.putExtra("team1", scheduleDatas.team1);
            intent.putExtra("team2", scheduleDatas.team2);
            intent.putExtra("team1_img", scheduleDatas.team1_img);
            intent.putExtra("team2_img", scheduleDatas.team2_img);
            intent.putExtra("date", scheduleDatas.date);
            intent.putExtra("time", scheduleDatas.time);
            intent.putExtra("place", scheduleDatas.place);

            ctx.startActivity(intent);

            intent.removeExtra("team1");
            intent.removeExtra("team2");
            intent.removeExtra("team1_img");
            intent.removeExtra("team2_img");
            intent.removeExtra("date");
            intent.removeExtra("time");
            intent.removeExtra("place");
        });
    }

    @Override
    public int getItemCount() {
        return scheduleData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView team1, team2, date, time, place;
        ImageView team1_img, team2_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.schedule_item);
            team1 = itemView.findViewById(R.id.Team1_schedule);
            team2 = itemView.findViewById(R.id.Team2_schedule);
            team1_img = itemView.findViewById(R.id.image_team1);
            team2_img = itemView.findViewById(R.id.image_team2);
            date = itemView.findViewById(R.id.dateSchedule);
            time = itemView.findViewById(R.id.timeSchedule);
            place = itemView.findViewById(R.id.placeSchedule);

        }
    }
}
