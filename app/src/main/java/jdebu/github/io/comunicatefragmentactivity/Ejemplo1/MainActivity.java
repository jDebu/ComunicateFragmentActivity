package jdebu.github.io.comunicatefragmentactivity.Ejemplo1;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import jdebu.github.io.comunicatefragmentactivity.R;

/**
 * Created by jose on 10/09/15.
 */
public class MainActivity extends AppCompatActivity implements InteractionFragment{
    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);
        FrameLayout containerFragment = (FrameLayout) findViewById(R.id.containerFragment);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFragment, FragmentInsideActivity1.newInstance())
                .commit();
        //FragmentInsideActivity1.newInstance().setInteractionFragment((InteractionFragment)this);
        //q pasaria si fuera FragmentActivity
    }

    @Override
    public void sendFromFragment(String msg) {
        Log.e(null,msg);
        ((TextView)findViewById(R.id.dataFromFragment)).setText(msg);
    }
    //a ver otto
    //a ver gson
    //http://www.hermosaprogramacion.com/2015/01/android-json-parsing/
    //http://www.proyectosimio.com/es/programacion-android-gson-libreria-para-parsear-documentos-json/
}
