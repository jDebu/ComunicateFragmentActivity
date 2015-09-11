package jdebu.github.io.comunicatefragmentactivity.Ejemplo1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import jdebu.github.io.comunicatefragmentactivity.R;

/**
 * Created by jose on 10/09/15.
 */
public class FragmentInsideActivity1 extends Fragment implements View.OnClickListener{
    public void setInteractionFragment(InteractionFragment interactionFragment) {
        this.interactionFragment = interactionFragment;
    }

    private InteractionFragment interactionFragment;

    public static FragmentInsideActivity1 newInstance(){
        FragmentInsideActivity1 fragment = new FragmentInsideActivity1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        //getArguments
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.fragment_blank,container,false);
    }
    @Override
    public  void onActivityCreated(Bundle savedInstance){
        super.onActivityCreated(savedInstance);
        interactionFragment= (InteractionFragment) getActivity();
        //o

        Button button=(Button)getView().findViewById(R.id.enviar);
        button.setOnClickListener(this);

    }
    @Override
    public void onDetach(){
        interactionFragment= null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.enviar:
                //no puedo instanciar el textview del activity entonces uso la interfaz para
                //enviar la data para q se actualize el textview
                interactionFragment.sendFromFragment(this.getClass().getName().toString());
                break;
        }
    }
}
