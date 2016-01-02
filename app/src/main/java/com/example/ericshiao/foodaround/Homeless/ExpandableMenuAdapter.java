package com.example.ericshiao.foodaround.Homeless;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ericshiao.foodaround.Food;
import com.example.ericshiao.foodaround.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Eric on 12/31/2014.
 */

/*
Expandable list adapter for the menu in the RestuarantActivity
 */
public abstract class ExpandableMenuAdapter extends BaseExpandableListAdapter {

 /*   private Activity context;
    private Map<String, List<Food>> food;
    private List<String> courses;

    public ExpandableMenuAdapter(Activity context, List<String> courses, Map<String, List<Food>> food) {
        this.context = context;
        this.courses = courses;
        this.food = food;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String course = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_menu, null);
        }
        ExpandableListView list = (ExpandableListView) parent;
        list.expandGroup(groupPosition);
        TextView courseType = (TextView) convertView.findViewById(R.id.course_type);
        courseType.setText(course);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final Food f = (Food) getChild(groupPosition, childPosition);
        //final View convertViewDummy = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.expandable_list_menu_children, null);
        }
        TextView foodName = (TextView) convertView.findViewById(R.id.foodName);
        TextView foodDetails = (TextView) convertView.findViewById(R.id.foodDetail);
        TextView foodPrice = (TextView) convertView.findViewById(R.id.foodPrice);
        final CheckBox foodEaten = (CheckBox) convertView.findViewById(R.id.foodEaten);
        final CheckBox thumbsUp = (CheckBox) convertView.findViewById(R.id.thumbsUp);
        final CheckBox thumbsDown = (CheckBox) convertView.findViewById(R.id.thumbsDown);

        foodName.setText(f.name);
        foodDetails.setText(f.description);
        foodPrice.setText(f.price);

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

        if (f.eaten == 1) {
            foodEaten.setChecked(true);
        } else {
            foodEaten.setChecked(false);
        }

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
            };
        });
        return convertView;
    }


    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.courses.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return courses.size();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return food.get(courses.get(groupPosition)).get(childPosition);
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return food.get(courses.get(groupPosition)).size();
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
*/
}
