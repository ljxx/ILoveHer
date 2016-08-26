package com.iloveher.www.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.iloveher.www.R;
import com.iloveher.www.library.banner.ConvenientBanner;
import com.iloveher.www.library.banner.holder.CBViewHolderCreator;
import com.iloveher.www.library.banner.holder.Holder;
import com.iloveher.www.ui.base.BaseFragment;
import com.iloveher.www.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment {

    private List<String> mImageUrl = new ArrayList<String>();
    private void initList(){
        mImageUrl.add("http://img5.cdn.zhao-cloud.com/2016/05/11/1450289680_HN3591.JPG");
        mImageUrl.add("http://img5.cdn.zhao-cloud.com/2016/03/11/1434262368_评32建党A.jpg");
        mImageUrl.add("http://img5.cdn.zhao-cloud.com/2016/05/06/1402169969_HN4743_1.jpg");
        mImageUrl.add("http://img5.cdn.zhao-cloud.com/2016/05/11/1510077902_SS1356.JPG");
        mImageUrl.add("http://img5.cdn.zhao-cloud.com/2016/05/11/1543567028_HN4142.JPG");
        mImageUrl.add("http://img5.cdn.zhao-cloud.com/2016/05/11/1510077902_SS1356.JPG");
        mImageUrl.add("http://img5.cdn.zhao-cloud.com/2016/05/13/1334550160_SS1423.JPG");
        mImageUrl.add("http://img5.cdn.zhao-cloud.com/2016/05/30/1437083920_HN5187.JPG");
        mImageUrl.add("http://img3.cdn.zhao-cloud.com/2016/23/216332002A.jpg");
        mImageUrl.add("http://img3.cdn.zhao-cloud.com/2016/23/216332003A.jpg");
        mImageUrl.add("http://img3.cdn.zhao-cloud.com/2016/23/216332006A.jpg");
        mImageUrl.add("http://img3.cdn.zhao-cloud.com/2016/23/216332006B.jpg");
        mImageUrl.add("http://img3.cdn.zhao-cloud.com/2016/23/216332006C.jpg");
        mImageUrl.add("http://img3.cdn.zhao-cloud.com/2016/23/216332005B.jpg");
    }

    private ConvenientBanner mBannerViewPager;
    private TextView mCenter;

    @Override
    protected int inflateView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        mBannerViewPager = (ConvenientBanner) mView.findViewById(R.id.mBannerViewPager);
        mCenter = (TextView) mView.findViewById(R.id.mCenter);
        mCenter.setText("What are you dong ?");
        initList();
        mBannerViewPager.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new LocalImageHolderView();
            }
        },mImageUrl)//设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.banner_uncheck, R.drawable.banner_check})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
        //设置翻页的效果，不需要翻页效果可用不设
        /*.setPageTransformer(Transformer.DefaultTransformer)*/;    //集成特效之后会有白屏现象，新版已经分离，如果要集成特效的例子可以看Demo的点击响应。
//        convenientBanner.setManualPageable(false);//设置不能手动影响;

    }

    private class LocalImageHolderView implements Holder<String> {

        private SimpleDraweeView simpleDraweeView;

        @Override
        public View createView(Context context) {
//            View view = View.inflate(getActivity(),R.layout.banner_viewpager,null);
            simpleDraweeView = new SimpleDraweeView(getActivity());
            simpleDraweeView.setScaleType(ImageView.ScaleType.FIT_XY);
            return simpleDraweeView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            simpleDraweeView.setImageURI(Uri.parse(StringUtils.encode(data)));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mBannerViewPager.startTurning(3000);
    }

    @Override
    public void onPause() {
        super.onPause();
        mBannerViewPager.stopTurning();
    }
}
