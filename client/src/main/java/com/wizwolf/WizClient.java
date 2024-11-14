package com.wizwolf;

import com.wizwolf.client.apps.ALogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WizClient {
    private ALogin aLogin;

    @Autowired
    public WizClient(ALogin aLogin) {
        this.aLogin = aLogin;
    }

    public void startup() {
        aLogin.getB();

    }
}
