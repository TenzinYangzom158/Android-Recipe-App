package gvs.com.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    TextView receivedName;
//    CardView card1 = findViewById(R.id.card1);
    ImageView img1;

    // FAB - Floating Action Button
    FloatingActionButton mAddFab, mAddFeedback;
    Boolean isAllFabVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        For displaying Welcome Message
        receivedName = findViewById(R.id.receivedName);

        // create the get Intent object
        Intent i = getIntent();
        String str = i.getStringExtra("message_key");
        receivedName.setText(str);

        mAddFab = findViewById(R.id.addFab);
        mAddFeedback = findViewById(R.id.feedbackFab);

        mAddFeedback.setVisibility(View.GONE);
        isAllFabVisible = false;

        mAddFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isAllFabVisible){
                    mAddFeedback.show();
                    isAllFabVisible = true;
                }
                else{
                    mAddFeedback.hide();
                    isAllFabVisible = false;
                }
            }
        });

        // Action to handle add FAB
        mAddFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, FeedbackActivity.class);
                startActivity(i);
            }
        });


//        card1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, RecipeActivity.class);
//                startActivity(intent);
//            }
//        });


        // initialize imageView
        img1 = findViewById(R.id.kimbapImg);

        // Apply OnClickListener  to imageView to
        // switch from one activity to another
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, RecipeActivity.class);
                startActivity(intent);
            }
        });

    }
}