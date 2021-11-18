package com.example.heybaby;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.heybaby.Fragment.fragment_favorite;
import com.example.heybaby.Fragment.fragment_home;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static final int FRAGMENT_TRANG_CHINH = 0;
    private static final int FRAGMENT_FARORITE = 1;
    private static final int FRAGMENT_LOGIN = 2;
    private static final int FRAGMENT_GIO_HANG = 3;

    private int mCurrentFragment = FRAGMENT_TRANG_CHINH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = this.findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemReselectedListener);
        replaceFragment(new fragment_home());
        bottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);

    }


    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemReselectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();
                    if (id == R.id.action_home){
                        if (mCurrentFragment != FRAGMENT_TRANG_CHINH){
                            replaceFragment(new fragment_home());
                            mCurrentFragment = FRAGMENT_TRANG_CHINH;
                        }
                    }else if (id == R.id.action_favorite){
                        if (mCurrentFragment != FRAGMENT_FARORITE){
                            replaceFragment(new fragment_favorite());
                            mCurrentFragment = FRAGMENT_FARORITE;
                        }
                    }

                    return true;
                }
            };

    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framr_layout, fragment);
        transaction.commit();
    }
}