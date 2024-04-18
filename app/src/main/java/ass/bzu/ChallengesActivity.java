package ass.bzu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChallengesActivity extends AppCompatActivity {

    private ListView challengesListView;
    private String[] challenges = {"Challenge 1", "Challenge 2", "Challenge 3", "Challenge 4", "Challenge 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);

        // Initialize ListView
        challengesListView = findViewById(R.id.challenges_list_view);

        // Create ArrayAdapter to populate ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, challenges);
        challengesListView.setAdapter(adapter);

        // Set click listener for ListView items
        challengesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item click event
                String selectedChallenge = challenges[position];
                // You can open a new activity to display details of the selected challenge
                Intent intent = new Intent(ChallengesActivity.this, ChallengeDetailActivity.class);
                intent.putExtra("challenge", selectedChallenge);
                startActivity(intent);
            }
        });
    }
}
