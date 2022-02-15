package com.company.sample.screen.systemauth;

import com.company.sample.entity.Book;
import io.jmix.core.DataManager;
import io.jmix.core.security.SystemAuthenticator;
import io.jmix.ui.component.Button;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UiController("SystemAuthScreen")
@UiDescriptor("system-auth-screen.xml")
public class SystemAuthScreen extends Screen {

    @Autowired
    private SystemAuthenticator systemAuthenticator;

    @Autowired
    private DataManager dataManager;

    @Subscribe("testSystemAuthBtn")
    public void onTestSystemAuthBtnClick(Button.ClickEvent event) {
        systemAuthenticator.withSystem(() -> {
            List<Book> books = dataManager.load(Book.class).all().list();
            return true;
        });
    }
}