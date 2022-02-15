package com.company.sample.screen.book;

import io.jmix.ui.screen.*;
import com.company.sample.entity.Book;

@UiController("Book.edit")
@UiDescriptor("book-edit.xml")
@EditedEntityContainer("bookDc")
public class BookEdit extends StandardEditor<Book> {
}