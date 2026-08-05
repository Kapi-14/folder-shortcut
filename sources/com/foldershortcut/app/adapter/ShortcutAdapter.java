package com.foldershortcut.app.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.foldershortcut.app.R;
import com.foldershortcut.app.model.ShortcutModel;
import com.foldershortcut.app.utils.ImageUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShortcutAdapter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018Bc\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0014\u0010\u0016\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/foldershortcut/app/adapter/ShortcutAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/foldershortcut/app/adapter/ShortcutAdapter$ViewHolder;", "shortcuts", "", "Lcom/foldershortcut/app/model/ShortcutModel;", "onShortcutClick", "Lkotlin/Function1;", "", "onEditClick", "onPinClick", "onDeleteClick", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateList", "newList", "ViewHolder", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class ShortcutAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Function1<ShortcutModel, Unit> onDeleteClick;
    private final Function1<ShortcutModel, Unit> onEditClick;
    private final Function1<ShortcutModel, Unit> onPinClick;
    private final Function1<ShortcutModel, Unit> onShortcutClick;
    private List<ShortcutModel> shortcuts;

    /* JADX WARN: Multi-variable type inference failed */
    public ShortcutAdapter(List<ShortcutModel> shortcuts, Function1<? super ShortcutModel, Unit> onShortcutClick, Function1<? super ShortcutModel, Unit> onEditClick, Function1<? super ShortcutModel, Unit> onPinClick, Function1<? super ShortcutModel, Unit> onDeleteClick) {
        Intrinsics.checkNotNullParameter(shortcuts, "shortcuts");
        Intrinsics.checkNotNullParameter(onShortcutClick, "onShortcutClick");
        Intrinsics.checkNotNullParameter(onEditClick, "onEditClick");
        Intrinsics.checkNotNullParameter(onPinClick, "onPinClick");
        Intrinsics.checkNotNullParameter(onDeleteClick, "onDeleteClick");
        this.shortcuts = shortcuts;
        this.onShortcutClick = onShortcutClick;
        this.onEditClick = onEditClick;
        this.onPinClick = onPinClick;
        this.onDeleteClick = onDeleteClick;
    }

    /* compiled from: ShortcutAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/foldershortcut/app/adapter/ShortcutAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "btnDelete", "Landroid/widget/ImageButton;", "getBtnDelete", "()Landroid/widget/ImageButton;", "btnEdit", "getBtnEdit", "btnPin", "getBtnPin", "imgIcon", "Landroid/widget/ImageView;", "getImgIcon", "()Landroid/widget/ImageView;", "txtLabel", "Landroid/widget/TextView;", "getTxtLabel", "()Landroid/widget/TextView;", "txtPath", "getTxtPath", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageButton btnDelete;
        private final ImageButton btnEdit;
        private final ImageButton btnPin;
        private final ImageView imgIcon;
        private final TextView txtLabel;
        private final TextView txtPath;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.imgShortcutIcon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.imgIcon = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.txtShortcutLabel);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.txtLabel = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.txtShortcutPath);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.txtPath = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.btnEditShortcut);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.btnEdit = (ImageButton) findViewById4;
            View findViewById5 = view.findViewById(R.id.btnPinShortcut);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.btnPin = (ImageButton) findViewById5;
            View findViewById6 = view.findViewById(R.id.btnDeleteShortcut);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.btnDelete = (ImageButton) findViewById6;
        }

        public final ImageView getImgIcon() {
            return this.imgIcon;
        }

        public final TextView getTxtLabel() {
            return this.txtLabel;
        }

        public final TextView getTxtPath() {
            return this.txtPath;
        }

        public final ImageButton getBtnEdit() {
            return this.btnEdit;
        }

        public final ImageButton getBtnPin() {
            return this.btnPin;
        }

        public final ImageButton getBtnDelete() {
            return this.btnDelete;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shortcut, parent, false);
        Intrinsics.checkNotNull(view);
        return new ViewHolder(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        String folderUri;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final ShortcutModel item = this.shortcuts.get(position);
        Context context = holder.itemView.getContext();
        holder.getTxtLabel().setText(item.getLabel());
        TextView txtPath = holder.getTxtPath();
        if (item.getFolderPath().length() > 0) {
            folderUri = item.getFolderPath();
        } else {
            folderUri = item.getFolderUri();
            if (folderUri == null) {
                folderUri = "";
            }
        }
        txtPath.setText(folderUri);
        ImageUtils imageUtils = ImageUtils.INSTANCE;
        Intrinsics.checkNotNull(context);
        Bitmap bitmap = imageUtils.createShortcutBitmap(context, item, 128);
        holder.getImgIcon().setImageBitmap(bitmap);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.adapter.ShortcutAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortcutAdapter.onBindViewHolder$lambda$0(ShortcutAdapter.this, item, view);
            }
        });
        holder.getBtnEdit().setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.adapter.ShortcutAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortcutAdapter.onBindViewHolder$lambda$1(ShortcutAdapter.this, item, view);
            }
        });
        holder.getBtnPin().setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.adapter.ShortcutAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortcutAdapter.onBindViewHolder$lambda$2(ShortcutAdapter.this, item, view);
            }
        });
        holder.getBtnDelete().setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.adapter.ShortcutAdapter$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortcutAdapter.onBindViewHolder$lambda$3(ShortcutAdapter.this, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(ShortcutAdapter this$0, ShortcutModel item, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.onShortcutClick.invoke(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(ShortcutAdapter this$0, ShortcutModel item, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.onEditClick.invoke(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(ShortcutAdapter this$0, ShortcutModel item, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.onPinClick.invoke(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3(ShortcutAdapter this$0, ShortcutModel item, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.onDeleteClick.invoke(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.shortcuts.size();
    }

    public final void updateList(List<ShortcutModel> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        this.shortcuts = newList;
        notifyDataSetChanged();
    }
}
