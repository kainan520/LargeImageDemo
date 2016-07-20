package cn.zeffect.demo.largeimagedemo;

import android.app.Activity;
import android.os.Bundle;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/**
 * Created by zeffect on 2016/7/20.
 */
public class AssetActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SubsamplingScaleImageView imageView = new SubsamplingScaleImageView(this);
        setContentView(imageView);
        imageView.setImage(ImageSource.asset("image1.jpg"));
    }
}
