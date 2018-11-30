package org.example.event.admin;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.example.event.Event;
import org.osgi.framework.BundleContext;

public class EventActivator extends DependencyActivatorBase
{

    @Override
    public void init(BundleContext aInBundleContext,
            DependencyManager aInDependencyManager) throws Exception
    {
        aInDependencyManager.add(createComponent()
                .setInterface(Object.class.getName(), null)
                .setImplementation(EventAdmin.class)
                .add(createServiceDependency()
                        .setService(Event.class)
                        .setCallbacks("addEvent", "removeEvent"))
        );
    }

	

}