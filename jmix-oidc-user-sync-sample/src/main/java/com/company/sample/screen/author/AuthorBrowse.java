package com.company.sample.screen.author;

import io.jmix.ui.screen.*;
import com.company.sample.entity.Author;

@UiController("Author.browse")
@UiDescriptor("author-browse.xml")
@LookupComponent("authorsTable")
public class AuthorBrowse extends StandardLookup<Author> {
}