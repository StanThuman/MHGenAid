package thuman.stan.monsterhunter.mhgenaid;

import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;


/**
 * Created by Stan Thuman on 2/7/2016.
 */
public class ArmorActivity extends BaseActivity {

    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_viewpager);

        TabLayout tabs = (TabLayout)findViewById(R.id.tab_layout);


        //assign fragmentManager to my adapter
        ArmorAdapter viewAdapter = new ArmorAdapter(getSupportFragmentManager());
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        viewPager.setAdapter(viewAdapter);
        tabs.setupWithViewPager(viewPager);

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);


    }


    public static class ArmorFragment extends Fragment {

        final static String bArmorList[] = {"Blade Armor 1", "Blade Armor 2", "Blade Armor 3"};
        final static String gArmorList[] = {"Gunner Armor 1", "Gunner Armor 2", "Gunner Armor 3"};
        static String selectedArmorList[];


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_armor, container, false);

            int position = getArguments().getInt(ArmorAdapter.SECTION_NUMBER);

            ListView listView = (ListView) rootView.findViewById(R.id.list_armor_view);

            loadArmorList(position, listView);
            return rootView;
        }

        public void loadArmorList(int position, ListView listView) {

            switch (position) {
                case 0:
                    listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, bArmorList));
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getContext(), ArmorDetailActivity.class);
                            String armorType;
                            armorType = bArmorList[position];
                            intent.putExtra(ArmorDetailActivity.ARMOR_ID, armorType);
                            startActivity(intent);
                        }
                    });

                    break;

                case 1:
                    listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, gArmorList));
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getContext(), ArmorDetailActivity.class);
                            String armorType;
                            armorType = gArmorList[position];
                            intent.putExtra(ArmorDetailActivity.ARMOR_ID, armorType);
                            startActivity(intent);
                        }
                    });
                    break;
            }
        }
    }


    //used to insert child views into your viewpager
    public class ArmorAdapter extends FragmentPagerAdapter {

        public static final String SECTION_NUMBER = "section _number";
        public ArmorAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return newInstance(position);
        }

        //total number of fragments
        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position){

                case 0:
                    return getResources().getString(R.string.blademaster);

                case 1:
                    return getResources().getString(R.string.gunner);
            }
            //return super.getPageTitle(pageTitles[position]);
            return null;
        }

        //creates fragment and assigns it an args bundle
        public ArmorFragment newInstance(int sectionNumber){
            ArmorFragment fragment = new ArmorFragment();

            //used to pass data to the fragment
            Bundle args = new Bundle();
            args.putInt(SECTION_NUMBER, sectionNumber);

            fragment.setArguments(args);
            return fragment;
        }
    }


}
