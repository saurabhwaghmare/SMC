package com.example.saurabh.smc.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saurabh.smc.ListModels.Meeting_Items;
import com.example.saurabh.smc.R;

import java.util.List;


/**
 * Created by user on 5/27/2016.
 */
public class MeetingAdapter extends BaseAdapter{

    Context context;
    Meeting_Items tempValues=null;
    public int num;
    //    RowItem tempValue1=null;
    List<Meeting_Items> meetingItems;
//    List<RowItem> rowItem1;

    public MeetingAdapter(Context context, List<Meeting_Items> meetingItems) {
        this.context = context;
        this.meetingItems = meetingItems;
//        this.rowItem1 = rowItem1;

    }

    @Override
    public int getCount() {

        return meetingItems.size();
    }

    @Override
    public Object getItem(int position) {

        return meetingItems.get(position);
    }

    @Override
    public long getItemId(int position) {

        return meetingItems.indexOf(getItem(position));
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
        ViewHolder_meeting holder;

        if(convertView==null){

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            vi = mInflater.inflate(R.layout.fragment_meeting, null);


            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder_meeting();
            holder.meetingNumber = (TextView) vi.findViewById(R.id.meeting_number);
            holder.agenda = (TextView) vi.findViewById(R.id.meeting_agenda);
            holder.meetingDate = (TextView) vi.findViewById(R.id.meeting_date);
            holder.meetingMonth = (TextView) vi.findViewById(R.id.meeting_month);
//            holder.meetingYear = (TextView) vi.findViewById(R.id.meeting_year);
            // holder.text1=(TextView)vi.findViewById(R.id.text1);
            //holder.image=(ImageView)vi.findViewById(R.id.image);

            /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else
            holder=(ViewHolder_meeting) vi.getTag();

        if(meetingItems.size()<=0)
        {
            holder.meetingNumber.setText("No Data");

        }
        else
        {
            /***** Get each Model object from Arraylist ********/
            tempValues=null;
            tempValues = (Meeting_Items) meetingItems.get( position );
//            tempValue1 = null;
//            tempValue1 = ( RowItem ) rowItem1.get(position);


            /************  Set Model values in Holder elements ***********/
            if(holder.meetingNumber!= null){
                holder.meetingNumber.setText( tempValues.getMeeting_number() );}

                holder.agenda.setText("In the agenda: "+tempValues.getAgenda());

//                new StringBuilder().append(day).append("/")
                if(tempValues.getMeetingDate().length() == 1){
                    String temp = "0" + tempValues.getMeetingDate();
                    holder.meetingDate.setText(temp);
                }
//                else if(tempValues.getMeetingDate() .equals(2)){
//                    holder.meetingDate.setText("0"+tempValues.getMeetingDate());
//                }
//                else if(tempValues.getMeetingDate() .equals(3)){
//                    holder.meetingDate.setText("0"+tempValues.getMeetingDate());
//                }
//                else if(tempValues.getMeetingDate() .equals(4)){
//                    holder.meetingDate.setText("0"+tempValues.getMeetingDate());
//                }
//                else if(tempValues.getMeetingDate() .equals(5)){
//                    holder.meetingDate.setText("0"+tempValues.getMeetingDate());
//                }
//                else if(tempValues.getMeetingDate() .equals(6)){
//                    holder.meetingDate.setText("0"+tempValues.getMeetingDate());
//                }
//                else if(tempValues.getMeetingDate() .equals(7)){
//                    holder.meetingDate.setText("0"+tempValues.getMeetingDate());
//                }
//                else if(tempValues.getMeetingDate() .equals(8)){
//                    holder.meetingDate.setText("0"+tempValues.getMeetingDate());
//                }
//                else if(tempValues.getMeetingDate() .equals(9)){
//                    holder.meetingDate.setText("0"+tempValues.getMeetingDate());
//                }
                else {
                    holder.meetingDate.setText(tempValues.getMeetingDate());
                }

                holder.meetingMonth.setText(tempValues.getMeetingMonth());
//                holder.meetingYear.setText(tempValues.getMeetingYear());
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

class ViewHolder_meeting{

    public TextView meetingNumber;
    public TextView agenda;
    public TextView meetingDate;
    public TextView meetingMonth;
//    public TextView meetingYear;
    public ImageView image;

}
