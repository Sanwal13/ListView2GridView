package blackriders.listview2gridview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewStub;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Sanwal Singh on 18/4/16.
 */

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private ViewStub listview, gridview;
    private boolean list_visibile = false;
    private ContextMenu menu;
    private ListView list;
    private GridView grid;
    private ListViewAdapter listViewAdapter;
    private List<Component> my_list;
    private Component c1,c2,c3,c4,c5,c6,c7,c8,c9;
    private GridViewAdapter gridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_list = new ArrayList<Component>();
        createComponents();

        //set of layouts for the views
        listview = (ViewStub) findViewById(R.id.list);
        gridview = (ViewStub) findViewById(R.id.grid);
     //   menu = (ContextMenu) findViewById(R.menu.menu_main);

        //inflate the layouts
        listview.inflate();
        gridview.inflate();

        //set of layouts for the list/grid
        list = (ListView) findViewById(R.id.list);
        grid = (GridView) findViewById(R.id.grid);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //Item Exit
        if (id == R.id.exit) {
            System.exit(0);
        }

        //Item Change View
        else if(id == R.id.change_view) {
            changeView();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onResume() {
        super.onResume();

        Log.v(TAG, "onResume");
        changeView();
    }


    /**
     * Method to change the current view
     */
    private void changeView() {

        //if the current view is the listview, passes to gridview
        if(list_visibile) {
            listview.setVisibility(View.GONE);
            gridview.setVisibility(View.VISIBLE);
            list_visibile = false;
            setAdapters();
        }

        else {
            gridview.setVisibility(View.GONE);
            listview.setVisibility(View.VISIBLE);
            list_visibile = true;
            setAdapters();
        }

    }

    /**
     * Method to set the adapters for the view
     */
    private void setAdapters() {

        if(list_visibile) {
            listViewAdapter = new ListViewAdapter(this,R.layout.component_list, my_list);
            list.setAdapter(listViewAdapter);
        }

        else {
            gridViewAdapter = new GridViewAdapter(this,R.layout.component_grid, my_list);
            grid.setAdapter(gridViewAdapter);
        }

    }


    /**
     * Method to create basic components for the example
     */
    private void createComponents() {

        c1 = new Component("Component1","subtitle 1");
        c2 = new Component("Component2","subtitle 2");
        c3 = new Component("Component3","subtitle 3");
        c4 = new Component("Component4","subtitle 4");
        c5 = new Component("Component5","subtitle 5");
        c6 = new Component("Component6","subtitle 6");
        c7 = new Component("Component7","subtitle 7");
        c8 = new Component("Component8","subtitle 8");
        c9 = new Component("Component9","subtitle 9");

        my_list.add(c1);
        my_list.add(c2);
        my_list.add(c3);
        my_list.add(c4);
        my_list.add(c5);
        my_list.add(c6);
        my_list.add(c7);
        my_list.add(c8);
        my_list.add(c9);
    }
}
