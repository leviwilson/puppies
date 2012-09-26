package com.leandog.puppies;

import static com.leandog.puppies.view.ViewHelper.setText;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.leandog.puppies.R.id;
import com.leandog.puppies.R.layout;
import com.leandog.puppies.data.Puppy;

public class PuppyAdapter extends ArrayAdapter<Puppy> {
    
    private List<Puppy> thePuppies;

    public PuppyAdapter(final Context context, final List<Puppy> thePuppies) {
        super(context, layout.puppy_item, thePuppies);
        this.thePuppies = thePuppies;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View theView = convertView;
        
        if( null == theView) {
            final LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            theView = inflater.inflate(layout.puppy_item, null);
        }
        
        final Puppy thePuppy = thePuppies.get(position);
        setText(theView, id.name, thePuppy.getName());
        setText(theView, id.breed, thePuppy.getBreed());
        setText(theView, id.gender, thePuppy.getGender());
        return theView;
    }
    
}
