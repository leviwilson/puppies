package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.findFor;

import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.google.gson.Gson;
import com.leandog.puppies.R.id;
import com.leandog.puppies.R.layout;
import com.leandog.puppies.data.PuppiesLoader;
import com.leandog.puppies.data.Puppy;

public class PuppiesListActivity extends Activity {

    private ListView thePuppiesList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_puppies_list);

        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(layout.happy_banner);

        thePuppiesList = findFor(PuppiesListActivity.this, id.the_puppies_list);
        thePuppiesList.setOnItemClickListener(new OnViewPuppyDetails());
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

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<Puppy> doInBackground(PuppiesLoader... loader) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return loader[0].load();
        }

        @Override
        protected void onPostExecute(List<Puppy> thePuppies) {
            super.onPostExecute(thePuppies);
            PuppiesListActivity.this.findViewById(id.progress).setVisibility(View.GONE);
            thePuppiesList.setAdapter(new PuppyAdapter(PuppiesListActivity.this, thePuppies));
        }
    }

    private final class OnViewPuppyDetails implements OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final Puppy thePuppy = (Puppy) thePuppiesList.getAdapter().getItem(position);
            final Intent detailsIntent = new Intent(PuppiesListActivity.this, PuppyDetailsactivity.class);
            detailsIntent.putExtra("ThePuppy", new Gson().toJson(thePuppy));
            startActivity(detailsIntent);
        }
    }

}
