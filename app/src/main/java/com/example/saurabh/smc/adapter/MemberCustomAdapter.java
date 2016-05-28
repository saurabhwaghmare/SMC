package com.example.saurabh.smc.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.example.saurabh.smc.ListModels.MemberModel;
import com.example.saurabh.smc.R;

import java.util.List;

/**
 * Created by Saurabh on 5/27/2016.
 */
public class MemberCustomAdapter extends BaseAdapter {

    Context context;
    MemberModel tempValues=null;
    List<MemberModel> MemberItems;

    public MemberCustomAdapter(Context context, List<MemberModel> MemberItems) {
        this.context = context;
        this.MemberItems = MemberItems;

    }

    @Override
    public int getCount() {

        return MemberItems.size();
    }

    @Override
    public Object getItem(int position) {

        return MemberItems.get(position);
    }

    @Override
    public long getItemId(int position) {

        return MemberItems.indexOf(getItem(position));
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
//        MemberItems row_pos = MemberItems.get(position);
//        // setting the image resource and title
//        //imgIcon.setImageResource(row_pos.getIcon());
//        txtTitle.setText(row_pos.getTitle());
        View vi = convertView;
        MemberViewHolder holder;

        if(convertView==null){

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            vi = mInflater.inflate(R.layout.member_list_item, null);


            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new MemberViewHolder();
            holder.name = (TextView) vi.findViewById(R.id.mem_name_tv);
            holder.desig = (TextView) vi.findViewById(R.id.mem_desig_tv);
            holder.num = (TextView) vi.findViewById(R.id.mem_num_tv);
            holder.icon = (ImageView) vi.findViewById(R.id.mem_iv);

            // holder.text1=(TextView)vi.findViewById(R.id.text1);
            //holder.image=(ImageView)vi.findViewById(R.id.image);

            /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else
            holder=(MemberViewHolder)vi.getTag();

        if(MemberItems.size()<=0)
        {
            holder.name.setText("No Data");

        }
        else
        {
            /***** Get each Model object from Arraylist ********/
            tempValues=null;
            tempValues = ( MemberModel ) MemberItems.get( position );

            /************  Set Model values in Holder elements ***********/

            holder.name.setText( tempValues.getName() );
            holder.desig.setText( tempValues.getdesig() );
            holder.num.setText( tempValues.getNum() );

            //get first letter of each String item
            String firstLetter = String.valueOf(tempValues.getName().charAt(0));

            ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
            // generate random color
            int color = generator.getColor(getItem(position));
            //int color = generator.getRandomColor();

            TextDrawable drawable = TextDrawable.builder()
                    .buildRound(firstLetter, color); // radius in px

            holder.icon.setImageDrawable(drawable);
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
class MemberViewHolder{

    public TextView name;
    public TextView desig;
    public TextView num;
    public ImageView icon;


    //public TextView text1;
    //public TextView textWide;
    // public ImageView image;

}
