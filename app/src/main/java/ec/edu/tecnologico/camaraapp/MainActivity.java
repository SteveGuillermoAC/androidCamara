package ec.edu.tecnologico.camaraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private ImageView imagen;
    private EditText et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen=(ImageView)findViewById(R.id.imageView);
        et=(EditText)findViewById(R.id.editText);


    }
    public void tomarFoto(View v){
        Intent intento1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File foto = new File(getExternalFilesDir(null), et.getText().toString());
        intento1.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(foto));
        startActivity(intento1);
    }
    public void recuperarFoto(View v){
        Bitmap bitmap = BitmapFactory.decodeFile(getExternalFilesDir(null)+"/"+et.getText().toString());
        imagen.setImageBitmap(bitmap);
    }

}
