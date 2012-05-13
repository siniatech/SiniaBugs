package com.siniatech.siniabugs.viewModel.api;

import com.siniatech.siniabugs.model.api.IModelObject;

public interface IViewModelObject<MO extends IModelObject> extends IModelObject {

    public String getCurrentUserName();

}
