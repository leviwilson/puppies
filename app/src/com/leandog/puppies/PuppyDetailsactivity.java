package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.findFor;
import static com.leandog.puppies.view.ViewHelper.setText;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.imageloader.ImageLoader;
import com.google.gson.Gson;
import com.leandog.puppies.R.id;
import com.leandog.puppies.data.Puppy;

public class PuppyDetailsactivity extends Activity {

    private Puppy thePuppy;
    private ImageLoader imageLoader;
    
    public PuppyDetailsactivity() {
        imageLoader = new ImageLoader();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puppy_detailsactivity);
        thePuppy = new Gson().fromJson(getIntent().getStringExtra("ThePuppy"), Puppy.class);
        
        setText(this, id.name, thePuppy.getName());
        setText(this, id.breed, thePuppy.getBreed());
        
        final TextView theDescription = findFor(this, id.description);
        theDescription.setText(Html.fromHtml(thePuppy.getDescription()));
        
        final ImageView headshot = findFor(this, id.headshot);
        imageLoader.bind(headshot, "http://puppies.herokuapp.com/assets/" + thePuppy.getImage(), null);
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
