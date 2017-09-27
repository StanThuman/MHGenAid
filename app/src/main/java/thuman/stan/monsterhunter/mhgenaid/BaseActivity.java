package thuman.stan.monsterhunter.mhgenaid;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

//provides base layout for all activities
public class BaseActivity extends AppCompatActivity {

    private static int previousId = 10;
    @Override
    public void setContentView(int layoutResID) {

        DrawerLayout drawerLayout = (DrawerLayout)getLayoutInflater().inflate(R.layout.activity_main, null);
        FrameLayout frameLayout = (FrameLayout)drawerLayout.findViewById(R.id.baselayout);
        getLayoutInflater().inflate(layoutResID, frameLayout, true);
        super.setContentView(drawerLayout);


        setUpActionBarAndDrawerToggle();
    }

    @Override
    public void onBackPressed() {
        //closes drawer on backbutton press if it's open
        //otherwise, exit app
        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    private void setUpActionBarAndDrawerToggle(){
        //overrides default toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //assign drawer button toggle to toolbar
        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        setUpNavigationDrawer(drawerLayout);
    }

    //sets up the listener for navigation view of drawer
    private void setUpNavigationDrawer(final DrawerLayout drawerLayout){

        final NavigationView navView = (NavigationView)findViewById(R.id.nav_view);

        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        int id = item.getItemId();
                        Intent intent = new Intent();
                        //no repetitive back stack
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        switch (id) {
                            case R.id.nav_update:
                                intent.setClass(BaseActivity.this, UpdateActivity.class);
                                startActivity(intent);
                                break;

                            case R.id.nav_weapon:
                                intent.setClass(BaseActivity.this, WeaponActivity.class);
                                startActivity(intent);
                                break;

                            case R.id.nav_armor:
                                intent.setClass(BaseActivity.this, ArmorActivity.class);
                                startActivity(intent);
                                break;

                            case R.id.nav_monster:
                                intent.setClass(BaseActivity.this, MonsterActivity.class);
                                startActivity(intent);
                                break;

                            case R.id.nav_quest:
                                intent.setClass(BaseActivity.this, QuestActivity.class);
                                startActivity(intent);
                                break;

                            case R.id.nav_map:
                                intent.setClass(BaseActivity.this, MapActivity.class);
                                startActivity(intent);
                                break;

                            case R.id.nav_item:
                                intent.setClass(BaseActivity.this, ItemActivity.class);
                                startActivity(intent);
                                break;

                            case R.id.nav_decoration:
                                intent.setClass(BaseActivity.this, DecorationActivity.class);
                                startActivity(intent);
                                break;

                            default:
                                CoordinatorLayout coordLayout = (CoordinatorLayout) findViewById(R.id.coordlayout);
                                Snackbar snackbar = Snackbar.make(coordLayout, "snacking snack", Snackbar.LENGTH_LONG);
                                snackbar.show();
                                break;
                        }
                        //close drawer
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });


    }
}
