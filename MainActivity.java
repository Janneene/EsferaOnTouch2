package com.example.jann.appmoleculas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;

public class MainActivity extends Activity implements OnTouchListener {

    private float YValue;
    private float XValue;
    private AtomoRenderer atomoRenderer;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        GLSurfaceView view = new GLSurfaceView(this);
        atomoRenderer = new AtomoRenderer(true);
        view.setRenderer(atomoRenderer);
        view.setOnTouchListener(this);
        setContentView(view);
    }
    @Override
    protected void onPause(){
        super.onPause();
    }
    @Override
    protected void onResume(){
        super.onResume();
    }

    private static final float TOUCH_SCALE_FACTOR = 0.005f;
    private float mPreviousX;
    private float mPreviousY;

    @Override
    public boolean onTouch(View v, MotionEvent e) {
        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:

                float dx = x - mPreviousX;
                //subtract, so the cube moves the same direction as your finger.
                //with plus it moves the opposite direction.
                atomoRenderer.setX(atomoRenderer.getX() - (dx * TOUCH_SCALE_FACTOR));

                float dy = y - mPreviousY;
                atomoRenderer.setY(atomoRenderer.getY() - (dy * TOUCH_SCALE_FACTOR));
        }

        mPreviousX = x;
        mPreviousY = y;
        return true;
    }
    private float transZ(float y, float transZ) {
        float maxTransZ = -3.0f;
        float minTransZ = -20.0f;
        transZ += (YValue - y) / 100;
        transZ = Math.min(maxTransZ, transZ);
        transZ = Math.max(minTransZ, transZ);
        return transZ;
    }

}