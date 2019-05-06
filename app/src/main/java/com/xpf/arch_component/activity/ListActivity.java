package com.xpf.arch_component.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.xpf.arch_component.R;

public class ListActivity extends AppCompatActivity {

    private Button btnLiveDataViewModel;
    private Button btnLifecycle;
    private Button btnMvpLifecycle;
    private Button btnRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        btnLiveDataViewModel = findViewById(R.id.btnLiveDataViewModel);
        btnLifecycle = findViewById(R.id.btnLifecycle);
        btnMvpLifecycle = findViewById(R.id.btnMvpLifecycle);
        btnRoom = findViewById(R.id.btnRoom);

        btnLiveDataViewModel.setOnClickListener(v -> startActivity(LiveDataViewModelActivity.class));
        btnLifecycle.setOnClickListener(v -> startActivity(LifecycleActivity.class));
        btnMvpLifecycle.setOnClickListener(v -> startActivity(MvpLifecycleActivity.class));
        btnRoom.setOnClickListener(v -> startActivity(RoomActivity.class));
    }

    private void startActivity(Class<?> clazz) {
        startActivity(new Intent(ListActivity.this, clazz));
    }
}
