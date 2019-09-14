package by.ormedia.library.thread;

import java.util.List;

import by.ormedia.library.core.ILibrary;
import by.ormedia.library.core.ILibraryItem;
import by.ormedia.library.core.IReader;

public class LibraryLife extends Thread{

	private ILibrary library;
	private boolean alive = true;
	
	public LibraryLife(ILibrary library){
		this.library = library;
	}
	
	public void run(){
		while(this.alive){
			
			IReader reader = randomReader();
			ILibraryItem freeItem = randomFreeItem();
			ILibraryItem busyItem = randomBusyItem();
			if(busyItem!=null){
				synchronized(busyItem){
					busyItem.free();
				}
			}
			if(reader!=null&&freeItem!=null&&!reader.isRead(freeItem)){
				freeItem.busy(reader);
			}
			try {
				Thread.currentThread().sleep(random(20000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown(){
		this.alive = false;
	}
	
	private IReader randomReader(){
		List<IReader>readers = this.library.getReaders();
		synchronized(readers){
			if(readers.size()==0)return null;
			return readers.get(random(readers.size()-1));
		}
	}
	
	private ILibraryItem randomFreeItem(){
		List<ILibraryItem>items = this.library.getFreeItems();
		synchronized(items){
			if(items.size()==0)return null;
			return items.get(random(items.size()-1));
		}
	}
	
	private ILibraryItem randomBusyItem(){
		List<ILibraryItem>items = this.library.getBusyItems();
		synchronized(items){
			if(items.size()==0)return null;
			return items.get(random(items.size()-1));
		}
	}
	
	private int random(int max){
		return (int)(Math.random()*(max+1));
	}
}
