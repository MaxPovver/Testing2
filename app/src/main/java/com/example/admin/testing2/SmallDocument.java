package com.example.admin.testing2;

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
