package thuman.stan.monsterhunter.mhgenaid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Stan Thuman on 2/6/2016.
 */
public class WeaponActivity extends BaseActivity implements AdapterView.OnItemClickListener{

    String[] weaponItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon);
        setAdapter();
    }

    private void setAdapter(){
        weaponItems = getResources().getStringArray(R.array.weapons);
        ListView listView = (ListView)findViewById(R.id.weapon_list_view);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, weaponItems));

        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, WeaponDetailActivity.class);
        int selectedWeaponID= position;
        intent.putExtra(WeaponDetailActivity.WEAPON_ID, selectedWeaponID);
        startActivity(intent);
    }
}
