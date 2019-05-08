package com.xpf.arch_component.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.xpf.arch_component.R;
import com.xpf.arch_component.viewmodel.UserViewModel;

/**
 * Created by x-sir on 2019/5/7 :)
 * Function:
 */
public class LiveDataViewModelActivity extends AppCompatActivity {

    private UserViewModel mUserViewModel;
    private TextView tvUser;
    private Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data_view_model);
        tvUser = findViewById(R.id.tvUser);
        btnChange = findViewById(R.id.btnChange);
        mUserViewModel = new UserViewModel();
        setUserObserver();
        setListener();
    }

    private void setListener() {
        btnChange.setOnClickListener(v -> {
            if (mUserViewModel != null && mUserViewModel.getData() != null) {
                mUserViewModel.changeData();
            }
        });
    }

    private void setUserObserver() {
        //  view model.observe
        mUserViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        mUserViewModel.getData().observe(this, user -> {
            if (user != null) {
                tvUser.setText(user.toString());
            }
        });
    }
}
