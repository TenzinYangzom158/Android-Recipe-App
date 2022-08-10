package gvs.com.recipeapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.google.android.material.snackbar.Snackbar;

public class RegistrationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] users = {"Personal", "Work", "College", "Home", "Others"};

    ToggleButton toggleButton;
    TextView textView;
    SwitchCompat switchCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Spinner spin = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);

        // Register Button
        Button button = findViewById(R.id.registerBtn);
//        button.setOnClickListener(this);

        toggleButton = findViewById(R.id.toggleBtn);
        textView = findViewById(R.id.textView);
        switchCompat = findViewById(R.id.switchNotification);


        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    textView.setText("Bluetooth is " + toggleButton.getTextOn());
                }
                else
                {
                    textView.setText("Bluetooth is " + toggleButton.getTextOff());
                }
            }
        });

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Snackbar.make(buttonView, "Notification checked "+isChecked, Snackbar.LENGTH_LONG)
                        .setAction("ACTION",null).show();
            }
        });
    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), "Selected Email: " + users[position], Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO - Custom Code
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerBtn:
                alertDialog();
                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);
                break;
        }
    }

    private void alertDialog() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Thank you for registering.");
        dialog.setTitle("Registration Successful!");
        dialog.setPositiveButton("Close",
                (dialog1, which) -> Toast.makeText(getApplicationContext(), "Registered Successful!", Toast.LENGTH_LONG).show());
//        dialog.setNegativeButton("cancel",
//                (dialog12, which) -> Toast.makeText(getApplicationContext(), "cancel is clicked", Toast.LENGTH_LONG).show());
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }


}