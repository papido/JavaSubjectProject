package edu.utem.ftmk.projectnative.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import edu.utem.ftmk.projectnative.Domain.User;
import edu.utem.ftmk.projectnative.R;
import edu.utem.ftmk.projectnative.databinding.ActivityIntroBinding;
import edu.utem.ftmk.projectnative.sqliteDatabase.DatabaseUser;

public class IntroActivity extends AppCompatActivity {
ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String username = binding.edtUsername2.getText().toString();
        String password = binding.edtPw2.getText().toString();
        DatabaseUser dbUser = new DatabaseUser(IntroActivity.this);

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dbUser.checkUser(username,password)) {
                    startActivity(new Intent(IntroActivity.this, MainActivity.class));
                } else
                    Toast.makeText(IntroActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
            }
        });

        binding.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this, RegisterActivity.class));
            }
        });

        Window window=IntroActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(IntroActivity.this, R.color.purple));
    }
}