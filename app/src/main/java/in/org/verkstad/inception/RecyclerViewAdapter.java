package in.org.verkstad.inception;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by anu on 3/21/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    LayoutInflater inflater;
    String[] name;

    public RecyclerViewAdapter(Context context,String[] name){
        inflater=LayoutInflater.from(context);
        this.name = name;



    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.popup_contacts_row,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String name1 = name[position];
        holder.contacts_name.setText(name1);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView contacts_name;
        ImageView contacts_image;
        public ViewHolder(View itemView) {
            super(itemView);
            contacts_name= (TextView) itemView.findViewById(R.id.contacts_name);
            contacts_image= (ImageView) itemView.findViewById(R.id.contacts_image);
        }
    }
}

