package com.example.advancedcalculator.module.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.advancedcalculator.R;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/30
 * </pre>
 */
public class CurrencyViewHolder extends RecyclerView.ViewHolder{
    public TextView mTvCoinTitle;
    public TextView mTvCoinSubTitle;

    public CurrencyViewHolder(View itemView){
        super(itemView);

        mTvCoinTitle = itemView.findViewById(R.id.tv_coin_title);
        mTvCoinSubTitle = itemView.findViewById(R.id.tv_coin_subtitle);
    }
}
