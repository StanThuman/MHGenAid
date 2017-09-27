package thuman.stan.monsterhunter.mhgenaid;

import android.content.ContentValues;
import android.os.Bundle;

/**
 * Created by Stan Thuman on 2/7/2016.
 */
public class UpdateActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        addDbValues();
    }

    public void addDbValues(){
        MonsterDbHelper monsterDbHelper = new MonsterDbHelper(getApplicationContext());
        ContentValues contentValues = new ContentValues();
        contentValues.put(MonsterContract.MonsterEntry.COLUMN_NAME_MONSTER_NAME, "Akantor");
        contentValues.put(MonsterContract.MonsterEntry.COLUMN_NAME_MONSTER_RANK, "Akantor");
        contentValues.put(MonsterContract.MonsterEntry.COLUMN_NAME_HEAD, "Akantor");
        contentValues.put(MonsterContract.MonsterEntry.COLUMN_NAME_NECK, "Akantor");
        contentValues.put(MonsterContract.MonsterEntry.COLUMN_NAME_BACK, "Akantor");
        contentValues.put(MonsterContract.MonsterEntry.COLUMN_NAME_BELLY, "Akantor");
        contentValues.put(MonsterContract.MonsterEntry.COLUMN_NAME_TAIL, "Akantor");
        contentValues.put(MonsterContract.MonsterEntry.COLUMN_NAME_FRONT_LEGS, "Akantor");
        contentValues.put(MonsterContract.MonsterEntry.COLUMN_NAME_HIND_LEGS, "Akantor");

    }
}
