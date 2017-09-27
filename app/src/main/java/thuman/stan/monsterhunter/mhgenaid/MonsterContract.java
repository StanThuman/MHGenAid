package thuman.stan.monsterhunter.mhgenaid;

import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Stan Thuman on 4/27/2016.
 */
public class MonsterContract {

    public MonsterContract(){}

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ", ";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE" + MonsterEntry.TABLE_NAME + " (" +
                    MonsterEntry._ID + " INTEGER PRIMARY KEY," +
                    MonsterEntry.COLUMN_NAME_MONSTER_NAME + TEXT_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_NAME_MONSTER_RANK + TEXT_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_NAME_HEAD + TEXT_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_NAME_NECK + TEXT_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_NAME_BACK + TEXT_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_NAME_BELLY + TEXT_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_NAME_TAIL + TEXT_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_NAME_FRONT_LEGS + TEXT_TYPE + COMMA_SEP +
                    MonsterEntry.COLUMN_NAME_HIND_LEGS + TEXT_TYPE + COMMA_SEP +
                    " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MonsterEntry.TABLE_NAME;

    public static abstract class MonsterEntry implements BaseColumns{
        public static final String TABLE_NAME = "monster";
        public static final String COLUMN_NAME_MONSTER_NAME = "monstername";
        public static final String COLUMN_NAME_MONSTER_RANK = "monsterrank";
        public static final String COLUMN_NAME_HEAD = "head";
        public static final String COLUMN_NAME_NECK = "neck";
        public static final String COLUMN_NAME_BACK = "back";
        public static final String COLUMN_NAME_BELLY = "belly";
        public static final String COLUMN_NAME_TAIL = "tail";
        public static final String COLUMN_NAME_FRONT_LEGS = "frontlegs";
        public static final String COLUMN_NAME_HIND_LEGS = "hindlegs";

    }


}
