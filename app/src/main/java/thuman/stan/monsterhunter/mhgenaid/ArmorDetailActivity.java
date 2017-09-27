package thuman.stan.monsterhunter.mhgenaid;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Stan Thuman on 3/14/2016.
 */
public class ArmorDetailActivity extends BaseActivity {

    public final static String ARMOR_ID = "ARMOR TYPE";
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_viewpager);

        //TextView textView = (TextView)findViewById(R.id.armor_detail_textview);
        //textView.setText(getIntent().getExtras().getString(ARMOR_ID));
        //stuff
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        ArmorDetailsAdapter viewAdapter = new ArmorDetailsAdapter(getSupportFragmentManager());
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        viewPager.setAdapter(viewAdapter);
        tabLayout.setupWithViewPager(viewPager);

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);


    }


    public static class ArmornDeatailsFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_armor, container, false);
            //Log.d("ARMOR FRAGMENT", "INSIDE onCreateView()");
            
            return rootView;
        }

    }

    public class ArmorDetailsAdapter extends FragmentPagerAdapter{

        public ArmorDetailsAdapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return newInstance(position);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch(position){
                case 0:
                    return "G Rank";
                case 1:
                    return "High Rank";
                case 2:
                    return "Low Rank";
            }
            return null;
        }

        public ArmornDeatailsFragment newInstance(int sectionNumber){
            Log.d("Armor FRAGMENT", "INSIDE newInstance()");
            ArmornDeatailsFragment fragment = new ArmornDeatailsFragment();

            //used to pass data to the fragment
            Bundle args = new Bundle();
            //args.putInt(SECTION_NUMBER, sectionNumber);

            fragment.setArguments(args);
            return fragment;
        }
    }


}
