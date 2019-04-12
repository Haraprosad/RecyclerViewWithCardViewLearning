package org.lingj.recyclerviewwithcardviewlearning;

import java.util.ArrayList;
import java.util.List;

public class NatureModel {

    /*Recycler view's total attributes declaration*/
    private int imageId;
    private String title;

    /*Getter and setter method set for the attributes.*/

    public int getImageId(){
        return imageId;
    }
    public void setImageId(int imageId){
        this.imageId = imageId;

    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    /*Class's attributes listing method. *List<Class name>*/
    public static List<NatureModel> getObjectList(){

        /*Attributes listing declaration through ArrayList<>
        * In arraylist attributes can be stored properly.*/
        List<NatureModel> dataList = new ArrayList<>();

        /*Initialization the array of images through a method.*/
        int images[] = getImages();

        /*Firstly, attributes binding to make object and then make list
        * of the objects*/
        for(int i = 0;i<images.length;i++){
            NatureModel nature = new NatureModel();
            nature.setImageId(images[i]);
            nature.setTitle("Picture "+i);

            /*To make List by binding the the attributes together.*/
            dataList.add(nature);
        }

        return dataList;
    }

    // All images representation in an array
    private static int[] getImages() {
        int[] images = {R.drawable.a,R.drawable.b,
        R.drawable.c,R.drawable.d,R.drawable.e,
        R.drawable.f,R.drawable.g};
        return images;
    }
}
