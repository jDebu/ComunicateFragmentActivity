package jdebu.github.io.comunicatefragmentactivity.Ejemplo2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import jdebu.github.io.comunicatefragmentactivity.R;


public class MainActivity extends AppCompatActivity implements NewsItemFragment.OnNewsItemSelectedListener
{
    private NewsItemFragment mItemsFragment;

    @Override
    public void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);

        setContentView(R.layout.activity_main);

        //Instantiate some stuff here like view components
        mItemsFragment = new NewsItemFragment();

        //Now you can set the fragment to be visible here
        setFragment(mItemsFragment);
    }

    public void setFragment(Fragment frag)
    {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.findFragmentById(R.id.container) == null) {
            fm.beginTransaction().add(R.id.container, frag).commit();
        }

    }

    //Override the method here
    @Override
    public void onNewsItemPicked(int position)
    {
        //Do something with the position value passed back
        Toast.makeText(this, "Clicked Activity" + position, Toast.LENGTH_LONG).show();

    }
}
// See more at: http://simpledeveloper.com/how-to-communicate-between-fragments-and-activities/#sthash.OnO6iOeK.dpuf
