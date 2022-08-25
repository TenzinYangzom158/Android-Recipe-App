package gvs.com.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RecipeActivity extends AppCompatActivity {

    FloatingActionButton showYoutube;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenubar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.search:
                search();
                return true;
            case R.id.help:
                showHelp();
                return true;
            case R.id.setting:
                setting();
                return true;
            case R.id.feedback:
                feedback();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void search() {
    }
    private void showHelp(){
    }
    private void setting(){
    }
    private void feedback(){
        Intent i = new Intent(this, FeedbackActivity.class);
        startActivity(i);
    }

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