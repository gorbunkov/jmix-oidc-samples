package com.company.sample.screen.author;

import io.jmix.ui.screen.*;
import com.company.sample.entity.Author;

@UiController("Author.edit")
@UiDescriptor("author-edit.xml")
@EditedEntityContainer("authorDc")
public class AuthorEdit extends StandardEditor<Author> {
}