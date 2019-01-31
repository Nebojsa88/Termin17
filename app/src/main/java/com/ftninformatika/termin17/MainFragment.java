package com.ftninformatika.termin17;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainFragment extends Fragment {

        String imena[] = new String[]{"Pera", "Mika", "Zika"};

        ListView lvImena;
        OnItemListClicked listener;


        public interface OnItemListClicked {
            void listItemClicked(String ime);
        }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            listener = (OnItemListClicked) activity;

        }catch (ClassCastException e){
            Toast.makeText(activity, "Zao nam je", Toast.LENGTH_SHORT).show();

        }

        }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.linear_fragment, container, false);

    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvImena = getView().findViewById(R.id.lvimena);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, imena);
        lvImena.setAdapter(adapter);
        lvImena.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                listener.listItemClicked(imena[position]);

            }
        });
    }
}
