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
import com.foldershortcut.app.model.PresetIcon;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PresetIconAdapter.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B/\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/foldershortcut/app/adapter/PresetIconAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/foldershortcut/app/adapter/PresetIconAdapter$ViewHolder;", "icons", "", "Lcom/foldershortcut/app/model/PresetIcon;", "selectedDrawableName", "", "onSelect", "Lkotlin/Function1;", "", "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelected", "name", "ViewHolder", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes2.dex */
public final class PresetIconAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<PresetIcon> icons;
    private final Function1<PresetIcon, Unit> onSelect;
    private String selectedDrawableName;

    /* JADX WARN: Multi-variable type inference failed */
    public PresetIconAdapter(List<PresetIcon> icons, String selectedDrawableName, Function1<? super PresetIcon, Unit> onSelect) {
        Intrinsics.checkNotNullParameter(icons, "icons");
        Intrinsics.checkNotNullParameter(selectedDrawableName, "selectedDrawableName");
        Intrinsics.checkNotNullParameter(onSelect, "onSelect");
        this.icons = icons;
        this.selectedDrawableName = selectedDrawableName;
        this.onSelect = onSelect;
    }

    /* compiled from: PresetIconAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/foldershortcut/app/adapter/PresetIconAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "container", "getContainer", "()Landroid/view/View;", "imgIcon", "Landroid/widget/ImageView;", "getImgIcon", "()Landroid/widget/ImageView;", "txtName", "Landroid/widget/TextView;", "getTxtName", "()Landroid/widget/TextView;", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes2.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final View container;
        private final ImageView imgIcon;
        private final TextView txtName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.imgPresetIcon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.imgIcon = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.txtPresetName);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.txtName = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.presetContainer);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.container = findViewById3;
        }

        public final ImageView getImgIcon() {
            return this.imgIcon;
        }

        public final TextView getTxtName() {
            return this.txtName;
        }

        public final View getContainer() {
            return this.container;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_preset_icon, parent, false);
        Intrinsics.checkNotNull(view);
        return new ViewHolder(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final PresetIcon item = this.icons.get(position);
        Context context = holder.itemView.getContext();
        holder.getTxtName().setText(item.getName());
        holder.getImgIcon().setImageResource(item.getResId());
        boolean isSelected = Intrinsics.areEqual(item.getDrawableName(), this.selectedDrawableName);
        if (isSelected) {
            holder.getContainer().setBackgroundResource(R.drawable.bg_preset_selected);
            holder.getImgIcon().setColorFilter(ContextCompat.getColor(context, R.color.primary));
        } else {
            holder.getContainer().setBackgroundResource(R.drawable.bg_preset_normal);
            holder.getImgIcon().setColorFilter(ContextCompat.getColor(context, R.color.text_primary));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.foldershortcut.app.adapter.PresetIconAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PresetIconAdapter.onBindViewHolder$lambda$0(PresetIconAdapter.this, item, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(PresetIconAdapter this$0, PresetIcon item, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.selectedDrawableName = item.getDrawableName();
        this$0.notifyDataSetChanged();
        this$0.onSelect.invoke(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.icons.size();
    }

    public final void setSelected(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.selectedDrawableName = name;
        notifyDataSetChanged();
    }
}
