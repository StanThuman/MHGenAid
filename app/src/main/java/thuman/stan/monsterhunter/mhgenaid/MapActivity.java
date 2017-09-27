package thuman.stan.monsterhunter.mhgenaid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Stan Thuman on 2/7/2016.
 */
public class MapActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        ListView listView = (ListView)findViewById(R.id.map_listview);
        listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, getResources().getStringArray(R.array.map_names)));
    }
}
