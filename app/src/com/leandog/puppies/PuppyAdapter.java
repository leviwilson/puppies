package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.setText;

import java.util.List;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.google.android.imageloader.ImageLoader;
import com.leandog.puppies.R.id;
import com.leandog.puppies.R.layout;
import com.leandog.puppies.data.Puppy;
import com.leandog.puppies.view.ViewHelper;

public class PuppyAdapter extends ArrayAdapter<Puppy> {

    private List<Puppy> thePuppies;
    private ImageLoader imageLoader;

    public PuppyAdapter(final Context context, final List<Puppy> thePuppies) {
        super(context, layout.puppy_item, thePuppies);
        this.thePuppies = thePuppies;
        imageLoader = new ImageLoader();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View theView = convertView;

        if (null == theView) {
            final LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            theView = inflater.inflate(layout.puppy_item, null);
        }

        final Puppy thePuppy = thePuppies.get(position);
        setText(theView, id.name, thePuppy.getName());
        setText(theView, id.summary, Html.fromHtml(thePuppy.getDescription()));
        setText(theView, id.breed, thePuppy.getBreed());
        setText(theView, id.gender, thePuppy.getGender());

        final ImageView headshot = ViewHelper.findFor(theView, id.headshot);
        imageLoader.bind(headshot, "http://puppies.herokuapp.com/assets/" + thePuppy.getImage(), null);
        return theView;
    }

}
