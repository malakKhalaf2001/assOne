package ass.bzu;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LessonsActivity extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;

    private Spinner sp1;
    private Spinner sp2;
    private Spinner sp3;

    private Button b;
    private Button b2;

    private Animation fadeInAnimation;

    private List<QA> qalist;
    private RecyclerView recyclerView;
    private QAAdapter adapter;

    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_QUESTION1 = "question1";
    private static final String KEY_QUESTION2 = "question2";
    private static final String KEY_QUESTION3 = "question3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        tv1 = findViewById(R.id.question1);
        tv2 = findViewById(R.id.question2);
        tv3 = findViewById(R.id.question3);

        sp1 = findViewById(R.id.answer1_spinner);
        sp2 = findViewById(R.id.answer2_spinner);
        sp3 = findViewById(R.id.answer3_spinner);

        b = findViewById(R.id.answer1);
        b2 = findViewById(R.id.answer2);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        qalist = new ArrayList<>();
        adapter = new QAAdapter(qalist);
        recyclerView.setAdapter(adapter);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        loadData();

        b.setOnClickListener(e -> {
            String answer0 = sp1.getSelectedItem().toString();
            String answer1 = sp2.getSelectedItem().toString();
            String answer2 = sp3.getSelectedItem().toString();

            if ((answer0.equals(qalist.get(0).getAns()) && answer1.equals(qalist.get(1).getAns()))
                    || (answer0.equals(qalist.get(0).getAns()) && answer2.equals(qalist.get(2).getAns()))
                    || (answer1.equals(qalist.get(1).getAns()) && answer2.equals(qalist.get(2).getAns()))) {
                Toast.makeText(LessonsActivity.this, "Correct", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LessonsActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(e -> {
            loadData();
        });

        fadeInAnimation = AnimationUtils.loadAnimation(LessonsActivity.this, R.anim.fade_in);
        tv1.startAnimation(fadeInAnimation);
        tv2.startAnimation(fadeInAnimation);
        tv3.startAnimation(fadeInAnimation);
    }

    private void loadData() {
        AddQ addQ = new AddQ();
        QA[] QAARR = addQ.getRandomQuestions(3);

        qalist.clear();
        qalist.add(new QA(QAARR[0].getQuestion(), QAARR[0].getAns()));
        qalist.add(new QA(QAARR[1].getQuestion(), QAARR[1].getAns()));
        qalist.add(new QA(QAARR[2].getQuestion(), QAARR[2].getAns()));

        adapter.notifyDataSetChanged();

        tv1.setText(QAARR[0].getQuestion());
        tv2.setText(QAARR[1].getQuestion());
        tv3.setText(QAARR[2].getQuestion());

        ArrayAdapter<String> answer1Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        answer1Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(answer1Adapter);

        ArrayAdapter<String> answer2Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        answer2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(answer2Adapter);

        ArrayAdapter<String> answer3Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        answer3Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp3.setAdapter(answer3Adapter);


        for (QA qa : qalist) {
            answer1Adapter.add(qa.getAns());
            answer2Adapter.add(qa.getAns());
            answer3Adapter.add(qa.getAns());
        }
    }


}
