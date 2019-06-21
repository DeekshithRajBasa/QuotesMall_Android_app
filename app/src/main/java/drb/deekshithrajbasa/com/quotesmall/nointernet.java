package drb.deekshithrajbasa.com.quotesmall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class nointernet extends AppCompatActivity {
Button settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nointernet2);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setClassName("com.android.phone", "com.android.phone.NetworkSetting");
                startActivity(intent);
            }
        });


    }
}
