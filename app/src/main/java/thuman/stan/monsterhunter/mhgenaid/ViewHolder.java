package thuman.stan.monsterhunter.mhgenaid;

import android.view.View;
import android.widget.ImageView;

/**
 * Created by Stan Thuman on 3/7/2016.
 */
public class ViewHolder {
    ImageView icon = null;

    ViewHolder(View row){
        this.icon = (ImageView)row.findViewById(R.id.monster_imageview);
    }

}
