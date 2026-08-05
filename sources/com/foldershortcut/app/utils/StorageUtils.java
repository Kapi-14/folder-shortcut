package com.foldershortcut.app.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import androidx.documentfile.provider.DocumentFile;
import com.foldershortcut.app.model.FolderItem;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: StorageUtils.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tJ\"\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0016\u001a\u00020\u0015*\u0004\u0018\u00010\u0004H\u0002¨\u0006\u0017"}, d2 = {"Lcom/foldershortcut/app/utils/StorageUtils;", "", "()V", "getDefaultStoragePath", "", "getMimeTypeFromExtension", "fileName", "getPresetDirectories", "", "Lcom/foldershortcut/app/model/FolderItem;", "getRelativePathFromExternalStorage", "fullPath", "listFilesAndFolders", "context", "Landroid/content/Context;", "folderPath", "folderUriString", "openFile", "", "item", "openFolderInSystemFileManager", "", "isNull_or_Empty", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class StorageUtils {
    public static final StorageUtils INSTANCE = new StorageUtils();

    private StorageUtils() {
    }

    public final String getDefaultStoragePath() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    public final List<FolderItem> getPresetDirectories() {
        File root = Environment.getExternalStorageDirectory();
        List list = new ArrayList();
        List<Pair> presets = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("Internal Storage", root), TuplesKt.to("Downloads", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)), TuplesKt.to("DCIM / Camera", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)), TuplesKt.to("Documents", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)), TuplesKt.to("Pictures", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)), TuplesKt.to("Movies", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)), TuplesKt.to("Music", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC))});
        for (Pair pair : presets) {
            String name = (String) pair.component1();
            File dir = (File) pair.component2();
            if (dir.exists()) {
                String absolutePath = dir.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                list.add(new FolderItem(name, absolutePath, true, 0L, dir.lastModified(), null, 32, null));
            }
        }
        return list;
    }

    public static /* synthetic */ List listFilesAndFolders$default(StorageUtils storageUtils, Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        return storageUtils.listFilesAndFolders(context, str, str2);
    }

    public final List<FolderItem> listFilesAndFolders(Context context, String folderPath, String folderUriString) {
        File[] files;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        List result = new ArrayList();
        if (!isNull_or_Empty(folderUriString)) {
            try {
                Uri uri = Uri.parse(folderUriString);
                DocumentFile docDir = DocumentFile.fromTreeUri(context, uri);
                if (docDir != null && docDir.isDirectory()) {
                    DocumentFile[] listFiles = docDir.listFiles();
                    Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles(...)");
                    for (DocumentFile file : listFiles) {
                        String name = file.getName();
                        if (name == null) {
                            name = "Unknown";
                        }
                        String uri2 = file.getUri().toString();
                        Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
                        result.add(new FolderItem(name, uri2, file.isDirectory(), file.length(), file.lastModified(), file.getUri().toString()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (result.isEmpty()) {
            if (folderPath.length() > 0) {
                File dir = new File(folderPath);
                if (dir.exists() && dir.isDirectory() && (files = dir.listFiles()) != null) {
                    for (File file2 : files) {
                        String name2 = file2.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                        String absolutePath = file2.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                        result.add(new FolderItem(name2, absolutePath, file2.isDirectory(), file2.isDirectory() ? 0L : file2.length(), file2.lastModified(), null, 32, null));
                    }
                }
            }
        }
        return CollectionsKt.sortedWith(result, ComparisonsKt.compareBy(new Function1<FolderItem, Comparable<?>>() { // from class: com.foldershortcut.app.utils.StorageUtils$listFilesAndFolders$1
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(FolderItem it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(!it.isFolder());
            }
        }, new Function1<FolderItem, Comparable<?>>() { // from class: com.foldershortcut.app.utils.StorageUtils$listFilesAndFolders$2
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(FolderItem it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String lowerCase = it.getName().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                return lowerCase;
            }
        }));
    }

    private final boolean isNull_or_Empty(String $this$isNull_or_Empty) {
        if ($this$isNull_or_Empty != null) {
            return $this$isNull_or_Empty.length() == 0;
        }
        return true;
    }

    public static /* synthetic */ boolean openFolderInSystemFileManager$default(StorageUtils storageUtils, Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        return storageUtils.openFolderInSystemFileManager(context, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x01a3 A[Catch: all -> 0x01ca, TRY_LEAVE, TryCatch #5 {all -> 0x01ca, blocks: (B:3:0x002b, B:63:0x003b, B:6:0x005c, B:10:0x006a, B:12:0x0076, B:17:0x00a5, B:20:0x00bc, B:23:0x00cc, B:26:0x0102, B:27:0x0124, B:28:0x019d, B:30:0x01a3, B:33:0x01ab, B:49:0x011f, B:51:0x00f7, B:68:0x0059), top: B:2:0x002b, inners: #0, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean openFolderInSystemFileManager(android.content.Context r21, java.lang.String r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.foldershortcut.app.utils.StorageUtils.openFolderInSystemFileManager(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    private final String getRelativePathFromExternalStorage(String fullPath) {
        String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Intrinsics.checkNotNull(rootPath);
        if (StringsKt.startsWith$default(fullPath, rootPath, false, 2, (Object) null)) {
            String substring = fullPath.substring(rootPath.length());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return StringsKt.removePrefix(substring, (CharSequence) "/");
        }
        return StringsKt.removePrefix(fullPath, (CharSequence) "/");
    }

    public final void openFile(Context context, FolderItem item) {
        Uri uri;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(item, "item");
        try {
            if (item.getUriString() != null) {
                uri = Uri.parse(item.getUriString());
            } else {
                File file = new File(item.getPath());
                if (Build.VERSION.SDK_INT >= 24) {
                    uri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
                } else {
                    uri = Uri.fromFile(file);
                }
            }
            String mimeType = context.getContentResolver().getType(uri);
            if (mimeType == null) {
                mimeType = getMimeTypeFromExtension(item.getName());
            }
            Intrinsics.checkNotNull(mimeType);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uri, mimeType);
            intent.addFlags(268435457);
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(context, "Cannot open file: " + e.getLocalizedMessage(), 0).show();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0018. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0136 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x011b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x014e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x00f7 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0151 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0128 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String getMimeTypeFromExtension(java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.foldershortcut.app.utils.StorageUtils.getMimeTypeFromExtension(java.lang.String):java.lang.String");
    }
}
