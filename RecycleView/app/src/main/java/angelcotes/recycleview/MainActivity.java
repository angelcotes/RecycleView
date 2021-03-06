package angelcotes.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewAdapter.RecyclerClickListner{

    private ViewAdapter viewAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycle);

        List<Information> data = new ArrayList<>();
        String[] titulo = getResources().getStringArray(R.array.data);

        for (int i = 0; i < titulo.length; i++){
            Information info = new Information(titulo[i]);
            data.add(info);
        }

        viewAdapter = new ViewAdapter(this, data);
        viewAdapter.setRecyclerClickListner(this);
        recyclerView.setAdapter(viewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void itemClick(View view, int position) {
        Log.d("RecycleView", "Click position "+position );
    }
}
