package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.findFor;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.leandog.puppies.R.id;
import com.leandog.puppies.data.PuppiesLoader;

public class PuppiesListActivity extends Activity {

    private final PuppiesLoader puppiesLoader;
    
    public PuppiesListActivity() {
        puppiesLoader = new PuppiesLoader();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puppies_list);
        
        final ListView thePuppiesList = findFor(this, id.the_puppies_list);
        thePuppiesList.setAdapter(new PuppyAdapter(this, puppiesLoader.load()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_puppies_list, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
