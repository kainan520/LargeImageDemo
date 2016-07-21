package cn.zeffect.demo.largeimagedemo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.io.File;

/**
 * Created by zeffect on 2016/7/20.
 */
public class FileActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SubsamplingScaleImageView imageView = new SubsamplingScaleImageView(this);
        setContentView(imageView);
        String filePath = getIntent().getStringExtra("filepath");
        imageView.setImage(ImageSource.uri(Uri.fromFile(new File(filePath))));
    }
}
