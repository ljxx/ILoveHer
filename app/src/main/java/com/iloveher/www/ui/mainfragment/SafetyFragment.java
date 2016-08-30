package com.iloveher.www.ui.mainfragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iloveher.www.R;
import com.iloveher.www.ui.base.BaseFragment;
import com.iloveher.www.ui.widget.MyGridView;

public class SafetyFragment extends BaseFragment {

    private MyGridView mGridView;
    private String[] mModules;
    private GridViewAdapter mAdapter;

    @Override
    protected int inflateView() {
        return R.layout.fragment_safety;
    }

    @Override
    protected void initView() {
        mGridView = (MyGridView) mView.findViewById(R.id.mGridView);
        mModules = mContext.getResources().getStringArray(R.array.safer_modules);
        mAdapter = new GridViewAdapter();
        mGridView.setAdapter(mAdapter);
    }

    @Override
    protected void initListen() {

    }

    private class GridViewAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mModules.length;
        }

        @Override
        public Object getItem(int position) {
            return mModules[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            view = View.inflate(mContext,R.layout.safety_gridview_item,null);
            TextView mtext = (TextView) view.findViewById(R.id.mModuleName);
            mtext.setText(mModules[position]);
            return view;
        }


    }
}
