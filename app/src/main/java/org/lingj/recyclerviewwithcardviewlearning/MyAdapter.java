package org.lingj.recyclerviewwithcardviewlearning;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    /*Object and inflater declaration*/
    private List<NatureModel> objectList;
    private LayoutInflater inflater;

    /*Constructor making, object and inflater initialization*/
    public MyAdapter(Context context, List<NatureModel> objectList){
        inflater = LayoutInflater.from(context);
        this.objectList = objectList;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        /*To make view by inflating view group according to list_item*/
        View view = inflater.inflate(R.layout.list_item,viewGroup,false);

        /*Hold the view by a view holder and return the expected output*/
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        /*To get object one by one by position i*/
        NatureModel current = objectList.get(i);

        /*set the holder data according to object and their position*/
        myViewHolder.setData(current,i);

        /*To make responsive the holder.*/
        myViewHolder.setListeners();
    }

    @Override
    public int getItemCount() {

        /*The number of recyclerview items(object) present*/
        return objectList.size();
    }

    /*RecyclerView.ViewHolder extended class used as general type
    * format. Variable initialization ,declaration, function call etc.*/
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /*Initialization attributes and (object & poistion)*/
        private TextView title;
        private ImageView image,delete,add;
        private int position;
        private NatureModel currentObject;


        /*Initialization in MyViewHolder constructor*/
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tit);
            image = itemView.findViewById(R.id.img);
            delete = itemView.findViewById(R.id.delete);
            add = itemView.findViewById(R.id.add);
        }

        /*set value or assigning value to attributes and object & position*/
        public void setData(NatureModel currentObject, int i) {
            this.title.setText(currentObject.getTitle());
            this.image.setImageResource(currentObject.getImageId());
            this.position = i;
            this.currentObject = currentObject;
        }

        /*To make images responsive*/
        public void setListeners() {
            delete.setOnClickListener(MyViewHolder.this);
            add.setOnClickListener(MyViewHolder.this);
            image.setOnClickListener(MyViewHolder.this);
        }

        /*perform action according to clicking element*/

        @Override
            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.delete:
                        removeItem(position);
                        break;

                    case R.id.add:
                        addItem(position,currentObject);
                        break;
                }
        }

        private void removeItem(int position) {
            objectList.remove(position);
            //after removing item, list show by updating
            notifyItemRemoved(position);
            //For updating the objectlist and counter
            notifyItemRangeChanged(position,objectList.size());
            //For getting the effect of animation
            notifyDataSetChanged();
        }

        private void addItem(int position, NatureModel currentObject) {

            objectList.add(position,currentObject);
            notifyItemInserted(position);
            notifyItemRangeChanged(position,objectList.size());
            notifyDataSetChanged();
        }
    }
}
