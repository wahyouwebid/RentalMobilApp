package com.rental_apps.android.rental_apps.admin;

/**
 * Created by Muhajir on 07/10/2017.
 */

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.pixplicity.easyprefs.library.Prefs;
import com.rental_apps.android.rental_apps.R;
import com.rental_apps.android.rental_apps.SPreferenced.SPref;
import com.rental_apps.android.rental_apps.api.client;
import com.rental_apps.android.rental_apps.helper.Hash;
import com.rental_apps.android.rental_apps.model.model_user.DataUser;
import com.rental_apps.android.rental_apps.model.model_user.ResponseRegister;
import com.rental_apps.android.rental_apps.myinterface.InitComponent;
import com.rental_apps.android.rental_apps.utils.validate;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import cn.pedant.SweetAlert.SweetAlertDialog;
import customfonts.MyEditText;
import customfonts.MyTextView;
import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

public class AdminEditProfile extends AppCompatActivity implements InitComponent, View.OnClickListener {
    private MyEditText name;
    private MyEditText nik;
    private MyEditText email;
    private MyEditText noTelp;
    private MyEditText address;
    private MyEditText jenis_kelamin;
    private MyEditText status;
    private MyEditText username;
    private MyEditText old_password;
    private MyEditText new_password;
    private MyEditText confirm_password;

    private CircleImageView userPhoto;

    private Button update;

    private SweetAlertDialog pDialog;

    private String JK;

    Context mContext;
    Toolbar toolbar;
    DataUser user;

    private Boolean ket=false;

    Uri selectedImage;
    private static final int REQUEST_CAMERA = 1888;
    private static final int SELECT_FILE = 1887;
    private static final int PICK_FROM_GALLERY = 2;
    String filePath="";
    private String encodedImage=null;
    @Override
    protected void onCreate(Bundle SavedInstance){
        super.onCreate(SavedInstance);
        setContentView(R.layout.activity_edit_user);

        Gson gson = new Gson();
        user= gson.fromJson(getIntent().getStringExtra("user"), DataUser.class);

        mContext=this;
        startInit();
    }

    @Override
    public void startInit() {
        initToolbar();
        initUI();
        initValue();
        initEvent();
    }

    @Override
    public void initToolbar() {
        toolbar=(Toolbar)findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_action_back);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");
    }

    @Override
    public void initUI() {
        name=(MyEditText)findViewById(R.id.name);
        nik=(MyEditText)findViewById(R.id.nik);
        email=(MyEditText)findViewById(R.id.email);
        noTelp=(MyEditText)findViewById(R.id.notelp);
        address=(MyEditText)findViewById(R.id.address);
        jenis_kelamin=(MyEditText)findViewById(R.id.jenis_kelamin);
        status=(MyEditText)findViewById(R.id.status);
        username=(MyEditText)findViewById(R.id.username);
        old_password=(MyEditText)findViewById(R.id.old_password);
        new_password=(MyEditText)findViewById(R.id.password);
        confirm_password=(MyEditText)findViewById(R.id.confirm_password);
        userPhoto=(CircleImageView)findViewById(R.id.userPhoto);
        update=(Button)findViewById(R.id.btn_update);

    }


    @Override
    public void initValue() {

        name.setText(Prefs.getString(SPref.getNAME(),""));
        nik.setText(Prefs.getString(SPref.getNIK(),""));
        email.setText(Prefs.getString(SPref.getEMAIL(),""));
        noTelp.setText(Prefs.getString(SPref.getNoTelp(),""));
        address.setText(Prefs.getString(SPref.getALAMAT(),""));
        username.setText(Prefs.getString(SPref.getUSERNAME(),""));
        JK=Prefs.getString(SPref.getJenisKelamin(),"");
        if (Prefs.getString(SPref.getJenisKelamin(),"").equals('L')){
            jenis_kelamin.setText("Laki-laki");
        }else{
            jenis_kelamin.setText("Perempuan");
        }

        status.setText("Aktif");

//        if(!Prefs.getString(SPref.getPHOTO(),null).isEmpty())
//
// Picasso.with(mContext).load(client.getBaseUrlImage()+Prefs.getString(SPref.getPHOTO(),null)).into(userPhoto);


    }

    @Override
    public void initEvent() {
        old_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (!Hash.MD5(old_password.getText().toString()).equals(Prefs.getString(SPref.getPASSWORD(),""))){
                    View focusView = null;
                    old_password.setError("Password tidak sama");
                    focusView = old_password;
                    focusView.requestFocus();
                    ket=false;
                }else{
                    ket=true;
                }
            }
        });

        update.setOnClickListener(this);
        userPhoto.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_register:
                if(validasi())
                    register();
                break;
            case R.id.userPhoto:
                ChooseGallerOrCamera();
                break;
            case R.id.jkl:
                JK="L";
