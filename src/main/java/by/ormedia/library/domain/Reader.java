package by.ormedia.library.domain;

import java.io.Serializable;

import by.ormedia.library.core.IReader;

public class Reader implements IReader{
	
	private static long ID_COUNTER; 

	private String name;
	private long id;
	
	public Reader(String name){
		this.name = name;
		this.id = ID_COUNTER++;
	}
	
	@Override
	public Serializable getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Reader other = (Reader) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
