package by.ormedia.library.core;

import by.ormedia.library.controller.Type;

public interface ILibraryItem extends ILibraryObject{
	
	public Type getType();
	public void busy(IReader reader);
	public void free();
	boolean isFree();
}
