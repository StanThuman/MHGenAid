package thuman.stan.monsterhunter.mhgenaid;

import android.content.Context;
import android.content.Intent;
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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by Stan Thuman on 2/7/2016.
 */
public class MonsterActivity extends BaseActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_viewpager);

        MonsterPagerAdapter monsterAdapter = new MonsterPagerAdapter(getSupportFragmentManager());
        TabLayout tabs = (TabLayout)findViewById(R.id.tab_layout);
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        viewPager.setAdapter(monsterAdapter);
        tabs.setupWithViewPager(viewPager);

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);

    }



    public static class MonsterFragment extends Fragment{


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_monster, container, false);
            GridView gridView = (GridView)rootView.findViewById(R.id.monster_gridview);
            int position = getArguments().getInt(MonsterPagerAdapter.MONSTER_NUMBER);

            switch(position){
                case 0:
                    gridView.setAdapter(new MonsterAdapter());
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                            Log.d("LDKJFLSDKJF", "POSITION LISTENING");
                            Intent myIntent = new Intent(getContext(), MonsterDetailActivity.class);
                            myIntent.putExtra(MonsterDetailActivity.MONSTER_ID, position);
                            startActivity(myIntent);
                        }
                    });
                    break;
            }

            return rootView;
        }

        private class MonsterAdapter extends ArrayAdapter<String>{
            int resId;

            MonsterAdapter(){
                super(getActivity(), R.layout.layout_monster_grid, R.id.monster_textview,
                        getResources().getStringArray(R.array.monster_names));
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View row = super.getView(position, convertView, parent);
                ImageView imageView = (ImageView)row.findViewById(R.id.monster_imageview);

                resId = getResources().getIdentifier("monster_" + position, "drawable", getContext().getPackageName()   );
                ViewHolder holder = (ViewHolder)row.getTag();
                if(holder == null){
                    holder = new ViewHolder(row);
                    row.setTag(holder);
                }

                holder.icon.setImageResource(resId);


                //return super.getView(position, convertView, parent);
                return row;
            }
        }




    }



    public class MonsterPagerAdapter extends FragmentPagerAdapter{

        public static final String MONSTER_NUMBER = "section _number";

        MonsterPagerAdapter(FragmentManager fm){ super(fm);}
        @Override
        public Fragment getItem(int position) {
            return newInstance(position);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position){
                case 0:
                    return getResources().getString(R.string.large_monster);

                case 1:
                    return getResources().getString(R.string.small_monsters);
            }

            return null;
            //return super.getPageTitle(position);
        }

        public Fragment newInstance(int position){
            MonsterFragment frag = new MonsterFragment();
            Bundle args = new Bundle();

            args.putInt(MONSTER_NUMBER, position);
            frag.setArguments(args);


            return frag;
        }


    }
}

