package com.leandog.puppies;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.*;
import android.view.View.OnClickListener;

import com.leandog.puppies.R.id;

public class PuppiesActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puppies);
        findViewById(id.view_puppies).setOnClickListener(new OnViewPuppiesListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_puppies, menu);
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

    private final class OnViewPuppiesListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(PuppiesActivity.this, PuppiesListActivity.class));
        }
    }

}
