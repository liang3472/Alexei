package com.kimo.lib.alexei.calculus;

import android.graphics.Bitmap;

import com.kimo.lib.alexei.Calculus;
import com.kimo.lib.alexei.Utils;
import com.kimo.lib.alexei.algorithms.Quantize;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kimo on 8/18/14.
 */
public class ColorPallete extends Calculus<List<Integer>> {

    public static final int NUMBER_OF_COLORS = 10;

    private List<Integer> mColorPallete;

    public ColorPallete(Bitmap image) {
        super(image);
    }

    @Override
    protected List<Integer> theCalculation(Bitmap image) {
        mColorPallete = new ArrayList<Integer>();

        int [][] pixelsMatrix = Utils.getPixelsMatrixFromBitmap(image);
        int [] calculatedPallete = Quantize.quantizeImage(pixelsMatrix, NUMBER_OF_COLORS);

        for(int x = 0; x < calculatedPallete.length; x++)
            mColorPallete.add(new Integer(calculatedPallete[x]));

        return mColorPallete;
    }

}