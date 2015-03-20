package com.example.admin.testing2;
import android.util.JsonReader;

import java.io.IOException;
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
    private void initWJ(JsonReader r) throws IOException {
        int i=0;
        while(!r.nextName().equals("total") || i++<500){r.skipValue();}//i чтобы не улететь в бесконечный цикл
        i=0;
        int count = r.nextInt();
        docs = new ArrayList<SmallDocument>(count);
        while(!r.nextName().equals("results") || i++<500){r.skipValue();}//i чтобы не улететь в бесконечный цикл
        int j=0;
        r.beginArray();
        while(r.hasNext()) {
            docs.add(new SmallDocument(r));
        }
        r.endArray();
        tree = new DocTree(SmallDocument.root());
        tree.addrange(docs);
    }
}
