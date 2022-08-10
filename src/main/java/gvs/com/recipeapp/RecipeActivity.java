package gvs.com.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RecipeActivity extends AppCompatActivity {

    FloatingActionButton showYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        showYoutube = (FloatingActionButton) findViewById(R.id.webviewFAB);
        showYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RecipeActivity.this, WebviewActivity.class);
                startActivity(i);
            }
        });

    }

    public void Back(View view) {
        Intent intent = new Intent(RecipeActivity.this, HomeActivity.class);
        startActivity(intent);
    }


}