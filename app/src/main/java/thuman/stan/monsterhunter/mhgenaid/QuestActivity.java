package thuman.stan.monsterhunter.mhgenaid;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Stan Thuman on 2/7/2016.
 */
public class QuestActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_viewpager);
        //listView.setAdapter();
        ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);

        viewPager.setAdapter(new QuestPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressbar);
        progressBar.setVisibility(View.INVISIBLE);





    }

    public static class QuestFragment extends Fragment{
        public static final String CLASS_LOG = "NUMBER";
        public static final String FRAGMENT_POSITION = "NUMBER";

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_quest, container, false);
            ListView listView = (ListView)view.findViewById(R.id.quest_listview);
            listView.setAdapter(new QuestAdapter(getContext()));
            int fragmentPosition = getArguments().getInt(FRAGMENT_POSITION);

            //Caravan
            if(fragmentPosition == 0){
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Log.d(CLASS_LOG, position + "");
                    }
                });
            }
            //Gathering Hall
            if(fragmentPosition == 1){
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Log.d(CLASS_LOG, position + "");
                    }
                });
            }
            //return super.onCreateView(inflater, container, savedInstanceState);
            return view;
        }
    }

    public static class QuestAdapter extends BaseAdapter{

        private Context context;
        private static LayoutInflater inflater;
        private static int questNumber = 1;

        private TextView textViewNum;
        private ImageView starHolder;

        public QuestAdapter(Context context){
            this.context = context;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = inflater.inflate(R.layout.layout_quest_row, null);

            textViewNum = (TextView)convertView.findViewById(R.id.quest_row_number_textview);
            starHolder = (ImageView)convertView.findViewById(R.id.quest_row_imageview);

            if(questNumber == 10){
                textViewNum.setText(questNumber + "");
                questNumber = 1;
            }else{
                textViewNum.setText(questNumber + "  ");
                questNumber++;
            }
            starHolder.setImageResource(android.R.drawable.star_big_on);

            return convertView;
        }
    }


    public class QuestPagerAdapter extends FragmentPagerAdapter{

        public QuestPagerAdapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return newInstance(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position){
                case 0:
                    return getResources().getString(R.string.caravan_quests);

                case 1:
                    return getResources().getString(R.string.gathering_hall);
            }

            return super.getPageTitle(position);
        }


        @Override
        public int getCount() {
            return 2;
        }

        public QuestFragment newInstance(int position){
            QuestFragment qFrag = new QuestFragment();
            Bundle args = new Bundle();
            args.putInt(QuestFragment.FRAGMENT_POSITION, position);
            qFrag.setArguments(args);

            return qFrag;
        }
    }

}

