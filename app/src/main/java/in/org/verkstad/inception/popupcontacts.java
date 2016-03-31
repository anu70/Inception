package in.org.verkstad.inception;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by anu on 3/21/2016.
 */
public class popupcontacts extends Activity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupcontacts);
        recyclerView = (RecyclerView) findViewById(R.id.contacts_list);
        String[] name = {"Abhishek","Ananya","Ankit","Anu","Apurva","Chetan","Dinesh","Mahita","Ruchita","Prashant","Sakshi"};
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(popupcontacts.this,name);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}
