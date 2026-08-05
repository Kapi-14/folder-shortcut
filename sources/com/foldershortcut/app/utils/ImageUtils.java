package com.foldershortcut.app.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Base64;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.foldershortcut.app.model.ShortcutModel;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUtils.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J \u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\tJ \u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\tJ\"\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\tJ\u000e\u0010\"\u001a\u00020#*\u0004\u0018\u00010\u0007H\u0002¨\u0006$"}, d2 = {"Lcom/foldershortcut/app/utils/ImageUtils;", "", "()V", "applyShapeMask", "Landroid/graphics/Bitmap;", "src", "shape", "", "targetSize", "", "base64ToBitmap", "base64Str", "createShortcutBitmap", "context", "Landroid/content/Context;", "model", "Lcom/foldershortcut/app/model/ShortcutModel;", "sizePx", "drawFolderBadgeOverlay", "", "canvas", "Landroid/graphics/Canvas;", "canvasSize", "getShapePath", "Landroid/graphics/Path;", "size", "", "scaleDown", "realImage", "maxImageSize", "uriToBase64", "uri", "Landroid/net/Uri;", "maxSizePx", "isNull_or_Empty", "", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ImageUtils {
    public static final ImageUtils INSTANCE = new ImageUtils();

    private ImageUtils() {
    }

    public static /* synthetic */ String uriToBase64$default(ImageUtils imageUtils, Context context, Uri uri, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 512;
        }
        return imageUtils.uriToBase64(context, uri, i);
    }

    public final String uriToBase64(Context context, Uri uri, int maxSizePx) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            InputStream inputStream = context.getContentResolver().openInputStream(uri);
            if (inputStream == null) {
                return null;
            }
            Bitmap originalBitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            if (originalBitmap == null) {
                return null;
            }
            Bitmap scaled = scaleDown(originalBitmap, maxSizePx);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            scaled.compress(Bitmap.CompressFormat.PNG, 90, outputStream);
            byte[] bytes = outputStream.toByteArray();
            return Base64.encodeToString(bytes, 2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final Bitmap base64ToBitmap(String base64Str) {
        if (isNull_or_Empty(base64Str)) {
            return null;
        }
        try {
            byte[] decodedBytes = Base64.decode(base64Str, 0);
            return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final boolean isNull_or_Empty(String $this$isNull_or_Empty) {
        if ($this$isNull_or_Empty != null) {
            return $this$isNull_or_Empty.length() == 0;
        }
        return true;
    }

    public final Bitmap scaleDown(Bitmap realImage, int maxImageSize) {
        Intrinsics.checkNotNullParameter(realImage, "realImage");
        int width = realImage.getWidth();
        int height = realImage.getHeight();
        if (width <= maxImageSize && height <= maxImageSize) {
            return realImage;
        }
        float ratio = width / height;
        int newWidth = maxImageSize;
        int newHeight = maxImageSize;
        if (ratio > 1.0f) {
            newHeight = (int) (maxImageSize / ratio);
        } else {
            newWidth = (int) (maxImageSize * ratio);
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(realImage, newWidth, newHeight, true);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(...)");
        return createScaledBitmap;
    }

    public static /* synthetic */ Bitmap createShortcutBitmap$default(ImageUtils imageUtils, Context context, ShortcutModel shortcutModel, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 192;
        }
        return imageUtils.createShortcutBitmap(context, shortcutModel, i);
    }

    public final Bitmap createShortcutBitmap(Context context, ShortcutModel model, int sizePx) {
        Bitmap personalBmp;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        Bitmap output = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(output, "createBitmap(...)");
        Canvas canvas = new Canvas(output);
        if (Intrinsics.areEqual(model.getIconType(), ShortcutModel.ICON_TYPE_PERSONAL) && !isNull_or_Empty(model.getPersonalImageBase64()) && (personalBmp = base64ToBitmap(model.getPersonalImageBase64())) != null) {
            Bitmap masked = applyShapeMask(personalBmp, model.getShapeMask(), sizePx);
            canvas.drawBitmap(masked, 0.0f, 0.0f, (Paint) null);
            drawFolderBadgeOverlay(context, canvas, sizePx);
            return output;
        }
        Paint bgPaint = new Paint(1);
        bgPaint.setColor(model.getIconBgColor());
        bgPaint.setStyle(Paint.Style.FILL);
        Path shapePath = getShapePath(model.getShapeMask(), sizePx);
        canvas.drawPath(shapePath, bgPaint);
        Integer valueOf = Integer.valueOf(context.getResources().getIdentifier(model.getPresetIconName(), "drawable", context.getPackageName()));
        int it = valueOf.intValue();
        if (!(it != 0)) {
            valueOf = null;
        }
        int iconResId = valueOf != null ? valueOf.intValue() : context.getResources().getIdentifier("ic_folder", "drawable", context.getPackageName());
        Drawable drawable = ContextCompat.getDrawable(context, iconResId);
        Drawable drawable2 = drawable != null ? drawable.mutate() : null;
        if (drawable2 != null) {
            DrawableCompat.setTint(drawable2, model.getIconTintColor());
            int iconMargin = sizePx / 4;
            drawable2.setBounds(iconMargin, iconMargin, sizePx - iconMargin, sizePx - iconMargin);
            drawable2.draw(canvas);
        }
        return output;
    }

    private final void drawFolderBadgeOverlay(Context context, Canvas canvas, int canvasSize) {
        int badgeSize = canvasSize / 3;
        int badgeMargin = canvasSize / 16;
        int badgeLeft = (canvasSize - badgeSize) - badgeMargin;
        int badgeTop = (canvasSize - badgeSize) - badgeMargin;
        Paint bgPaint = new Paint(1);
        bgPaint.setColor(-10262799);
        bgPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(badgeLeft + (badgeSize / 2.0f), badgeTop + (badgeSize / 2.0f), badgeSize / 2.0f, bgPaint);
        int iconResId = context.getResources().getIdentifier("ic_folder", "drawable", context.getPackageName());
        Drawable drawable = ContextCompat.getDrawable(context, iconResId);
        Drawable drawable2 = drawable != null ? drawable.mutate() : null;
        if (drawable2 != null) {
            DrawableCompat.setTint(drawable2, -1);
            int iconPadding = badgeSize / 6;
            drawable2.setBounds(badgeLeft + iconPadding, badgeTop + iconPadding, (badgeLeft + badgeSize) - iconPadding, (badgeTop + badgeSize) - iconPadding);
            drawable2.draw(canvas);
        }
    }

    public final Bitmap applyShapeMask(Bitmap src, String shape, int targetSize) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Bitmap scaledSrc = Bitmap.createScaledBitmap(src, targetSize, targetSize, true);
        Intrinsics.checkNotNullExpressionValue(scaledSrc, "createScaledBitmap(...)");
        Bitmap output = Bitmap.createBitmap(targetSize, targetSize, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(output, "createBitmap(...)");
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint(1);
        Path path = getShapePath(shape, targetSize);
        canvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(scaledSrc, 0.0f, 0.0f, paint);
        return output;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Path getShapePath(String shape, float size) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Path path = new Path();
        float r = size / 2.0f;
        switch (shape.hashCode()) {
            case 1128412:
                if (shape.equals(ShortcutModel.SHAPE_SQUIRCLE)) {
                    RectF rect = new RectF(4.0f, 4.0f, size - 4.0f, size - 4.0f);
                    float rx = 0.35f * size;
                    path.addRoundRect(rect, rx, rx, Path.Direction.CW);
                    break;
                }
                RectF rect2 = new RectF(4.0f, 4.0f, size - 4.0f, size - 4.0f);
                path.addRoundRect(rect2, 12.0f, 12.0f, Path.Direction.CW);
                break;
            case 2555474:
                if (shape.equals(ShortcutModel.SHAPE_STAR)) {
                    float outerRadius = r - 4.0f;
                    float innerRadius = 0.45f * outerRadius;
                    for (int i = 0; i < 10; i++) {
                        float radius = i % 2 == 0 ? outerRadius : innerRadius;
                        double angle = Math.toRadians((i * 36) - 90);
                        double d = r;
                        double d2 = radius;
                        double cos = Math.cos(angle);
                        Double.isNaN(d2);
                        Double.isNaN(d);
                        float x = (float) (d + (d2 * cos));
                        double d3 = r;
                        double d4 = radius;
                        double sin = Math.sin(angle);
                        Double.isNaN(d4);
                        Double.isNaN(d3);
                        float y = (float) (d3 + (d4 * sin));
                        if (i == 0) {
                            path.moveTo(x, y);
                        } else {
                            path.lineTo(x, y);
                        }
                    }
                    path.close();
                    break;
                }
                RectF rect22 = new RectF(4.0f, 4.0f, size - 4.0f, size - 4.0f);
                path.addRoundRect(rect22, 12.0f, 12.0f, Path.Direction.CW);
                break;
            case 1534444032:
                if (shape.equals(ShortcutModel.SHAPE_HEXAGON)) {
                    float radius2 = r - 4.0f;
                    for (int i2 = 0; i2 < 6; i2++) {
                        double angle2 = Math.toRadians((i2 * 60) - 30);
                        double d5 = r;
                        double d6 = radius2;
                        double cos2 = Math.cos(angle2);
                        Double.isNaN(d6);
                        Double.isNaN(d5);
                        float x2 = (float) (d5 + (d6 * cos2));
                        double d7 = r;
                        double d8 = radius2;
                        double sin2 = Math.sin(angle2);
                        Double.isNaN(d8);
                        Double.isNaN(d7);
                        float y2 = (float) (d7 + (d8 * sin2));
                        if (i2 == 0) {
                            path.moveTo(x2, y2);
                        } else {
                            path.lineTo(x2, y2);
                        }
                    }
                    path.close();
                    break;
                }
                RectF rect222 = new RectF(4.0f, 4.0f, size - 4.0f, size - 4.0f);
                path.addRoundRect(rect222, 12.0f, 12.0f, Path.Direction.CW);
                break;
            case 1988079824:
                if (shape.equals(ShortcutModel.SHAPE_CIRCLE)) {
                    path.addCircle(r, r, r - 4.0f, Path.Direction.CW);
                    break;
                }
                RectF rect2222 = new RectF(4.0f, 4.0f, size - 4.0f, size - 4.0f);
                path.addRoundRect(rect2222, 12.0f, 12.0f, Path.Direction.CW);
                break;
            case 2103451277:
                if (shape.equals(ShortcutModel.SHAPE_ROUNDED)) {
                    RectF rect3 = new RectF(4.0f, 4.0f, size - 4.0f, size - 4.0f);
                    float rx2 = 0.2f * size;
                    path.addRoundRect(rect3, rx2, rx2, Path.Direction.CW);
                    break;
                }
                RectF rect22222 = new RectF(4.0f, 4.0f, size - 4.0f, size - 4.0f);
                path.addRoundRect(rect22222, 12.0f, 12.0f, Path.Direction.CW);
                break;
            default:
                RectF rect222222 = new RectF(4.0f, 4.0f, size - 4.0f, size - 4.0f);
                path.addRoundRect(rect222222, 12.0f, 12.0f, Path.Direction.CW);
                break;
        }
        return path;
    }
}
