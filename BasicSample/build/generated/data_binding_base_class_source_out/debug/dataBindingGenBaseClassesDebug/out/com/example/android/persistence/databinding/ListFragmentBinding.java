package com.example.android.persistence.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ListFragmentBinding extends ViewDataBinding {
  @NonNull
  public final TextView loadingTv;

  @NonNull
  public final RecyclerView productsList;

  @NonNull
  public final AppCompatEditText productsSearchBox;

  @NonNull
  public final ImageButton productsSearchBtn;

  @Bindable
  protected boolean mIsLoading;

  protected ListFragmentBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView loadingTv, RecyclerView productsList,
      AppCompatEditText productsSearchBox, ImageButton productsSearchBtn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.loadingTv = loadingTv;
    this.productsList = productsList;
    this.productsSearchBox = productsSearchBox;
    this.productsSearchBtn = productsSearchBtn;
  }

  public abstract void setIsLoading(boolean isLoading);

  public boolean getIsLoading() {
    return mIsLoading;
  }

  @NonNull
  public static ListFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ListFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ListFragmentBinding>inflate(inflater, com.example.android.persistence.R.layout.list_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static ListFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ListFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ListFragmentBinding>inflate(inflater, com.example.android.persistence.R.layout.list_fragment, null, false, component);
  }

  public static ListFragmentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ListFragmentBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ListFragmentBinding)bind(component, view, com.example.android.persistence.R.layout.list_fragment);
  }
}
