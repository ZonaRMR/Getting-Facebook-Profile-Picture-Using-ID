package com.example.chint.getfbimage;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView Image;
    private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Image = (ImageView) findViewById(R.id.image);
        text = (EditText) findViewById(R.id.id);
    }


    public void getImage(View view) {
        String userid = text.getText().toString();
        text.setText("");
        if(!userid.isEmpty()) {
            Picasso.with(this).setLoggingEnabled(true);
            Picasso.with(this)
                    .load("https://graph.facebook.com/"+userid+"/picture?type=large")
                    .error(R.mipmap.ic_launcher)
                    .into(Image);
        }

        //100003362053935
        //http://graph.facebook.com/"+userid+"/picture?type=large
        //https://scontent.xx.fbcdn.net/v/t1.0-1/p200x200/20525747_1289066221215434_5052151523317935456_n.jpg?oh=655f967bec5af29534138e07470959dd&oe=5A2C74C4

        else
            Toast.makeText(this, "Enter Correct ID", Toast.LENGTH_SHORT).show();
    }
}
