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

import java.util.Vector;
public class NewsFragment extends Fragment {

    private Vector<NewsData> news =new Vector<>();
    private RecyclerView newsRecycler;

    public NewsFragment() {
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
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(DataManager.newsData.isEmpty()){
            dataInitialize();
        }

        newsRecycler = view.findViewById(R.id.news_rv);
        newsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        newsRecycler.setHasFixedSize(true);

        NewsAdapter newsAdapter = new NewsAdapter(getContext(), news);
        newsRecycler.setAdapter(newsAdapter);


    }

    private void dataInitialize() {

        news.add(new NewsData
                (R.drawable.celtics, "2023 NBA playoffs scores, results, series schedules: Celtics host 76ers; Nuggets looking for 2-0 lead vs. Suns", "4 hours ago", "Eight teams are left vying for the 2023 NBA title. Four second-round matchups are all in action this week, including 76ers-Celtics and Suns-Nuggets on Monday night. It's Game 1 in Boston with Joel Embiid expected to be sidelined with a knee issue. It's Game 2 in Denver with Kevin Durant and Phoenix trying to even the series.\n" +
                        "Lakers-Warriors is the other series in the West, and that will get started Tuesday after the defending champs ousted the Kings in Game 7 on Sunday. Knicks-Heat kicked off on Sunday at Madison Square Garden with upset-minded Miami taking Game 1.\n" +
                        "Trying to keep up with the NBA playoffs? We have the latest results, as well as series-by-series schedules and streaming info below.\n" +
                        "All times listed are Eastern. Games on ESPN, ABC and NBA TV can be streamed on fuboTV (try for free)."));
        news.add(new NewsData
                (R.drawable.curry, "Steph Curry’s 50-point masterpiece started well before Game 7, with a speech and a promise to his Warriors", "4 hours ago", "Stephen Curry’s epic Game 7 performance — in which his 50 points set a record for a win-or-go-home game — actually began Saturday morning. Well before the Warriors’ 120-100 win over the Kings.\n" +
                        "He was so angry after their Game 6 loss on Friday night, when they squandered a chance to clinch with a spirit-less loss at Chase Center. He was so disgusted by how they played, so disappointed in the division they allowed to seep in. Curry couldn’t sleep.When he gave up trying and got up, before the sun had even risen, he checked his phone and saw a text at 3:45 a.m. Turns out Draymond Green couldn’t sleep either.\n" +
                        "They exchanged messages about their embarrassment, how Kings guard Malik Monk called them old, about the fractured focus they’ve witnessed in their huddle. Green was prepared to speak to the team, to try galvanizing the bunch. But Curry was fed up enough to tell Green, “let me take this one.” That was all Green needed to hear.\n" +
                        "Before the start of Saturday’s film session, Curry stood before the group. In the glass-walled atrium on the ninth floor of Chase Center, a space known as “Above the Rim” that overlooks the Bay, he had their undivided attention.\n" +
                        "“I don’t even talk a lot,” Curry said to the team, “but I’ve got something to say.”\n" +
                        "His speeches are scarce. His pep talks are mostly one-on-one. Teammates consider it rare, but when he does speak, everyone listens explicitly.\n" +
                        "This speech, though, would become part of his legend. The prelude to perfection.\n" +
                        "Even though he’s one of the guys, Curry still has an aura in the Warriors locker room. They see his humility, his jovial nature and approachability. But they know who he is, who they get to play with. His respect is unimpeachable. They recognize a legend in their midst.\n" +
                        "“He is that guy,” Gary Payton II said at his locker after the game. “So when he speaks, everybody better listen. Because 30 is usually quiet and lets his game speak for itself. But he had to say what he had to say, because he knew what type of vibe it was … and I don’t think he wanted to give this one up. So he led and we followed.”\n" +
                        "The reason they listen was on display at the Golden 1 Center on Sunday. In 38 minutes, Curry snatched hope from the Kings. In 38 shots, Curry reminded the world of his greatness."));
    }
}