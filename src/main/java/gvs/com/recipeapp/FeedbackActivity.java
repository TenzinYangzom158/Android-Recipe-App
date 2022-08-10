package gvs.com.recipeapp;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class FeedbackActivity extends AppCompatActivity {

    RatingBar rateStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        rateStar = findViewById(R.id.ratingBar);
        LayerDrawable stars = (LayerDrawable) rateStar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);

    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.CB1:
            case R.id.CB2:
            case R.id.CB3:
            case R.id.CB4:
                if (checked)
                    Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    public void onSubmit(View view) {
        Snackbar snackbar = Snackbar.make(view, "Feedback Submitted!", Snackbar.LENGTH_LONG).setActionTextColor(Color.RED)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(view, "Feedback is restored!", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });
        snackbar.show();
    }
}