package com.rental_apps.android.rental_apps.admin;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.rental_apps.android.rental_apps.R;
import com.rental_apps.android.rental_apps.api.client;
import com.rental_apps.android.rental_apps.model.model_mobil.ResponseRegisterCars;
import com.rental_apps.android.rental_apps.model.model_user.DataUser;
import com.rental_apps.android.rental_apps.model.model_user.ResponseRegister;
import com.rental_apps.android.rental_apps.myinterface.InitComponent;
import com.rental_apps.android.rental_apps.utils.validate;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

public class ActivityCreateMobil extends AppCompatActivity implements InitComponent, View.OnClickListener {
    //declare component
    private EditText et_nama_mobil;
    private EditText et_merk_mobil;
    private EditText et_deskripsi_mobil;
    private EditText et_tahun;
    private EditText et_kapasitas;
    private EditText et_harga_sewa;
    private EditText et_warna_mobil;
    private Spinner sp_bensin;
    private EditText et_plat;
    private RadioButton raktif;
    private RadioButton rtidakaktif;
    private Button btnRegister;
    private Button take;
    private ImageView imgshow;
    private CoordinatorLayout coordinatorLayout;

    //declare context
    private Context mContext;

    //declare variable
    private DataUser userData;

    //declare sweet alert
    private SweetAlertDialog pDialog;

    private Integer statusAktif=0;

    private int ketImage=0;
    String filePath="";
    Uri selectedImage;

    private static final int REQUEST_CAMERA = 1888;
    private static final int SELECT_FILE = 1887;
    private static final int PICK_FROM_GALLERY = 2;

    private String encodedImage=null;
    @Override
    protected void onCreate(Bundle SavedInstance){
        super.onCreate(SavedInstance);
        setContentView(R.layout.activity_add_mobil);
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Register Mobil");
    }

    @Override
    public void initUI() {
        et_nama_mobil=(EditText)findViewById(R.id.et_nama_mobil);
        et_merk_mobil=(EditText)findViewById(R.id.et_merk_mobil);
        et_deskripsi_mobil=(EditText)findViewById(R.id.et_deskripsi_mobil);
        et_tahun=(EditText)findViewById(R.id.et_tahun);
        et_kapasitas=(EditText)findViewById(R.id.et_kapasitas);
        et_harga_sewa=(EditText)findViewById(R.id.et_harga_sewa);
        et_warna_mobil=(EditText)findViewById(R.id.et_warna_mobil);
        sp_bensin=(Spinner)findViewById(R.id.sp_bensin);
        et_plat=(EditText)findViewById(R.id.et_plat);
        raktif=(RadioButton)findViewById(R.id.raktif);
        rtidakaktif=(RadioButton)findViewById(R.id.rtidakaktif);
        imgshow=(ImageView)findViewById(R.id.imgshow);
        btnRegister=(Button)findViewById(R.id.btn_register);
        take=(Button)findViewById(R.id.take);
    }

    @Override
    public void initValue() {

        List<String>adapter=new ArrayList<>();
        adapter.add("Premium");
        adapter.add("Pertalite");
        adapter.add("Pertamax");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, adapter);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_bensin.setAdapter(dataAdapter);
    }

    @Override
    public void initEvent() {
        btnRegister.setOnClickListener(this);
        raktif.setOnClickListener(this);
        rtidakaktif.setOnClickListener(this);
        take.setOnClickListener(this);
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
            case R.id.raktif:
                statusAktif=1;
                rtidakaktif.setChecked(false);
                break;
            case R.id.rtidakaktif:
                statusAktif=0;
                raktif.setChecked(false);
                break;
            case R.id.take:
                ChooseGallerOrCamera();
                break;
        }
    }

    private void register(){
        pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading");
        pDialog.setCancelable(false);
        pDialog.show();


        et_nama_mobil=(EditText)findViewById(R.id.et_nama_mobil);
        et_merk_mobil=(EditText)findViewById(R.id.et_merk_mobil);
        et_deskripsi_mobil=(EditText)findViewById(R.id.et_deskripsi_mobil);
        et_tahun=(EditText)findViewById(R.id.et_tahun);
        et_kapasitas=(EditText)findViewById(R.id.et_kapasitas);
        et_harga_sewa=(EditText)findViewById(R.id.et_harga_sewa);
        et_warna_mobil=(EditText)findViewById(R.id.et_warna_mobil);
        sp_bensin=(Spinner)findViewById(R.id.sp_bensin);
        et_plat=(EditText)findViewById(R.id.et_plat);
        raktif=(RadioButton)findViewById(R.id.raktif);
        rtidakaktif=(RadioButton)findViewById(R.id.rtidakaktif);


        Call<ResponseRegisterCars> register;
        register = client.getApi().mobilRegister(et_nama_mobil.getText().toString(),
                et_merk_mobil.getText().toString(),
                et_deskripsi_mobil.getText().toString(),
                et_tahun.getText().toString(),
                et_kapasitas.getText().toString(),
                et_harga_sewa.getText().toString(),
                et_warna_mobil.getText().toString(),
                sp_bensin.getSelectedItemPosition()+1,
                et_plat.getText().toString(),
                ""+statusAktif,
                encodedImage);

        register.enqueue(new Callback<ResponseRegisterCars>() {

            @Override
            public void onResponse(Call<ResponseRegisterCars> call, Response<ResponseRegisterCars> response) {
                pDialog.hide();
                if (response.isSuccessful()){
                    if (response.body().getStatus()) {
                        new SweetAlertDialog(mContext, SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("Info")
                                .setContentText("Data Mobil Berhasil Di Buat!")
                                .show();
                    }else {
                        new SweetAlertDialog(mContext, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Info")
                                .setContentText("Data Mobil Gagal Di Buat!")
                                .show();
                    }
                }else{
                    new SweetAlertDialog(mContext, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Info")
                            .setContentText("Data Mobil Gagal Di Buat!")
                            .show();
                }
            }

            @Override
            public void onFailure(Call<ResponseRegisterCars> call, Throwable t) {
                pDialog.hide();
                new SweetAlertDialog(mContext, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Oops...")
                        .setContentText("Koneksi bermasalah!")
                        .show();
            }
        });
    }

    private Boolean validasi(){


        if (!validate.cek(et_nama_mobil)
                &&!validate.cek(et_merk_mobil)
                &&!validate.cek(et_deskripsi_mobil)
                &&!validate.cek(et_tahun)
                &&!validate.cek(et_kapasitas)
                &&!validate.cek(et_harga_sewa)
                &&!validate.cek(et_warna_mobil)
                &&!validate.cek(et_plat)) {

                return true;
        } else{ return false; }
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
                imgshow.setImageBitmap(b);

                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }



}
