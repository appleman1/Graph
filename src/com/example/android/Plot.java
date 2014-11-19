package com.example.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Plot extends View {
    float[] L={12,23,34,65};
    private DataAdapter<Float> mAdapter;

    {
        setDataAdapter(null);
    }

    public Plot(Context context) {
        super(context);
    }

    public Plot(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Plot(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mAdapter != null) {
            return;
        }
        // заливка канвы цветом
        canvas.drawARGB(80, 102, 204, 255);

        List<Float> list = mAdapter.getData();
        Paint paint = new Paint();
        Path path = new Path();
        // очистка path
        path.reset();
        // настройка кисти
        // толщина линии = 10
        paint.setStrokeWidth(10);
        paint.setARGB(255, 255, 255, 255);
        // переход в указаную точку
        path.moveTo(100, 100);

        path.lineTo(150,150);
        path.lineTo(300,300);
        /*
        for (int i=0;i<=list.size();i++) {
            //canvas.drawLine(0, 0, (float) i, 0, paint);
            path.lineTo(i,list.get(i));
        }*/
        Log.d("plot", canvas.toString());
    }

    protected void onMeasure(int width, int height) {
        super.onMeasure(100, 100);
    }

    public void setDataAdapter(DataAdapter<Float> adapter) {

        mAdapter = new DataAdapter<Float>() {

            @Override
            public List<Float> getData() {
                List<Float> list = new Vector<Float>();
                for(int i = 0; i<4;i++)
                list.add(L[i]);
                return list;
            }
        };
    }

    interface DataAdapter<T> {
         public List<T> getData();
    }
}
