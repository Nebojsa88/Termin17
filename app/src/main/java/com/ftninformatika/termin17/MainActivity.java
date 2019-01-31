package com.ftninformatika.termin17;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity implements MainFragment.OnItemListClicked {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dodajPrviFragment();
    }


    private void dodajPrviFragment(){

        MainFragment listFragment = new MainFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame1, listFragment);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }




    @Override
    public void listItemClicked(String ime) {
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.podesiIme(ime);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame1, secondFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
