package com.minnathon.stresskiller;
import java.io.Serializable;

/**
 * Created by Anh on 1/20/2018.
 */

public class Quote implements Serializable {
    private int Id;
    private String Type;
    private String Link;

    public Quote(String Type, String Link){
        this.Type = Type;
        this.Link = Link;
    }
    public Quote(int Id, String Type, String Link) {
        this.Id= Id;
        this.Type = Type;
        this.Link= Link;
    }

    public String getType(){
        return this.Type;
    }
    public String getLink(){
        return this.Link;
    }

}