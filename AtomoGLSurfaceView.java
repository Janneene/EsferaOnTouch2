package com.example.jann.appmoleculas;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

/**
 * Created by Jann on 10/04/2017.
 */

public class AtomoGLSurfaceView extends GLSurfaceView {
    private AtomoRenderer mRenderer;

    public AtomoGLSurfaceView(Context context){
        super(context);
    }


    // Hides superclass method.
    public void setRenderer(AtomoRenderer renderer){
        mRenderer = renderer;
        super.setRenderer(renderer);
    }
}