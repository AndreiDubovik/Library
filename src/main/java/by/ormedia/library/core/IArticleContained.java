package by.ormedia.library.core;

import java.util.List;

public interface IArticleContained extends ILibraryItem{
	List<IArticle>getArticles();
}
