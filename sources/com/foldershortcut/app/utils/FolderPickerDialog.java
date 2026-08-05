package com.foldershortcut.app.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.foldershortcut.app.adapter.FolderAdapter;
import com.foldershortcut.app.databinding.DialogFolderPickerBinding;
import com.foldershortcut.app.model.FolderItem;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FolderPickerDialog.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00126\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\u0010\rJ\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0012\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\fH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R>\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/foldershortcut/app/utils/FolderPickerDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "initialPath", "", "onFolderSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "folderPath", "folderName", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "adapter", "Lcom/foldershortcut/app/adapter/FolderAdapter;", "binding", "Lcom/foldershortcut/app/databinding/DialogFolderPickerBinding;", "currentDir", "Ljava/io/File;", "loadDirectory", "dir", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupUI", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class FolderPickerDialog extends Dialog {
    private FolderAdapter adapter;
    private DialogFolderPickerBinding binding;
    private File currentDir;
    private String initialPath;
    private final Function2<String, String, Unit> onFolderSelected;

    public /* synthetic */ FolderPickerDialog(Context context, String str, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? StorageUtils.INSTANCE.getDefaultStoragePath() : str, function2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FolderPickerDialog(Context context, String initialPath, Function2<? super String, ? super String, Unit> onFolderSelected) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initialPath, "initialPath");
        Intrinsics.checkNotNullParameter(onFolderSelected, "onFolderSelected");
        this.initialPath = initialPath;
        this.onFolderSelected = onFolderSelected;
        File it = new File(this.initialPath);
        it = it.exists() && it.isDirectory() ? it : null;
        this.currentDir = it == null ? new File(StorageUtils.INSTANCE.getDefaultStoragePath()) : it;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        DialogFolderPickerBinding inflate = DialogFolderPickerBinding.inflate(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        DialogFolderPickerBinding dialogFolderPickerBinding = this.binding;
        if (dialogFolderPickerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFolderPickerBinding = null;
        }
        setContentView(dialogFolderPickerBinding.getRoot());
        Window window = getWindow();
        if (window != null) {
            double d = getContext().getResources().getDisplayMetrics().widthPixels;
            Double.isNaN(d);
            window.setLayout((int) (d * 0.92d), -2);
        }
        setupUI();
        loadDirectory(this.currentDir);
    }

    private final void setupUI() {
        DialogFolderPickerBinding dialogFolderPickerBinding = this.binding;
        DialogFolderPickerBinding dialogFolderPickerBinding2 = null;
        if (dialogFolderPickerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFolderPickerBinding = null;
        }
        dialogFolderPickerBinding.recyclerFolderTree.setLayoutManager(new LinearLayoutManager(getContext()));
        this.adapter = new FolderAdapter(CollectionsKt.emptyList(), new Function1<FolderItem, Unit>() { // from class: com.foldershortcut.app.utils.FolderPickerDialog$setupUI$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FolderItem folderItem) {
                invoke2(folderItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FolderItem item) {
                File file;
                Intrinsics.checkNotNullParameter(item, "item");
                if (item.isFolder()) {
                    File nextDir = new File(item.getPath());
                    if (nextDir.exists() && nextDir.canRead()) {
                        FolderPickerDialog.this.currentDir = nextDir;
                        FolderPickerDialog folderPickerDialog = FolderPickerDialog.this;
                        file = FolderPickerDialog.this.currentDir;
                        folderPickerDialog.loadDirectory(file);
                    }
                }
            }
        });
        DialogFolderPickerBinding dialogFolderPickerBinding3 = this.binding;
        if (dialogFolderPickerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFolderPickerBinding3 = null;
        }
        RecyclerView recyclerView = dialogFolderPickerBinding3.recyclerFolderTree;
        FolderAdapter folderAdapter = this.adapter;
        if (folderAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            folderAdapter = null;
        }
        recyclerView.setAdapter(folderAdapter);
        DialogFolderPickerBinding dialogFolderPickerBinding4 = this.binding;
        if (dialogFolderPickerBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFolderPickerBinding4 = null;
        }
        dialogFolderPickerBinding4.btnUpLevel.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.utils.FolderPickerDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FolderPickerDialog.setupUI$lambda$1(FolderPickerDialog.this, view);
            }
        });
        DialogFolderPickerBinding dialogFolderPickerBinding5 = this.binding;
        if (dialogFolderPickerBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFolderPickerBinding5 = null;
        }
        dialogFolderPickerBinding5.btnSelectCurrentFolder.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.utils.FolderPickerDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FolderPickerDialog.setupUI$lambda$2(FolderPickerDialog.this, view);
            }
        });
        DialogFolderPickerBinding dialogFolderPickerBinding6 = this.binding;
        if (dialogFolderPickerBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogFolderPickerBinding2 = dialogFolderPickerBinding6;
        }
        dialogFolderPickerBinding2.btnCancelPicker.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.utils.FolderPickerDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FolderPickerDialog.setupUI$lambda$3(FolderPickerDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$1(FolderPickerDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        File parent = this$0.currentDir.getParentFile();
        if (parent != null && parent.exists() && parent.canRead()) {
            this$0.currentDir = parent;
            this$0.loadDirectory(this$0.currentDir);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$2(FolderPickerDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function2<String, String, Unit> function2 = this$0.onFolderSelected;
        String absolutePath = this$0.currentDir.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        String name = this$0.currentDir.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        function2.invoke(absolutePath, name);
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$3(FolderPickerDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadDirectory(File dir) {
        DialogFolderPickerBinding dialogFolderPickerBinding = this.binding;
        FolderAdapter folderAdapter = null;
        if (dialogFolderPickerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogFolderPickerBinding = null;
        }
        dialogFolderPickerBinding.txtDialogPath.setText(dir.getAbsolutePath());
        List subfolders = new ArrayList();
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    String name = file.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    if (!StringsKt.startsWith$default(name, ".", false, 2, (Object) null)) {
                        String name2 = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                        String absolutePath = file.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                        subfolders.add(new FolderItem(name2, absolutePath, true, 0L, file.lastModified(), null, 32, null));
                    }
                }
            }
        }
        if (subfolders.size() > 1) {
            CollectionsKt.sortWith(subfolders, new Comparator() { // from class: com.foldershortcut.app.utils.FolderPickerDialog$loadDirectory$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    FolderItem it = (FolderItem) t;
                    String lowerCase = it.getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    FolderItem it2 = (FolderItem) t2;
                    String lowerCase2 = it2.getName().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                }
            });
        }
        FolderAdapter folderAdapter2 = this.adapter;
        if (folderAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            folderAdapter = folderAdapter2;
        }
        folderAdapter.updateList(subfolders);
    }
}
