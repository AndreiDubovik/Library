package by.ormedia.library.domain;

import java.io.Serializable;

import by.ormedia.library.core.ILibraryItem;
import by.ormedia.library.core.IReader;

public abstract class LibraryItem implements ILibraryItem{
	
	private static long ID_COUNTER;
	private long id;
	private String name;
	private IReader holder;
	
	public LibraryItem(String name){
		this.name = name;
		this.id = ID_COUNTER++;
	}

	@Override
	public Serializable getId() {
		return this.id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public void busy(IReader reader) {
		this.holder = reader;
		reader.hold(this);
	}

	@Override
	public void free() {
		if(this.holder==null)return;
		this.holder.read(this);
		this.holder = null;
	}

	@Override
	public boolean isFree() {
		// TODO Auto-generated method stub
		return this.holder==null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibraryItem other = (LibraryItem) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
