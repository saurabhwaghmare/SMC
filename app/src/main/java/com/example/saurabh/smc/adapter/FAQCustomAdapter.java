package com.example.saurabh.smc.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saurabh.smc.ListModels.FaqModel;
import com.example.saurabh.smc.R;

import java.util.List;

/**
 * Created by Saurabh on 6/2/2016.
 */
public class FAQCustomAdapter extends RecyclerView.Adapter<FAQCustomAdapter.QAViewHolder> {

    public static class QAViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView Q;
        TextView A;

        QAViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            Q = (TextView)itemView.findViewById(R.id.FAQ_Q_tv);
            A = (TextView)itemView.findViewById(R.id.FAQ_A_tv);
        }
    }

    List<FaqModel> qanda;

    public FAQCustomAdapter(List<FaqModel> qanda){
        this.qanda = qanda;
    }

    @Override
    public int getItemCount() {
        return qanda.size();
    }
    @Override
    public QAViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.faq_item, viewGroup, false);
        QAViewHolder qavh = new QAViewHolder(v);
        return qavh;
    }
    @Override
    public void onBindViewHolder(QAViewHolder qaViewHolder, int i) {
        qaViewHolder.Q.setText("Q: "+qanda.get(i).getQ());
        qaViewHolder.A.setText("A: "+qanda.get(i).getA());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