//                rbp.setChecked(false);
                break;
            case R.id.jkp:
                JK="P";
//                rbl.setChecked(false);
                break;
            case R.id.btn_update:
                if(validasi())
                    register();
                break;
        }
    }

    private void register(){
        pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading");
        pDialog.setCancelable(false);
        pDialog.show();

        Call<ResponseRegister> register;
//        Toasty.success(mContext,Prefs.getString(SPref.getIdUser(),""),Toast.LENGTH_SHORT).show();

        register = client.getApi().userUpdate(""+Prefs.getInt(SPref.getIdUser(),0),name.getText().toString(),
                nik.getText().toString(),
                username.getText().toString(),
                email.getText().toString(),
                noTelp.getText().toString(),
                JK,
                address.getText().toString(),
                new_password.getText().toString(),
                1,Prefs.getInt(SPref.getGroupUser(),0),encodedImage);

        register.enqueue(new Callback<ResponseRegister>() {

            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                pDialog.hide();
                if (response.isSuccessful()){
                    if (response.body().getStatus()) {
                        new SweetAlertDialog(mContext, SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("Info")
                                .setContentText("Akun Berhasil Di Update!")
                                .show();
                        setPreference(response.body().getData());
                    }else {
                        new SweetAlertDialog(mContext, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Info")
                                .setContentText("Akun Gagal Di Update!")
                                .show();
                    }
                }else{
                    new SweetAlertDialog(mContext, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Info")
                            .setContentText("Akun Gagal Di Update!")
                            .show();
                }
            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                pDialog.hide();
                new SweetAlertDialog(mContext, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Oops...")
                        .setContentText("Koneksi bermasalah!")
                        .show();
            }
        });
    }

    private Boolean validasi(){
        if (!validate.cek(name)
                &&!validate.cek(nik)
                &&!validate.cek(username)
                &&!validate.cek(email)
                &&!validate.cek(noTelp)
                &&!validate.cek(address)
                &&!validate.cek(old_password)&&ket) {
            if (validate.cekPassword(confirm_password,new_password.getText().toString(),confirm_password.getText().toString())){
                return false;
            }else{
                return true;
            }
        } else{ return false; }
    }

    private void setPreference(DataUser du){
        Prefs.putInt(SPref.getIdUser(),du.getId_user());
        Prefs.putString(SPref.getNIK(),du.getNik());
        Prefs.putString(SPref.getUSERNAME(),du.getUsername());
        Prefs.putString(SPref.getNAME(),du.getName());
        Prefs.putString(SPref.getEMAIL(),du.getEmail());
        Prefs.putString(SPref.getNoTelp(),du.getNo_telp());
        Prefs.putString(SPref.getJenisKelamin(),du.getJenis_kelamin().toString());
        Prefs.putString(SPref.getPHOTO(),du.getPhoto());
        Prefs.putString(SPref.getLastUpdate(),du.getLast_update().toString());
        Prefs.putString(SPref.getALAMAT(),du.getAlamat());
        Prefs.putInt(SPref.getGroupUser(),du.getGroup_user());
        Prefs.putString(SPref.getPASSWORD(),du.getPassword().toString());
    }

    private void ChooseGallerOrCamera() {
        final CharSequence[] items = { "Choose from Gallery",
                "Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Photo");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    File photo = null;
                    try
                    {
                        // place where to store camera taken picture
                        photo = this.createTemporaryFile("picture", ".jpg");
                        photo.delete();
                    }
                    catch(Exception e)
                    {

                    }
                    selectedImage = Uri.fromFile(new File("/sdcard/sample.jpg"));
                    cameraIntent.putExtra("ket","1");
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, selectedImage);
                    startActivityForResult(cameraIntent, REQUEST_CAMERA);
                } else if (items[item].equals("Choose from Gallery")) {
                    Intent intent = new Intent();
                    intent.setType("image/*"); //set type for files (image type)
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_FROM_GALLERY);
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }

            private File createTemporaryFile(String part, String ext) throws Exception
            {
                File tempDir= Environment.getExternalStorageDirectory();
                tempDir=new File(tempDir.getAbsolutePath()+"/.temp/");
                if(!tempDir.exists())
                {
                    tempDir.mkdirs();
                }
                return File.createTempFile(part, ext, tempDir);
            }

        });
        builder.show();
    }
    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }

    private String getRealPathFromURIPath(Uri contentURI, Activity activity) {
        Cursor cursor = activity.getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) {
            return contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(idx);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CAMERA) {
            if (resultCode == RESULT_OK) {
                ContentResolver cr = this.getContentResolver();
                Bitmap photo=null;
                try {
                    photo = MediaStore.Images.Media.getBitmap(cr, selectedImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                selectedImage = getImageUri(getApplicationContext(), photo);
//                filePath=getRealPathFromURI(selectedImage);
//                setImageView(filePath);

            } else if (resultCode == RESULT_CANCELED) {
                // user cancelled Image capture
                Toast.makeText(getApplicationContext(),
                        "User cancelled image capture", Toast.LENGTH_SHORT)
                        .show();
            } else {
                // failed to capture image
                Toast.makeText(getApplicationContext(),
                        "Sorry! Failed to capture image", Toast.LENGTH_SHORT)
                        .show();
            }
        }else if(requestCode==PICK_FROM_GALLERY){
            if (resultCode==RESULT_OK){
                selectedImage = data.getData();
//                tampil_gambar_sk_hilang.setImageURI(selectedImage);
                filePath = getRealPathFromURIPath(selectedImage, this);
                setImageView(filePath);
            }
        }
    }


    private void setImageView(String filepath){
        File imgFile = new  File(filepath);
        Bitmap bm = BitmapFactory.decodeFile(filepath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
        byte[] ba = baos.toByteArray();
        encodedImage = Base64.encodeToString(ba, Base64.DEFAULT);

        if(imgFile.exists()){

            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            File f=new File(filepath);
            Bitmap b = null;
            try {
                FileInputStream fis = new FileInputStream(f);
                BitmapFactory.decodeStream(fis, null, o);
                fis.close();

                float sc = 0.0f;
                int scale = 1;
                //if image height is greater than width
                if (o.outHeight > o.outWidth) {
                    sc = o.outHeight / 400;
                    scale = Math.round(sc);
                }
                //if image width is greater than height
                else {
                    sc = o.outWidth / 400;
                    scale = Math.round(sc);
                }

                // Decode with inSampleSize
                BitmapFactory.Options o2 = new BitmapFactory.Options();
                o2.inSampleSize = scale;
                fis = new FileInputStream(f);
                b = BitmapFactory.decodeStream(fis, null, o2);
//                if (ketImage==1) {
//                    tampil_gambar_rt.setImageBitmap(b);
//                    listOfImagesPath.set(0,filepath);
//                }else if (ketImage==2) {
//                    tampil_gambar_kk.setImageBitmap(b);
//                    listOfImagesPath.set(1,filepath);
//                }else if (ketImage==3) {
//                    tampil_gambar_nikah.setImageBitmap(b);
//                    listOfImagesPath.set(2,filepath);
//                }else if (ketImage==4) {
//                    tampil_gambar_akta.setImageBitmap(b);
//                    listOfImagesPath.set(3,filepath);
//                }else if (ketImage==5) {
//                    tampil_gambar_master_kk.setImageBitmap(b);
//                    listOfImagesPath.set(4,filepath);
//                }
                userPhoto.setImageBitmap(b);

                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }



}

