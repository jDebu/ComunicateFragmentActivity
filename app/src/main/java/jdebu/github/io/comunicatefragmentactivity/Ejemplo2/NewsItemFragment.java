package jdebu.github.io.comunicatefragmentactivity.Ejemplo2;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jdebu.github.io.comunicatefragmentactivity.R;


public class NewsItemFragment extends ListFragment implements AdapterView.OnItemClickListener {
        Activity activity;
        public static List<String> newsHeadlines = new ArrayList<String>(){{
        add("Android Is Awesomerrrrrrrrrrrrrrrrrrr");
        add("A teenager asks Miss America To Prom and gets suspended");
        add("The Congress in The History of the United States is..");
        add("How To Drive Safely When No One else Is.");
        add("Learn How To Program On Your Own");
        add("How To Communicate Between Fragments and Activities");
        add("What to do when you have nothing to do");
        add("The next big thing is here - your awesome app!");
        }};

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            this.activity = activity;
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.simple_row_item, newsHeadlines);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_news_item, container, false);
        }

        @Override
        public void onItemClick(AdapterView< ?> parent, View view, int position, long id) {
        //esta linea
                Toast.makeText(activity, "Clicked Fragment" + position, Toast.LENGTH_LONG).show();
                //o
        try{
        ((OnNewsItemSelectedListener) activity).onNewsItemPicked(position);//referencia cast myactivy o creo una instancia de mi interfaz
        }catch (ClassCastException cce){

        }//hasta aqui
        }

public interface OnNewsItemSelectedListener{
    public void onNewsItemPicked(int position);
}
}