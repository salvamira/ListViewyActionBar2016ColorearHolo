package net.somtic.listviewactionbar;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private static final String[] items = {"En", "un", "lugar", "de", "la", "Mancha",
            "de", "cuyo", "nombre", "no", "quiero", "acordarme", "no", "ha", "mucho",
            "tiempo", "que", "vivía", "un", "hidalgo", "de", "los", "de", "lanza",
            "en", "astillero", "adarga", "antigua", "rocín", "flaco", "y", "galgo",
            "corredor"};

    private ArrayAdapter<String> adaptador = null;
    private ArrayList<String> palabras = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inicializaAdaptador();
    }

    private void inicializaAdaptador() {
        palabras = new ArrayList<String>();
        for (int i=0;i<6;i++) {
            palabras.add(items[i]);
        }
        adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                palabras);
        setListAdapter(adaptador);
    }

    private void anyadePalabra() {
        if (adaptador.getCount()<items.length) {
            adaptador.add(items[adaptador.getCount()]);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId()) {
            case R.id.anyadir:
                anyadePalabra();
                return(true);
            case R.id.reset:
                inicializaAdaptador();
                return(true);
            case R.id.acercade:
                Toast.makeText(this, R.string.acerca_toast, Toast.LENGTH_LONG)
                        .show();
                return(true);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return(super.onCreateOptionsMenu(menu));
    }
}
