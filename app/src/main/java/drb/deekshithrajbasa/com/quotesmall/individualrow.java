package drb.deekshithrajbasa.com.quotesmall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class individualrow extends AppCompatActivity {
    DatabaseReference dref;
    ListView listview;
    private RecyclerView recyclerView;
    private DatabaseReference myref;
    ArrayList<String> list = new ArrayList<>();
    Button cv;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.individual_row);




    }
}