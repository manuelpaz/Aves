package com.example.casa.aves;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.casa.aves.dummy.Lista_contenido;

/**
 * A fragment representing a single Ave detail screen.
 * This fragment is either contained in a {@link AveListActivity}
 * in two-pane mode (on tablets) or a {@link AveDetailActivity}
 * on handsets.
 */
public class AveDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy textoEncima this fragment is presenting.
     */
    private Lista_contenido.Lista_entrada mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AveDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy textoEncima specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load textoEncima from a textoEncima provider.
            mItem = Lista_contenido.ENTRADAS_LISTA_HASHMAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.textoEncima);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ave_detail, container, false);

            //Mostramos el contenido al usuario
            if (mItem != null) {
                ((TextView) rootView.findViewById(R.id.textView_superior)).setText(mItem.textoEncima);
                ((TextView) rootView.findViewById(R.id.textView_inferior)).setText(mItem.textoDebajo);
                ((ImageView) rootView.findViewById(R.id.imageView_imagen)).setImageResource(mItem.idImagen);
            }
        return rootView;
    }
}
