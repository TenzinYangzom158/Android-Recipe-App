package gvs.com.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    // define the variable
    Button loginBtn;
    EditText sendName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.loginBtn);
        sendName = findViewById(R.id.editTextUsername);



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = sendName.getText().toString();
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                i.putExtra("message_key", "Welcome " + strName);
                startActivity(i);
            }
        });


    }

    public void openWebsite(View view) {


        Uri url = Uri.parse("https://www.cokoyam.com/");

        // Parse the URI and create the intent.
//        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, url);
        startActivity(intent);

    }

    public void openLocation(View view) {
        Uri loc = Uri.parse("https://goo.gl/maps/LAuupu4ocLBSUyRN7");
        Intent i = new Intent(Intent.ACTION_VIEW,loc);
        startActivity(i);
        // Parse the location and create the intent.
//        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
//        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
//
//        // Find an activity to handle the intent, and start that activity.
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        } else {
//            Log.d("ImplicitIntents", "Can't handle this intent!");
//        }
    }

    public void whatsapp(View view)
    {
        String no = "+919740001959";
        String message = "Hello";
        startActivity(
                new Intent(Intent.ACTION_VIEW,
                        Uri.parse(String.format("https://api.whatsapp.com/send?phone=%s&text=%s",no,message)))
        );

    }

    public void shareText(View view) {
        String txt = "Welcome to Kitchen Stories!";
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share text with: ")
                .setText(txt)
                .startChooser();

    }

    public void Register(View view) {
        Intent i = new Intent(this, RegistrationActivity.class);
        startActivity(i);
    }


//    public void login(View view) {
//        Intent i = new Intent(this, HomeActivity.class);
//        startActivity(i);
//    }
}