package com.leandog.puppies.data;

import java.util.Arrays;
import java.util.List;

public class PuppiesLoader {

    public List<Puppy> load() {
        return Arrays.asList(new Puppy("Steve"), new Puppy("Harry"));
    }

}
