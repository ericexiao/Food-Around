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

    Food food;
    TextView foodName;
    TextView foodDescription;
    TextView foodPrice;
    CheckBox foodEaten;
    CheckBox thumbsUp;
    CheckBox thumbsDown;

    //constants for user adjustables
    final int CONSTANT_UNEATEN = 0;
    final int CONSTANT_EATEN = 1;
    final int CONSTANT_THUMBSUP = 1;
    final int CONSTANT_NO_RATING = 0;
    final int CONSTANT_THUMBSDOWN = -1;

    public MenuListAdapter(Context context, ArrayList<Food> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_menu, parent, false);
        }

        viewSetup(convertView);

        final Food food = getItem(position);

        foodName.setText(food.name);
        foodDescription.setText(food.description);
        foodPrice.setText(food.price);
        foodEatenSetup(food);
        foodEatenListenerSetup(food);
        foodRatingSetup(food);
        foodRatingListenerSetup(food);

        return convertView;
    }

    public void viewSetup(View convertView) {
        foodName = (TextView) convertView.findViewById(R.id.foodName);
        foodDescription = (TextView) convertView.findViewById(R.id.foodDetail);
        foodPrice = (TextView) convertView.findViewById(R.id.foodPrice);
        foodEaten = (CheckBox) convertView.findViewById(R.id.foodEaten);
        thumbsUp = (CheckBox) convertView.findViewById(R.id.thumbsUp);
        thumbsDown = (CheckBox) convertView.findViewById(R.id.thumbsDown);

    }

    public void foodEatenSetup(final Food f) {
        if (f.eaten == 1) {
            foodEaten.setChecked(true);
        } else {
            foodEaten.setChecked(false);
        }
    }

    public void foodEatenListenerSetup(final Food f) {
        foodEaten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (f.eaten == 0) {
                    f.eaten = 1;
                    Toast eatenMessage = Toast.makeText(context, f.name + " eaten!", Toast.LENGTH_SHORT);
                    eatenMessage.show();
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
            };
        });
    }

    public void foodRatingSetup(Food f) {
        if (f.rating == 1) {
            thumbsUp.setChecked(true);
            thumbsDown.setChecked(false);
        } else if (f.rating == 0) {
            thumbsDown.setChecked(true);
            thumbsUp.setChecked(false);
        } else {
            thumbsUp.setChecked(false);
            thumbsDown.setChecked(false);
        }
    }

    public void foodRatingListenerSetup(final Food f) {
        thumbsUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (f.rating == 1) {
                    f.rating = -1;
                    notifyDataSetChanged();
                } else {
                    f.rating = 1;
                    notifyDataSetChanged();
                }
            }
        });

        thumbsDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (f.rating == 0) {
                    f.rating = -1;
                    notifyDataSetChanged();
                } else {
                    f.rating = 0;
                    notifyDataSetChanged();
                }
            }
        });
    }
}
