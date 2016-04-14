package cn.lcg.java8.chapter1;

import java.util.ArrayList;
import java.util.List;

public abstract class AnimalChapter {
    
    protected List<Zoo> zoos;
    protected List<Keeper> keepers;
    
    public AnimalChapter() {
        zoos = new ArrayList<Zoo>();
        keepers = new ArrayList<Keeper>();
        loadData("");
    }
    
    private void loadData(String data) {
        
    }
}
