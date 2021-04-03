package com.example.kotlindemo.view.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FloatLayout extends ViewGroup {

    //存放容器中的所有view
    private List<List<View>> mAllView = new ArrayList<List<View>>();
    //存放每一行最高的view的高度
    private List<Integer> mPreMaxLinHeight = new ArrayList<>();


    public FloatLayout(Context context) {
        super(context);
    }

    public FloatLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        super.generateLayoutParams(p);
        return new MarginLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        super.generateLayoutParams(attrs);
        return new MarginLayoutParams(getContext(), attrs);
    }

    //摆放控件
    // 1、表示改viewGroup的位置或者大小发生变化
    //2、3.4.5的控件位置
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        mAllView.clear();
        mPreMaxLinHeight.clear();
        //存放每一行的子view
        List<View> lineView = new ArrayList<>();
        //记录每一行已存放的views的宽度
        int totalLineWidth = 0;
        //记录每一行最高view的高度
        int lineMaxHeight = 0;
        //遍历所有view 将view放到List<List<View>>集合中
        //获得子view的总个数
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {

            View childView = getChildAt(i);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childView.getLayoutParams();
            int childWidth = childView.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int childHeight = childView.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;

            if (totalLineWidth + childWidth > getWidth()) {
                mAllView.add(lineView);
                mPreMaxLinHeight.add(lineMaxHeight);
                //开启新的一行
                totalLineWidth = 0;
                lineMaxHeight = 0;
                lineView = new ArrayList<>();
            }

            totalLineWidth += childWidth;
            lineView.add(childView);
            lineMaxHeight = Math.max(lineMaxHeight, childHeight);
        }

        //单独处理最后一行
        mAllView.add(lineView);
        mPreMaxLinHeight.add(lineMaxHeight);
        //表示一个view和父容器左边的距离
        int mLeft = 0;
        //表示view和父容器顶部的距离
        int mTop = 0;
        for (int i = 0; i < mAllView.size(); i++) {

            //获得每一行所有的view
            lineView = mAllView.get(i);
            lineMaxHeight = mPreMaxLinHeight.get(i);
            for (int j = 0; j < lineView.size(); j++) {

                View childView = lineView.get(j);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childView.getLayoutParams();

                int leftChild = mLeft + marginLayoutParams.leftMargin;
                int topChild = mTop + marginLayoutParams.topMargin;
                int rightChild = leftChild + childView.getMeasuredWidth();
                int bottomChild = topChild + childView.getMeasuredHeight();

                //四个参数分别表示 view的左上角和右下角
                childView.layout(leftChild, topChild, rightChild, bottomChild);
                mLeft += marginLayoutParams.leftMargin + childView.getMeasuredWidth() + marginLayoutParams.rightMargin;

            }
            mLeft = 0;
            mTop += lineMaxHeight;
        }
    }

    //测量控件的宽高
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //获得宽高和测量模式和测量值
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        //获的容器中的子view
        int childCount = getChildCount();
        //记录每一行view的宽度
        int totalLineWidth = 0;
        //记录每一行view的高度
        int preMaxLineHeight = 0;
        //记录当前viewGroup的高度
        int totalHeight = 0;

        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            //对子view进行测量
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams layoutParams = (MarginLayoutParams) childView.getLayoutParams();
            //获得子view的测量宽度
            int widthChild = childView.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            //获得子view的测量高度
            int heightChild = childView.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (totalLineWidth + widthChild > widthMeasureSpec) {
                //统计总高度
                totalHeight += preMaxLineHeight;
                //开启新的一行
                totalLineWidth = widthChild;
                preMaxLineHeight = heightChild;

            } else {
                //记录每一行的总宽度
                totalLineWidth += widthChild;
                //比较每一行最高的高度
                preMaxLineHeight = Math.max(preMaxLineHeight, heightChild);
            }
            //当改view是最后一个view的时候,将改行的最大高度添加到totalHeight中
            if (i == childCount - 1) {
                totalHeight += preMaxLineHeight;
            }
            //若果高度的测量模式 是ExACtly 则高度用测量值  否则用计算出来的总高度
            heightSize = heightMode == MeasureSpec.EXACTLY ? heightSize : totalHeight;
            setMeasuredDimension(widthSize, heightSize);
        }
    }
}
