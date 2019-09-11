package by.ormedia.library.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.ormedia.library.core.IArticle;
import by.ormedia.library.core.IArticleContained;
import by.ormedia.library.core.ILibrary;
import by.ormedia.library.core.ILibraryItem;
import by.ormedia.library.core.ILibraryObject;
import by.ormedia.library.core.IReader;

public class Library implements ILibrary{
	
	private Map<Serializable,IReader>readers = new HashMap<>();
	private Map<Serializable,ILibraryItem>items = new HashMap<>();
	private Map<IArticle,IArticleContained>articles = new HashMap<>();

	public List<IReader> getReaders() {
		return new ArrayList<>(this.readers.values());
	}

	public List<ILibraryItem> getLibraryItemsList(Object ob) {
		return new ArrayList<>(this.items.values());
	}

	public void add(ILibraryObject ob) {
		if(ob instanceof IReader){
			this.readers.put(ob.getId(), (IReader) ob);
			return;
		}
		if(ob instanceof ILibraryItem){
			this.items.put(ob.getId(), (ILibraryItem) ob);
		}
		if(ob instanceof IArticleContained){
			List<IArticle>list = ((IArticleContained)ob).getArticles();
			for(IArticle article:list)this.articles.put(article, (IArticleContained)ob);
		}
	}

}
