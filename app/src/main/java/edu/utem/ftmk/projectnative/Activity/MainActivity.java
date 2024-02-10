package edu.utem.ftmk.projectnative.Activity;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import edu.utem.ftmk.projectnative.Adapter.CourseAdapter;
import edu.utem.ftmk.projectnative.Domain.CourseDomain;
import edu.utem.ftmk.projectnative.R;
import edu.utem.ftmk.projectnative.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initRecyclerView();

        Window window=MainActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.white));
    }

    private void initRecyclerView() {
        ArrayList<CourseDomain> itemsArraylist = new ArrayList<>();

        itemsArraylist.add(new CourseDomain("Quick Learn C# Language", "Jamie young", 130, 4.8, "pic1"));
        itemsArraylist.add(new CourseDomain("Full Course Android Kotlin", "Alex Alba", 450, 4.6, "pic2"));
        itemsArraylist.add(new CourseDomain("Quick Learn Java Language", "Sara Anderson", 200, 4.3, "pic1"));

        binding.popularView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.popularView.setAdapter(new CourseAdapter(itemsArraylist));

    }
}
