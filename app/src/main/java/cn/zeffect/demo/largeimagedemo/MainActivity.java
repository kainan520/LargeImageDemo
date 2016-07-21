package cn.zeffect.demo.largeimagedemo;

import android.content.Intent;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.davemorrissey.labs.subscaleview.ImageSource;

import org.w3c.dom.Text;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AssetActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choseHeadImageFromGallery();
            }
        });
    }

    /**
     * 请求识别码去相册
     **/
    private static final int CODE_GALLERY_REQUEST = 0xa0;

    /**
     * 从本地相册?取图片作为头像
     */
    private void choseHeadImageFromGallery() {
        Intent intentFromGallery = new Intent();
        // 设置文件类型
        intentFromGallery.setType("image/*");
        intentFromGallery.setAction(Intent.ACTION_PICK);
        startActivityForResult(intentFromGallery, CODE_GALLERY_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        // 用户没有进行有效的设置操作，返回
        if (resultCode == RESULT_CANCELED) {
            finish();
            return;
        }
        switch (requestCode) {
            case CODE_GALLERY_REQUEST:
                if (intent != null) {
                    String localPath = "";
                    Cursor cr = getContentResolver().query(intent.getData(),
                            new String[]{MediaStore.Images.Media.DATA}, null,
                            null, null);
                    if (cr == null) {
                        return;
                    }
                    if (cr.moveToFirst()) {
                        localPath = cr.getString(cr
                                .getColumnIndex(MediaStore.Images.Media.DATA));
                    }
                    cr.close();
                    if (!TextUtils.isEmpty(localPath)) {
                        Intent intent2 = new Intent(MainActivity.this, FileActivity.class);
                        intent2.putExtra("filepath", localPath);
                        startActivity(intent2);
                    }
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }
}
