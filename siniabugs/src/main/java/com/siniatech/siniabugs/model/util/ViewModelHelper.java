package com.siniatech.siniabugs.model.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.siniatech.siniabugs.model.api.IModelObject;
import com.siniatech.siniabugs.viewModel.api.IViewModelObject;

public class ViewModelHelper {

    private final Map<Class<?>, Class<?>> modelToViewModelClassMap;

    public ViewModelHelper( Map<Class<?>, Class<?>> modelToViewModelClassMap ) {
        this.modelToViewModelClassMap = modelToViewModelClassMap;
    }

    public <T extends IModelObject, U extends IViewModelObject<T>> Collection<U> createViewModelObjects( Collection<T> modelObjects ) {
        List<U> viewModelObjects = new ArrayList<U>();
        for ( T modelObject : modelObjects ) {
            viewModelObjects.add( this.<T, U> createViewModelObject( modelObject ) );
        }
        return viewModelObjects;
    }

    public <T extends IModelObject, U extends IViewModelObject<T>> U createViewModelObject( T modelObject ) {
        Class<?> viewModelClass = modelToViewModelClassMap.get( modelObject.getClass() );
        if ( viewModelClass == null ) {
            throw newMissingMappingException( modelObject );
        }
        Constructor<?> constructor = viewModelClass.getConstructors()[0];
        try {
            return (U) constructor.newInstance( modelObject );
        } catch ( InstantiationException e ) {
            throw newMissingMappingException( modelObject );
        } catch ( IllegalAccessException e ) {
            throw newMissingMappingException( modelObject );
        } catch ( IllegalArgumentException e ) {
            throw newMissingMappingException( modelObject );
        } catch ( InvocationTargetException e ) {
            throw newMissingMappingException( modelObject );
        }
    }

    private <T extends IModelObject> RuntimeException newMissingMappingException( T modelObject ) {
        return new IllegalStateException( "No model-view model class mapping registered for " + modelObject );
    }
}
