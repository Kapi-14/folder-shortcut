package com.foldershortcut.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.foldershortcut.app.R;
import com.foldershortcut.app.model.FolderItem;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: FolderAdapter.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0014\u0010\u0017\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/foldershortcut/app/adapter/FolderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/foldershortcut/app/adapter/FolderAdapter$ViewHolder;", "items", "", "Lcom/foldershortcut/app/model/FolderItem;", "onItemClick", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "formatFileSize", "", "bytes", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateList", "newList", "ViewHolder", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class FolderAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<FolderItem> items;
    private final Function1<FolderItem, Unit> onItemClick;

    /* JADX WARN: Multi-variable type inference failed */
    public FolderAdapter(List<FolderItem> items, Function1<? super FolderItem, Unit> onItemClick) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.items = items;
        this.onItemClick = onItemClick;
    }

    /* compiled from: FolderAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/foldershortcut/app/adapter/FolderAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "imgIcon", "Landroid/widget/ImageView;", "getImgIcon", "()Landroid/widget/ImageView;", "txtDetails", "Landroid/widget/TextView;", "getTxtDetails", "()Landroid/widget/TextView;", "txtName", "getTxtName", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgIcon;
        private final TextView txtDetails;
        private final TextView txtName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.imgFolderIcon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.imgIcon = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.txtFolderName);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.txtName = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.txtFolderDetails);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.txtDetails = (TextView) findViewById3;
        }

        public final ImageView getImgIcon() {
            return this.imgIcon;
        }

        public final TextView getTxtName() {
            return this.txtName;
        }

        public final TextView getTxtDetails() {
            return this.txtDetails;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_folder_browser, parent, false);
        Intrinsics.checkNotNull(view);
        return new ViewHolder(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final FolderItem item = this.items.get(position);
        Context context = holder.itemView.getContext();
        holder.getTxtName().setText(item.getName());
        if (item.isFolder()) {
            holder.getImgIcon().setImageResource(R.drawable.ic_folder);
            holder.getImgIcon().setColorFilter(ContextCompat.getColor(context, R.color.primary));
            holder.getTxtDetails().setText("Folder");
        } else {
            holder.getImgIcon().setImageResource(R.drawable.ic_file);
            holder.getImgIcon().setColorFilter(ContextCompat.getColor(context, R.color.text_secondary));
            holder.getTxtDetails().setText(formatFileSize(item.getSizeBytes()));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.adapter.FolderAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FolderAdapter.onBindViewHolder$lambda$0(FolderAdapter.this, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(FolderAdapter this$0, FolderItem item, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.onItemClick.invoke(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final void updateList(List<FolderItem> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        this.items = newList;
        notifyDataSetChanged();
    }

    private final String formatFileSize(long bytes) {
        if (bytes <= 0) {
            return "0 B";
        }
        String[] units = {"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(bytes) / Math.log10(1024.0d));
        double d = bytes;
        double pow = Math.pow(1024.0d, digitGroups);
        Double.isNaN(d);
        double count = d / pow;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.1f %s", Arrays.copyOf(new Object[]{Double.valueOf(count), units[digitGroups]}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
