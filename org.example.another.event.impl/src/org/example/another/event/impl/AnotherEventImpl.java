package org.example.another.event.impl;

import org.example.event.Event;
import org.osgi.service.component.annotations.*;

@Component
public class AnotherEventImpl implements Event{

	@Override
	public void event() {
		// TODO Auto-generated method stub
		System.out.println("another event");
	}

	// TODO: class provided by template

}
