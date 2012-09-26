package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.findFor;

import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.leandog.puppies.R.id;
import com.leandog.puppies.R.layout;
import com.leandog.puppies.data.PuppiesLoader;
import com.leandog.puppies.data.Puppy;

public class PuppiesListActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_puppies_list);

        new AsyncPuppiesLoader().execute(new PuppiesLoader());
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

    private final class AsyncPuppiesLoader extends AsyncTask<PuppiesLoader, Void, List<Puppy>> {
        
        private ProgressDialog theDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            
            theDialog = ProgressDialog.show(PuppiesListActivity.this, null, "Loading the puppies...");
        }
        
        @Override
        protected List<Puppy> doInBackground(PuppiesLoader... loader) {
            return loader[0].load();
        }

        @Override
        protected void onPostExecute(List<Puppy> thePuppies) {
            theDialog.hide();
            super.onPostExecute(thePuppies);
            final ListView thePuppiesList = findFor(PuppiesListActivity.this, id.the_puppies_list);
            thePuppiesList.setAdapter(new PuppyAdapter(PuppiesListActivity.this, thePuppies));
        }
    }

}
