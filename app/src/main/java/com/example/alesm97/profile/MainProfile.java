package com.example.alesm97.profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainProfile extends AppCompatActivity {

    @BindView(R.id.imgCat1)
    ImageView imgCat1;
    @BindView(R.id.imgCat2)
    ImageView imgCat2;
    @BindView(R.id.imgCat3)
    ImageView imgCat3;
    @BindView(R.id.imgCat4)
    ImageView imgCat4;
    @BindView(R.id.imgCat5)
    ImageView imgCat5;
    @BindView(R.id.imgCat6)
    ImageView imgCat6;
    @BindView(R.id.lblCat1)
    TextView lblCat1;
    @BindView(R.id.lblCat2)
    TextView lblCat2;
    @BindView(R.id.lblCat3)
    TextView lblCat3;
    @BindView(R.id.lblCat4)
    TextView lblCat4;
    @BindView(R.id.lblCat5)
    TextView lblCat5;
    @BindView(R.id.lblCat6)
    TextView lblCat6;

    int numCat;
    public static final String EXTRA_CATS = "numCats", EXTRA_NAME = "name";
    String name;
    ImageView selected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);
        ButterKnife.bind(this);

        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        numCat = extras.getInt(MainActivity.EXTRA_CATS);
        selectImage();
    }

    private void selectImage() {
        switch (numCat){
            case 1:
                imgCat1.setAlpha(.5f);
                //cat1();
                break;
            case 2:
                imgCat2.setAlpha(.5f);
                //cat2();
                break;
            case 3:
                imgCat3.setAlpha(.5f);
                //cat3();
                break;
            case 4:
                imgCat4.setAlpha(.5f);
                //cat4();
                break;
            case 5:
                imgCat5.setAlpha(.5f);
                //cat5();
                break;
            case 6:
                imgCat6.setAlpha(.5f);
                //cat6();
                break;
        }
    }

    @OnClick({R.id.imgCat1,R.id.lblCat1})
    public void cat1AndFinish(View view){
        name=lblCat1.getText().toString();
        numCat=1;
        finish();
    }

    @OnClick({R.id.imgCat2,R.id.lblCat2})
    public void cat2AndFinish(View view){
        name=lblCat2.getText().toString();
        numCat=2;
        finish();
    }

    @OnClick({R.id.imgCat3,R.id.lblCat3})
    public void cat3AndFinish(View view){
        name=lblCat3.getText().toString();
        numCat=3;
        finish();
    }

    @OnClick({R.id.imgCat4,R.id.lblCat4})
    public void cat4AndFinish(View view){
        name=lblCat4.getText().toString();
        numCat=4;
        finish();
    }

    @OnClick({R.id.imgCat5,R.id.lblCat5})
    public void cat5AndFinish(View view){
        name=lblCat5.getText().toString();
        numCat=5;
        finish();
    }

    @OnClick({R.id.imgCat6,R.id.lblCat6})
    public void cat6AndFinish(View view){
        name=lblCat6.getText().toString();
        numCat=6;
        finish();
    }

    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_CATS, numCat);
        this.setResult(RESULT_OK, intent);

        super.finish();
    }

    public static void startForResult(Activity activity, int requestCode, int numCat) {
        Intent intent = new Intent(activity, MainProfile.class);
        intent.putExtra(EXTRA_CATS, numCat);
        activity.startActivityForResult(intent, requestCode);
    }


}
