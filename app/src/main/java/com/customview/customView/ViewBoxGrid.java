package com.customview.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.customview.R;

/**
 * Created by suresh on 2/1/17.
 */

public class ViewBoxGrid extends ViewGroup {

    private static final int DEFAULT_COUNT = 4;
    private int columnCount;

    private Paint mGridPaint;
    private int maxChildren;

    public ViewBoxGrid(Context context) {

        this(context, null, 0);
    }

    public ViewBoxGrid(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewBoxGrid(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ViewBoxGrid, 0, defStyleAttr);

        int strokeWidth = array.getDimensionPixelSize(R.styleable.ViewBoxGrid_seperatorWidth, 0);

        columnCount = array.getInt(R.styleable.ViewBoxGrid_numberOfColumns, DEFAULT_COUNT);

        maxChildren = columnCount * columnCount;

        array.recycle();

        mGridPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mGridPaint.setStyle(Paint.Style.STROKE);
        mGridPaint.setColor(Color.BLACK);
        mGridPaint.setStrokeWidth(strokeWidth);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        //Let the framework do its thing
        super.dispatchDraw(canvas);

        //Draw the grid lines
        for (int i = 0; i <= getWidth(); i += (getWidth() / columnCount)) {
            canvas.drawLine(i, 0, i, getHeight(), mGridPaint);
        }
        for (int i = 0; i <= getHeight(); i += (getHeight() / columnCount)) {
            canvas.drawLine(0, i, getWidth(), i, mGridPaint);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int row, col, left, top;
        for (int i = 0; i < getChildCount(); i++) {
            row = i / columnCount;
            col = i % columnCount;

            View child = getChildAt(i);

            left = col * child.getMeasuredWidth();
            top = row * child.getMeasuredHeight();

            child.layout(left, top, left + child.getMeasuredWidth(), top + child.getMeasuredHeight());
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize, heightSize;

        //Get the width based on the measure specs
        widthSize = getDefaultSize(0, widthMeasureSpec);

        //Get the height based on measure specs
        heightSize = getDefaultSize(0, heightMeasureSpec);

        int majorDimension = Math.min(widthSize, heightSize);

        //Measure all child views
        int blockDimension = majorDimension / columnCount;
        int blockSpec = MeasureSpec.makeMeasureSpec(blockDimension, MeasureSpec.EXACTLY);
        measureChildren(blockSpec, blockSpec);

        //MUST call this to save our own dimensions
        setMeasuredDimension(majorDimension, majorDimension);
    }

    @Override
    public void addView(View child) {
        if (getChildCount() > maxChildren - 1) {
            throw new IllegalStateException("BoxView cannot have more than " + maxChildren + " direct children");
        }

        super.addView(child);
    }

    @Override
    public void addView(View child, int index) {
        if (getChildCount() > maxChildren - 1) {
            throw new IllegalStateException("BoxView cannot have more than " + maxChildren + " direct children");
        }

        super.addView(child, index);
    }

    @Override
    public void addView(View child, int index, LayoutParams params) {
        if (getChildCount() > maxChildren - 1) {
            throw new IllegalStateException("BoxView cannot have more than " + maxChildren + " direct children");
        }

        super.addView(child, index, params);
    }

    @Override
    public void addView(View child, LayoutParams params) {
        if (getChildCount() > maxChildren - 1) {
            throw new IllegalStateException("BoxView cannot have more than " + maxChildren + " direct children");
        }

        super.addView(child, params);
    }

    @Override
    public void addView(View child, int width, int height) {
        if (getChildCount() > maxChildren - 1) {
            throw new IllegalStateException("BoxView cannot have more than " + maxChildren + " direct children");
        }

        super.addView(child, width, height);
    }
}
