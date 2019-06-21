package drb.deekshithrajbasa.com.quotesmall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class choose_main extends AppCompatActivity {

    public static  String l1="https://firebasestorage.googleapis.com/v0/b/quotesmallapp.appspot.com/o/attitude.png?alt=media&token=0605447f-7723-40da-ade9-819214db202f";
    public static  String l2="https://firebasestorage.googleapis.com/v0/b/quotesmallapp.appspot.com/o/love.png?alt=media&token=4abd4d1f-b43b-4bab-84f9-ce87c2a19e4f";
    public static  String l3="https://firebasestorage.googleapis.com/v0/b/quotesmallapp.appspot.com/o/selfie.png?alt=media&token=501d998d-edfc-4663-9686-0e86db8734c7";
    public static  String l4="https://firebasestorage.googleapis.com/v0/b/quotesmallapp.appspot.com/o/fashion.png?alt=media&token=e83a2275-3c09-49eb-9642-fbc9a9fb6988";
    public static  String l5="https://firebasestorage.googleapis.com/v0/b/quotesmallapp.appspot.com/o/friends.png?alt=media&token=c1914ec7-aeb6-4769-b59b-080389283c00";
    public static  String l6="https://firebasestorage.googleapis.com/v0/b/quotesmallapp.appspot.com/o/smile.png?alt=media&token=637295d2-52fe-45f7-a518-3ac7f29f9969";
    public static  String l7="https://firebasestorage.googleapis.com/v0/b/quotesmallapp.appspot.com/o/travel.png?alt=media&token=28c31a07-947d-494d-a0c4-bd369b9eae2f";
    public static  String l8="https://firebasestorage.googleapis.com/v0/b/quotesmallapp.appspot.com/o/life.png?alt=media&token=323e3829-ace4-4210-afd8-2449747a0225";
    ImageView i1, i2 ,i3, i4, i5, i6, i7, i8 ;

    CardView c1,c2,c3,c4,c5,c6,c7,c8;

    ImageButton noti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_main);
picasso();


     noti = (ImageButton)findViewById(R.id.notification);
     noti.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             startActivity(new Intent(getApplicationContext(), notification.class));
         }
     });

     CardView   c1 = (CardView) findViewById(R.id.card1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), fbhashtags.class));
            }
        });


        CardView c2 = (CardView) findViewById(R.id.card2);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), love.class));
            }
        });

        CardView c3 =(CardView)findViewById(R.id.card3);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),fashion.class));

            }
        });
    }


    public void picasso(){

        i1 = findViewById(R.id.c1i);i5 = findViewById(R.id.c5i);
        i2 = findViewById(R.id.c2i);i6 = findViewById(R.id.c6i);
        i3 = findViewById(R.id.c3i);i7 = findViewById(R.id.c7i);
        i4 = findViewById(R.id.c4i);i8 = findViewById(R.id.c8i);

/*
        Picasso.get().load(l1).centerCrop().into(i1);
        Picasso.get().load(l2).centerCrop().into(i2);
        Picasso.get().load(l3).centerCrop().into(i3);
        Picasso.get().load(l4).centerCrop().into(i4);
        Picasso.get().load(l5).centerCrop().into(i5);
        Picasso.get().load(l6).centerCrop().into(i6);
        Picasso.get().load(l7).centerCrop().into(i7);
        Picasso.get().load(l8).centerCrop().into(i8);*/
    }
}
