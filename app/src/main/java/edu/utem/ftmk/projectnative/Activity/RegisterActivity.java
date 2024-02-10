package edu.utem.ftmk.projectnative.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import edu.utem.ftmk.projectnative.Domain.User;
import edu.utem.ftmk.projectnative.databinding.ActivityRegisterBinding;
import edu.utem.ftmk.projectnative.sqliteDatabase.DatabaseUser;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String username = binding.edtUsername.getText().toString();
        String password = binding.edtpw.getText().toString();
        User user = new User(1, username, password);
        DatabaseUser dbUser = new DatabaseUser(RegisterActivity.this);

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbUser.addUser(user);
                Toast.makeText(RegisterActivity.this, "You are registered", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
