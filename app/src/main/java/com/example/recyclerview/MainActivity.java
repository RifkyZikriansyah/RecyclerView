package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecylerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Song> songList;
    private SongAdapter songAdapter;

    String[] names = {"I Took A Pill In Ibiza", "7 years", "Pillow Talk", "Work From Home", "Never Forget You", "Don't Let Me Down",
            "Love YourSelf", "Me, MySelf & I", "Cake By The Ocean", "Dangerous Woman", "My House", "Stressed Out", " One Dance"
            , "Middle", "No"};

    String[] singers = {"Mike Posner", "Lukas Graham", "Zayn", "Fifth Harmony", "Zzara Lasson & MNEK", "The Chainsmokers",
            "Justin Bieber", "G-Eazy x Bebe Rexha", "DNCE", "Ariane Grande", "Florida", "Twenty One Pilots", " Drake"
            , "DJ Snake", "Meghan Trainer"};

    int[] pics = {
            R.drawable.took_a_pill,
            R.drawable.seven_years,
            R.drawable.pillow_talk,
            R.drawable.work,
            R.drawable.never_forget_you,
            R.drawable.dont_let_me_down,
            R.drawable.love_yourself,
            R.drawable.me_myself_and_i,
            R.drawable.cake_by_the_ocean,
            R.drawable.dangerous_woman,
            R.drawable.my_house_florida,
            R.drawable.stressed_out,
            R.drawable.one_dance,
            R.drawable.middle,
            R.drawable.no,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecylerView = (RecyclerView) findViewById(R.id.recycler_view);

        //settings untuk improve performance
        //content tdk dapat mengubah size layout recyclerview
        if (mRecylerView != null) {
            mRecylerView.setHasFixedSize(true);
        }
        //using a linear layoyut
        mLayoutManager = new LinearLayoutManager(this);
        mRecylerView.setLayoutManager(mLayoutManager);

        //intiatilizing an arayList called SOnglist
        songList = new ArrayList<>();

        //add song list
        for (int i = 0; i < names.length; i++) {
            Song song = new Song(names[i], singers[i], i + 1, pics[i]);
            songList.add(song);
        }
        //intializing adapter
        songAdapter = new SongAdapter(songList);

        //specifiying an adapter to acces data, create views and replace the content
        mRecylerView.setAdapter(songAdapter);
        songAdapter.notifyDataSetChanged();

        mRecylerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Card at " + position + "is Clicked", Toast.LENGTH_SHORT).show();
            }

        }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_grid:
                //use this in case of gridlayoutmanager
                mLayoutManager = new GridLayoutManager(this, 2);
                mRecylerView.setLayoutManager(mLayoutManager);
                break;
            case R.id.item_staggered_grid:
                //use  this in case of staggered GridLayoutManager
                mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                mRecylerView.setLayoutManager(mLayoutManager);
                break;
            case R.id.item_horizontal:
                //horizontal linear layout
                mLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                mRecylerView.setLayoutManager(mLayoutManager);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


