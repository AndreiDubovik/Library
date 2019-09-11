package by.ormedia.library.core;

import java.util.List;

public interface IView {

		void showReaders(List<IReader>list);
		void showLibraryItems(List<ILibraryItem>list);
		void showMessage(String message);
}
