package com.SIAP.Activity;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.SIAP.BDD.SQLite.GestionBD;
import com.SIAP.R;


public class formulaireparcActivity extends Activity{//On peut passer par une ListActivity, a voir les avantages
    GestionBD bd = new GestionBD(this);

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulaireparc);
       ListView formParc = (ListView)findViewById(R.id.list);

        bd.read();
        Cursor c = bd.RecupererToutUser();
        startManagingCursor(c);

        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.affichageuser, c, new String[]{"nom_agent", "mdp_agent"},
                new int[] {R.id.TxTid, R.id.TxTmdp});


        String[] mStrings = {
                "Nikola", "Marceau", "Pablo", "Jimmy", "Quentin",
                "Antoine", "Damien", "Julien", "Antonin", "Simon",
                "Hugo", "Mysko", "Guyliane", "Octave", "OOOOOOOO",
                "PPPPPPPP", "QQQQQQQQ", "RRRRRRRR", "SSSSSSSS", "TTTTTTTT",
                "UUUUUUUU", "VVVVVVVV", "WWWWWWWW", "XXXXXXXX", "YYYYYYYY",
                "PPPPPPPP", "QQQQQQQQ", "RRRRRRRR", "SSSSSSSS", "TTTTTTTT",
                "UUUUUUUU", "VVVVVVVV", "WWWWWWWW", "XXXXXXXX", "YYYYYYYY",
                "ZZZZZZZZ", "AAAAAAAAAA", "AAAAAAAAAA","AAAAAAAAAA","AAAAAAAAAA","AAAAAAAAAA","AAAAAAAAAA","AAAAAAAAAA",
                "AAAAAAAAAA","AAAAAAAAAA","AAAAAAAAAA","AAAAAAAAAA","AAAAAAAAAA","AAAAAAAAAA","AAAAAAAAAA","AAAAAAAAAA",
                "AAAAAAAAAA","AAAAAAAAAA","AAAAAAAAAA","AAAAAAAAAA","AAAAAAAAAA","AAAAAAAAAA","AAAAAAAAAA","AAAAAAAAAA",
        };


        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.formulairetexteview, R.id.textview, mStrings);
       formParc.setAdapter(mAdapter);
        bd.close();
    }
    }

