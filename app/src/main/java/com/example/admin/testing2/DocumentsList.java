package com.example.admin.testing2;
import java.util.ArrayList;
/**
 * Created by admin on 20.03.15.
 */
public class DocumentsList {
    private ArrayList<SmallDocument> docs;
    private DocTree tree;
    public DocTree getTree() {
        return tree;
    }
    public ArrayList<SmallDocument> asCollection() { return docs;}
}
