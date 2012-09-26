package com.leandog.puppies.data;

public class Puppy {

    @SuppressWarnings("unused")
    private class PuppyInfo {
        String breed;
        String created_at;
        String description;
        String fees;
        String gender;
        String id;
        String image_url;
        String name;
        String updated_at;
    }

    private PuppyInfo puppy;

    public String getName() {
        return puppy.name;
    }

    public String getBreed() {
        return puppy.breed;
    }

    public String getGender() {
        return puppy.gender;
    }

    public String getDescription() {
        return puppy.description;
    }
}
