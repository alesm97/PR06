package com.example.alesm97.profile;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alesm97.profile.Utils.IntentUtils;
import com.example.alesm97.profile.Utils.ValidationUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.imgProfile)
    ImageView imgProfile;
    @BindView(R.id.lblNick)
    TextView lblNick;
    @BindView(R.id.lblName)
    TextView lblName;
    @BindView(R.id.txtName)
    EditText txtName;
    @BindView(R.id.lblEmail)
    TextView lblEmail;
    @BindView(R.id.txtEmail)
    EditText txtEmail;
    @BindView(R.id.imgEmail)
    ImageView imgEmail;
    @BindView(R.id.lblPhone)
    TextView lblPhone;
    @BindView(R.id.txtPhone)
    EditText txtPhone;
    @BindView(R.id.imgPhone)
    ImageView imgPhone;
    @BindView(R.id.lblAddress)
    TextView lblAddress;
    @BindView(R.id.txtAddress)
    EditText txtAddress;
    @BindView(R.id.imgAddress)
    ImageView imgAddress;
    @BindView(R.id.lblWeb)
    TextView lblWeb;
    @BindView(R.id.txtWeb)
    EditText txtWeb;
    @BindView(R.id.imgWeb)
    ImageView imgWeb;


    int numCat = 1, imageId;
    final int RC_OTRA = 1;
    public static final String EXTRA_CATS = "numCats", EXTRA_NAME = "name";
    String name;
    Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
    Typeface normalTypeface = Typeface.defaultFromStyle(Typeface.NORMAL);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if(savedInstanceState!=null){

            changeProfileImage(savedInstanceState.getInt(EXTRA_CATS));
            lblNick.setText(savedInstanceState.getString(EXTRA_NAME));

            checkEmail(txtEmail.getText());
            checkPhone(txtPhone.getText());
            checkAddres(txtAddress.getText());
            checkWeb(txtWeb.getText());

        }
    }


    @OnTextChanged(R.id.txtEmail)
    public void checkEmail(Editable editable) {
        if (ValidationUtils.isValidEmail(editable.toString())) {
            imgEmail.setImageResource(R.drawable.email_valid);
            imgEmail.setClickable(true);
        } else {
            imgEmail.setImageResource(R.drawable.email_no_valid);
            imgEmail.setClickable(false);
        }
    }

    @OnTextChanged(R.id.txtPhone)
    public void checkPhone(Editable editable) {
        if (ValidationUtils.isValidPhone(editable.toString())) {
            imgPhone.setImageResource(R.drawable.phone_valid);
            imgPhone.setClickable(true);

        } else {
            imgPhone.setImageResource(R.drawable.phone_no_valid);
            imgPhone.setClickable(false);
        }
    }

    @OnTextChanged(R.id.txtAddress)
    public void checkAddres(Editable editable) {
        if (!editable.toString().isEmpty()) {
            imgAddress.setImageResource(R.drawable.map_valid);
            imgAddress.setClickable(true);

        } else {
            imgAddress.setImageResource(R.drawable.map_no_valid);
            imgAddress.setClickable(false);
        }
    }

    @OnTextChanged(R.id.txtWeb)
    public void checkWeb(Editable editable) {
        if (ValidationUtils.isValidUrl(editable.toString())) {
            imgWeb.setImageResource(R.drawable.web_valid);
            imgWeb.setClickable(true);

        } else {
            imgWeb.setImageResource(R.drawable.web_no_valid);
            imgWeb.setClickable(false);
        }
    }




    @OnClick({R.id.imgProfile, R.id.lblNick})
    public void changeProfile(View view) {

        MainProfile.startForResult(this, RC_OTRA, numCat);

    }

    @OnClick(R.id.imgEmail)
    public void onEmailClicked(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + txtEmail.getText().toString()));
        startActivity(intent);
    }

    @OnClick(R.id.imgPhone)
    public void onPhoneClicked(View view) {
        Intent intent = IntentUtils.newDialIntent(txtPhone.getText().toString().trim());
        startActivity(intent);
    }

    @OnClick(R.id.imgAddress)
    public void onAddressClicked(View view){
        Intent intent = IntentUtils.newSearchInMapIntent(txtAddress.getText().toString());
        startActivity(intent);
    }

    @OnClick(R.id.imgWeb)
    public void onWebClicked(View view){
        Intent intent = IntentUtils.newViewUriIntent(Uri.parse(txtWeb.getText().toString()));
        startActivity(intent);
    }

    @OnFocusChange(R.id.txtName)
    public void focusChangeName(View view, boolean hasFocus){
        if(hasFocus){
            lblName.setTypeface(boldTypeface);
        }else{
            lblName.setTypeface(normalTypeface);
        }
    }

    @OnFocusChange(R.id.txtEmail)
    public void focusChangeEmail(View view, boolean hasFocus){
        if(hasFocus){
            lblEmail.setTypeface(boldTypeface);
        }else{
            lblEmail.setTypeface(normalTypeface);
        }
    }

    @OnFocusChange(R.id.txtPhone)
    public void focusChangePhone(View view, boolean hasFocus){
        if(hasFocus){
            lblPhone.setTypeface(boldTypeface);
        }else{
            lblPhone.setTypeface(normalTypeface);
        }
    }

    @OnFocusChange(R.id.txtAddress)
    public void focusChangeAddress(View view, boolean hasFocus){
        if(hasFocus){
            lblAddress.setTypeface(boldTypeface);
        }else{
            lblAddress.setTypeface(normalTypeface);
        }
    }

    @OnFocusChange(R.id.txtWeb)
    public void focusChangeWeb(View view, boolean hasFocus){
        if(hasFocus){
            lblWeb.setTypeface(boldTypeface);
        }else{
            lblWeb.setTypeface(normalTypeface);
        }
    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == RC_OTRA) {
            if (data.hasExtra(MainProfile.EXTRA_NAME) && data.hasExtra(MainProfile.EXTRA_CATS)) {

                Bundle extras = data.getExtras();

                name = extras.getString(MainProfile.EXTRA_NAME);
                lblNick.setText(name);

                numCat = extras.getInt(MainProfile.EXTRA_CATS);

                changeProfileImage(numCat);
            }
        }

    }

    private void changeProfileImage(int numCat) {
        switch(numCat){
            case 1:
                imgProfile.setImageResource(R.drawable.cat1);
                break;
            case 2:
                imgProfile.setImageResource(R.drawable.cat2);
                break;
            case 3:
                imgProfile.setImageResource(R.drawable.cat3);
                break;
            case 4:
                imgProfile.setImageResource(R.drawable.cat4);
                break;
            case 5:
                imgProfile.setImageResource(R.drawable.cat5);
                break;
            case 6:
                imgProfile.setImageResource(R.drawable.cat6);
                break;
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(EXTRA_CATS, numCat);
        savedInstanceState.putString(EXTRA_NAME, lblNick.getText().toString());

        super.onSaveInstanceState(savedInstanceState);
    }


}
