package drb.deekshithrajbasa.com.quotesmall;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class customview extends AppCompatActivity {
TextView tv , tv1 , textView , brand;
CircleImageView img;
String ImageURL;
FloatingActionButton cpy, save;
LinearLayout screenshot;
    Calendar c = Calendar.getInstance();
//    int day = c.get(Calendar.DAY_OF_MONTH);
//    int month = c.get(Calendar.MONTH);
//    int year = c.get(Calendar.YEAR);
//    String date = day + "/" + month + "/" + year;
    private ClipboardManager myClipboard;
    private ClipData myClip;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customview);

      /*  MobileAds.initialize(this,
                "ca-app-pub-1075395443616360~8895008703");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1075395443616360/9246362491");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());*/

     brand =(TextView) findViewById(R.id.brand);
     brand.setVisibility(View.GONE);
 save = (FloatingActionButton) findViewById(R.id.buttonsave);
 save.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         Bitmap bitmap = takeScreenshot();
         saveBitmap(bitmap);


     }
 });
 screenshot = (LinearLayout) findViewById(R.id.screenshot);

        tv = (TextView)findViewById(R.id.textView2) ;
        tv.setText(getIntent().getExtras().getString("description"));


        tv1 = (TextView)findViewById(R.id.textView) ;
        tv1.setText(getIntent().getExtras().getString("title"));


       textView =(TextView)findViewById(R.id.textView);
       cpy = (FloatingActionButton) findViewById(R.id.buttoncopy);
         cpy.setOnClickListener(new View.OnClickListener() {

             @SuppressWarnings("deprecation")
             @Override
             public void onClick(View view) {


                     ((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE))
                             .setText(tv1.getText()+tv.getText().toString()+"( Download our app to get more Quotes"+"quotesmall.tk"+")");

                     //making snack bar
                     Snackbar snackbar1 = Snackbar.make(view, "Quote Copied Sucessfully!", Snackbar.LENGTH_LONG)
                             .setAction("Share this quote on Whatsapp?", new View.OnClickListener() {
                                 @Override
                                 public void onClick(View view) {

                                     Intent instaintent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                                     startActivity(instaintent);

                                 }
                             });
                     snackbar1.setActionTextColor(Color.rgb(255, 69, 0));

                     snackbar1.show();

                 }


             });
    }
    public Bitmap takeScreenshot() {
//        brand.setVisibility(View.VISIBLE);
        View rootView = findViewById(android.R.id.content).getRootView();
        screenshot.setDrawingCacheEnabled(true);
        return screenshot.getDrawingCache();
    }

    public void saveBitmap(Bitmap bitmap) {
//        brand.setVisibility(View.VISIBLE);


        File imagePath = new File(Environment.getExternalStorageDirectory() + "/quotesmall"+"("+ System.currentTimeMillis()+")"+c.get(Calendar.YEAR)+".png");

        Toast.makeText(getApplicationContext(),"Quote has been saved sucessfully to your gallery..",Toast.LENGTH_SHORT).show();
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();


        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }



    public void onBackPressed(){



            this.finish();
        }


}
