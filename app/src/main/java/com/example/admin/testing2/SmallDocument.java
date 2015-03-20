package com.example.admin.testing2;

import android.util.JsonReader;

import java.io.IOException;

/**
 * Created by admin on 20.03.15.
 */
public class SmallDocument {
    private int _id = 0;
    private String _title = "";
    private int _parent = 0;
    private boolean _empty = false;
    private boolean _deleted = false;
    private long _publishedon = 0;
    /**********************************/
    private String _image = "";
    private String _coach = "";
    private String _price = "";
    private String _format = "";
    /**********************************/
    public SmallDocument(JsonReader r) throws IOException {
        initWJ(r);
    }
    private void initWJ(JsonReader reader) throws IOException {
       // JsonReader reader = new JsonReader(new StringReader(jsonstr));
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                _id = reader.nextInt();
            } else if (name.equals("pagetitle")) {
                _title = reader.nextString();
            } else if (name.equals("parent")) {
                _parent = reader.nextInt();
            } else if (name.equals("empty")) {
                _empty = reader.nextBoolean();
            } else if (name.equals("deleted")) {
                _deleted = reader.nextBoolean();
            } else if (name.equals("publishedon")) {
                _publishedon = reader.nextLong();
            } else if (name.equals("image")) {
                _image = reader.nextString();
            } else if (name.equals("coach")) {
                _coach = reader.nextString();
            } else if (name.equals("price")) {
                _price = reader.nextString();
            } else if (name.equals("format")){
                _format = reader.nextString();
            } else reader.skipValue();
        }
        reader.endObject();
    }
    private SmallDocument() {

    }
    public static SmallDocument root() {
        SmallDocument sd = new SmallDocument();
        sd._id = 0;
        sd._title = "Меню";
        sd._empty = true;
        sd._deleted = false;
        sd._publishedon = 0;
        return sd;
    }
    public int getID() {
        return _id;
    }
    public String getTitle() {
        return _title;
    }
    public int getParent() {
        return _parent;
    }
    public boolean isEmpty() {
        return _empty;
    }
    public boolean isDeleted() {
        return _deleted;
    }
    public long getPublishedOn() {
        return _publishedon;
    }
    public boolean needed() {
        return !isEmpty() && !isDeleted();
    }
    /*************************************/
    public String getImage() {
        return _image;
    }
    public String getCoach() {
        return _coach;
    }
    public String getPrice() {
        return _price;
    }
    public String getFormat() {
        return _format;
    }
    /**************************************/
}
