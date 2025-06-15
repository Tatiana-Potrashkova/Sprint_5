package com.example;

import java.util.List;

public class LionAlex extends Lion {
    private static final String SEX_ALEX = "Самец";
    private static final List<String> FRIENDS = List.of("Марти", "Глория", "Мелман");
    private static final String LIVING_PLACE = "Нью-Йоркский зоопарк";

    public LionAlex(Feline feline) throws Exception {
        super(feline, SEX_ALEX);
    }

    @Override
    public int getKittens(){
        return 0;
    }

    public List<String> getFriends(){
        return FRIENDS;
    }

    public String getPlaceOfLiving(){
        return LIVING_PLACE;
    }
}
