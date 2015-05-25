package com.example.ericshiao.foodaround;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Eric on 5/24/2015.
 */
public class MenuListAdapter extends ArrayAdapter<Food> {

    private Context context;
    private ArrayList<Food> list;

    public MenuListAdapter(Context context, ArrayList<Food> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_restaurant, parent, false);
        }

        TextView foodName = (TextView) convertView.findViewById(R.id.foodName);
        TextView foodDetails = (TextView) convertView.findViewById(R.id.foodDetail);
        TextView foodPrice = (TextView) convertView.findViewById(R.id.foodPrice);
        final CheckBox foodEaten = (CheckBox) convertView.findViewById(R.id.foodEaten);
        final CheckBox thumbsUp = (CheckBox) convertView.findViewById(R.id.thumbsUp);
        final CheckBox thumbsDown = (CheckBox) convertView.findViewById(R.id.thumbsDown);
        final Food f = getItem(position);
        foodName.setText(f.name);
        foodDetails.setText(f.description);
        foodPrice.setText(f.price);

        foodEaten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (f.eaten == 0) {
                    f.eaten = 1;
                    //LayoutInflater popupInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    //PopupWindow popup = new PopupWindow(popupInflater.inflate(R.layout.eaten_popup, null));
                    Toast eatenMessage = Toast.makeText(context, f.name + " eaten!", Toast.LENGTH_SHORT);
                    eatenMessage.show();
                    //popup.showAtLocation(foodEaten, Gravity.CENTER, 0, 0);
                    notifyDataSetChanged();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Uneat?").setNegativeButton("Uneat", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            f.eaten = 0;
                            notifyDataSetChanged();
                        }
                    }).setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            f.eaten = 1;
                            notifyDataSetChanged();
                        }
                    }).setOnCancelListener(new DialogInterface.OnCancelListener() {
                        public void onCancel(DialogInterface dialogInterface) {
                            f.eaten = 1;
                            notifyDataSetChanged();
                        }
                    });
                    builder.show();
                }
            }

            ;
        });
        return convertView;
    }

    public void setImage(ImageView i) {

    }
}
