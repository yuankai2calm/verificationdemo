// Generated code from Butter Knife. Do not modify!
package com.example.yuankai2calm.localverificationdemo;

import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TextStyleShow_ViewBinding<T extends TextStyleShow> implements Unbinder {
  protected T target;

  private View view2131427448;

  @UiThread
  public TextStyleShow_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.textShow = Utils.findRequiredViewAsType(source, R.id.tv_text_view, "field 'textShow'", TextView.class);
    target.sharePicture = Utils.findRequiredViewAsType(source, R.id.iv_image_view, "field 'sharePicture'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.ibtn_share, "method 'onClick'");
    view2131427448 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });

    Resources res = source.getResources();
    target.text = res.getString(R.string.text_style_content);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.textShow = null;
    target.sharePicture = null;

    view2131427448.setOnClickListener(null);
    view2131427448 = null;

    this.target = null;
  }
}
