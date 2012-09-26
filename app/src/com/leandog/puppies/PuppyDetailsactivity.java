package com.leandog.puppies;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;
import com.leandog.puppies.R.id;
import com.leandog.puppies.data.Puppy;

import static com.leandog.puppies.view.ViewHelper.*;

public class PuppyDetailsactivity extends Activity {

    private Puppy thePuppy;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puppy_detailsactivity);
        thePuppy = new Gson().fromJson(getIntent().getStringExtra("ThePuppy"), Puppy.class);
        
        setText(this, id.name, thePuppy.getName());
        setText(this, id.breed, thePuppy.getBreed());
        
        final TextView theDescription = findFor(this, id.description);
        theDescription.setText(Html.fromHtml(thePuppy.getDescription()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_puppy_detailsactivity, menu);
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
