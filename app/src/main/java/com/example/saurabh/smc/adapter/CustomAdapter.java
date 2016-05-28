package com.example.saurabh.smc.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.saurabh.smc.ListModels.RowItem;
import com.example.saurabh.smc.R;

import java.util.List;

/**
 * Created by Saurabh on 5/26/2016.
 */
public class CustomAdapter extends BaseAdapter {

    Context context;
    RowItem tempValues=null;
    List<RowItem> rowItem;

    public CustomAdapter(Context context, List<RowItem> rowItem) {
        this.context = context;
        this.rowItem = rowItem;

    }

    @Override
    public int getCount() {

        return rowItem.size();
    }

    @Override
    public Object getItem(int position) {

        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position) {

        return rowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        if (convertView == null) {
//            LayoutInflater mInflater = (LayoutInflater) context
//                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//            convertView = mInflater.inflate(R.layout.list_item, null);
//        }
//
//        //ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
//        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
//
//        RowItem row_pos = rowItem.get(position);
//        // setting the image resource and title
//        //imgIcon.setImageResource(row_pos.getIcon());
//        txtTitle.setText(row_pos.getTitle());
        View vi = convertView;
        ViewHolder holder;

        if(convertView==null){

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            vi = mInflater.inflate(R.layout.list_item, null);


            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();
            holder.text = (TextView) vi.findViewById(R.id.textView4);
           // holder.text1=(TextView)vi.findViewById(R.id.text1);
            //holder.image=(ImageView)vi.findViewById(R.id.image);

            /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else
            holder=(ViewHolder)vi.getTag();

        if(rowItem.size()<=0)
        {
            holder.text.setText("No Data");

        }
        else
        {
            /***** Get each Model object from Arraylist ********/
            tempValues=null;
            tempValues = ( RowItem ) rowItem.get( position );

            /************  Set Model values in Holder elements ***********/
            if(holder.text!= null){
            holder.text.setText( tempValues.getTitle() );}
           // holder.text1.setText( tempValues.getUrl() );
            //holder.image.setImageResource(
              //      res.getIdentifier(
                //            "com.androidexample.customlistview:drawable/"+tempValues.getImage()
                  //          ,null,null));

            /******** Set Item Click Listner for LayoutInflater for each row *******/


        }
        return vi;



    }
}
 class ViewHolder{

    public TextView text;
    //public TextView text1;
    //public TextView textWide;
   // public ImageView image;

}
