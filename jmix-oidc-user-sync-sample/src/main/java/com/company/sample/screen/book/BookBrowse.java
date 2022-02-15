package com.company.sample.screen.book;

import io.jmix.ui.screen.*;
import com.company.sample.entity.Book;

@UiController("Book.browse")
@UiDescriptor("book-browse.xml")
@LookupComponent("booksTable")
public class BookBrowse extends StandardLookup<Book> {
}