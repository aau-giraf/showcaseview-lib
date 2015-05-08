/*
 * Copyright 2014 Alex Curran
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * NOTICE: This file has been modified in order to enable custom size of the showcase and
 * custom positioning of text.
 */

package dk.aau.cs.giraf.showcaseview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by curraa01 on 13/10/2013.
 */
class NewShowcaseDrawer extends StandardShowcaseDrawer {

    private static final int ALPHA_60_PERCENT = 153;
    private float outerRadius;
    private float innerRadius;

    public NewShowcaseDrawer(Resources resources) {
        super(resources);
    }

    @Override
    public void setShowcaseColour(int color) {
        eraserPaint.setColor(color);
    }

    @Override
    public void drawShowcase(Bitmap buffer, float x, float y, float innerRadius, float scaleMultiplier) {
        Canvas bufferCanvas = new Canvas(buffer);

        eraserPaint.setAlpha(ALPHA_60_PERCENT);
        bufferCanvas.drawCircle(x, y, this.outerRadius * scaleMultiplier, eraserPaint);
        eraserPaint.setAlpha(0);
        bufferCanvas.drawCircle(x, y, this.innerRadius * scaleMultiplier, eraserPaint);
    }

    public void setInnerRadius(float innerRadius) {
        this.innerRadius = innerRadius;
        this.outerRadius = (innerRadius * 4) / 3;
    }

    @Override
    public int getShowcaseWidth() {
        return (int) (outerRadius * 2);
    }

    @Override
    public int getShowcaseHeight() {
        return (int) (outerRadius * 2);
    }

    @Override
    public float getBlockedRadius() {
        return innerRadius;
    }

    @Override
    public void setBackgroundColour(int backgroundColor) {
        this.backgroundColour = backgroundColor;
    }
}
