package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myfirstapp.databinding.ActivityNewBinding;

public class NewActivity extends AppCompatActivity {

    private ActivityNewBinding newBinding;
    public String newActivityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        newBinding = ActivityNewBinding.inflate(getLayoutInflater());
        setContentView(newBinding.getRoot());
        Intent intent = getIntent();

        newBinding.textView.setText(intent.getStringExtra("text"));


        newBinding.backButton.setOnClickListener(view -> {

            Intent returnIntent = new Intent();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Hello from the new activity back button.");
            stringBuilder.append(newBinding.editText.getText().toString());
            returnIntent.putExtra("newText", stringBuilder.toString());
            setResult(RESULT_OK, returnIntent);
            finish();



        });


        // Handle the back press in API > Tiramisu
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("newText", "Hello from the new activity.");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);



    }
}