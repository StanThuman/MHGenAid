package thuman.stan.monsterhunter.mhgenaid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Stan Thuman on 4/23/2016.
 */
public class MonsterDetailActivity extends BaseActivity {
    private static final String ACTIVITY_LOG = "MonsterDetailActivity";
    public static String MONSTER_ID = "Monster Id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_monsterdetail);
        int monsterID = getIntent().getExtras().getInt(MONSTER_ID);
        TextView textView = (TextView)findViewById(R.id.tView);
        textView.setText(monsterID + "");

//        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        int monsterId = getIntent().getExtras().getInt(MONSTER_ID);
//        Log.d(ACTIVITY_LOG, monsterId + "" );
//        viewPager.setAdapter(new MonsterDetailAdapter(getSupportFragmentManager(), monsterId));
//        tabLayout.setupWithViewPager(viewPager);
//
//        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
//        progressBar.setVisibility(View.INVISIBLE);
    }

//    public static class MonsterDetailsFragment extends Fragment{
//        public static String MONSTER_ID = "monsterID";
//
//        @Nullable
//        @Override
//        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_monsterdetail, container, false);
//            TextView tView = (TextView)rootView.findViewById(R.id.tView);
//
//            int monsterId = getArguments().getInt(MONSTER_ID);
//            Log.d("Monster Details", monsterId + "");
//            return rootView;
//        }
//    }

//    public class MonsterDetailAdapter extends FragmentPagerAdapter{
//        private int monsterId;
//        public MonsterDetailAdapter(FragmentManager fm, int monsterId){
//            super(fm);
//            this.monsterId = monsterId;
//
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return newInstance(position);
//        }
//
//        @Override
//        public int getCount() {
//            return 3;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            String tabTitle;
//            switch(position){
//                case 0:
//                    tabTitle = getResources().getString(R.string.grank);
//                    return tabTitle;
//                case 1:
//                    tabTitle = getResources().getString(R.string.highrank);
//                    return tabTitle;
//                case 2:
//                    tabTitle = getResources().getString(R.string.lowrank);
//                    return tabTitle;
//            }
//            return null;
//        }
//
//        private MonsterDetailsFragment newInstance(int position) {
//            Bundle newArgs = new Bundle();
//            newArgs.putInt(MonsterDetailsFragment.MONSTER_ID, monsterId);
//            MonsterDetailsFragment monsterFragment = new MonsterDetailsFragment();
//            monsterFragment.setArguments(newArgs);
//
//            return monsterFragment;
//        }
//    }




}
