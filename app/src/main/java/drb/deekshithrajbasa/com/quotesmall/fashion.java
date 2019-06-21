package drb.deekshithrajbasa.com.quotesmall;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class fashion extends AppCompatActivity {
    ListView listview;
    private RecyclerView recyclerView;
    private DatabaseReference myref;
    ArrayList<String> list = new ArrayList<>();
    Button button;
    Button copyText;
    TextView textView;
    public Intent i;

    Toolbar toolbar;
    FloatingActionButton fab;
    public static ArrayList<String> imageUrl = new ArrayList<>();
    public static ArrayList<String> titleTag = new ArrayList<>();
    public static ArrayList<String> descTag = new ArrayList<>();
    public static ArrayList<Integer> pos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion);

        //recycle view
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(layoutManager);
        // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        //recyclerView.setItemAnimator(new SlideInUpAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        recyclerView.setItemAnimator(new SlideInUpAnimator());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        recyclerView.setLayoutManager(gridLayoutManager);
        //firebase database
        myref = FirebaseDatabase.getInstance().getReference().child("/fashion");
        FirebaseRecyclerAdapter<facebookAdapter, fashion.BlogViewHolder> recyclerAdapter = new FirebaseRecyclerAdapter<facebookAdapter, fashion.BlogViewHolder>(
                facebookAdapter.class,
                R.layout.individual_rowfb,
                fashion.BlogViewHolder.class,
                myref
        ) {

            @Override
            protected void populateViewHolder(fashion.BlogViewHolder viewHolder, facebookAdapter model, int position) {
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDescription(model.getDescription());

                viewHolder.setPosition(position);

                if (!descTag.contains(model.getDescription()))
                    descTag.add(model.getDescription());

                if (!pos.contains(position))
                    pos.add(position);
                Log.v("title:", "" + descTag.get(position));

            }
        };

        recyclerView.setAdapter(recyclerAdapter);
    }

    private void firebaseUserSearch(String searchText) {
        Toast.makeText(getApplicationContext(), "Started Search for :" + searchText, Toast.LENGTH_LONG).show();
        int i = 0;
        for (String string : descTag) {
            i++;
            if (string.matches(searchText))
                Toast.makeText(getApplicationContext(), "Found: " + searchText + " at: " + i, Toast.LENGTH_LONG).show();

        }

        Query firebaseSearchQuery = myref.orderByChild("description").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<facebookAdapter, fashion.BlogViewHolder> RecyclerAdapter = new FirebaseRecyclerAdapter<facebookAdapter, fashion.BlogViewHolder>(

                facebookAdapter.class,
                R.layout.individual_rowfb,
                fashion.BlogViewHolder.class,
                firebaseSearchQuery

        ) {
            @Override
            protected void populateViewHolder(fashion.BlogViewHolder viewHolder, facebookAdapter model, int position) {




                viewHolder.setTitle(model.getTitle());
                viewHolder.setDescription(model.getDescription());

                viewHolder.setPosition(position);

            }
        };

        recyclerView.setAdapter(RecyclerAdapter);

    }




    public static class BlogViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView textView_title;
        TextView textView_decription;
        // ImageView imageView;
        int position;


        public BlogViewHolder(final View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {



                    Intent passdata = new Intent(view.getContext(), customview.class);


                    passdata.putExtra("title", textView_title.getText().toString());
                    passdata.putExtra("description", textView_decription.getText().toString());


                    view.getContext().startActivity(passdata);



                }
            });

            mView = itemView;
            textView_title = (TextView) itemView.findViewById(R.id.title);
            textView_decription = (TextView) itemView.findViewById(R.id.description);


        }

        public void setTitle(String title) {
            textView_title.setText(""+title + "");
        }

        public void setDescription(String description) {
            textView_decription.setText("By -"+description);
        }

        public void setPosition(int pos) {
            this.position = pos;
        }




    }
    }

