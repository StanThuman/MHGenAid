package thuman.stan.monsterhunter.mhgenaid;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Stan Thuman on 3/9/2016.
 */
public class WeaponDetailActivity extends BaseActivity{

    public static final String WEAPON_ID = "RANDOM STRING";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapondetail);
        WebView webView = (WebView)findViewById(R.id.weapon_webView);
        webView.getSettings().setBuiltInZoomControls(true);
        int weaponId = getIntent().getExtras().getInt(WEAPON_ID);
        loadSelectedWeaponPage(webView, weaponId);


    }

    private void loadSelectedWeaponPage(WebView weaponContainer, int position){
        weaponContainer.loadUrl("file:///android_asset/weapon_" + position + ".html");
    }


}
