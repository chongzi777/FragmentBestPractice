package com.example.se7en.fragmentbestpractice;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 新闻内容碎片
 * Created by se7en on 2016/1/27.
 */
public class NewsContentFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }

    /**
     * 新闻条目切换时，刷新数据
     * @param newsTitle
     * @param newsContent
     */
    public void refresh(String newsTitle,String newsContent){
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        TextView newsTitleView = (TextView)view.findViewById(R.id.news_content_title);
        newsTitleView.setText(newsTitle);
        TextView newsContentView = (TextView)view.findViewById(R.id.news_content_content);
        newsContentView.setText(newsContent);
        visibilityLayout.setVisibility(View.VISIBLE);
    }
}
