package com.wizwolf.client.apps;

import com.wizwolf.client.config.I18nUtil;
import com.wizwolf.client.swing.*;
import com.wizwolf.client.service.LanguageService;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class ConnPanel extends CPanel {
    private final CTextField userTextField;
    private final CLabel userLabel;
    private final JPasswordField passwordField;
    private final CLabel passwordLabel;
    private final CComboBox languageCombo;
    private final CLabel languageLabel;
    private final GridBagLayout connectionLayout;

    private I18nUtil res;
    private LanguageService languageSrv;

    public ConnPanel() {
        res = I18nUtil.getInstance();
        userTextField = new CTextField();
        userLabel = new CLabel();
        passwordField = new JPasswordField();
        passwordLabel = new CLabel();
       languageCombo = new CComboBox();
        languageLabel = new CLabel();
        connectionLayout = new GridBagLayout();

        render();
    }

    public void render() {
        userLabel.setRequestFocusEnabled(false);
        userLabel.setLabelFor(userTextField);
        userLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        userLabel.setText("User");
        userLabel.setLabelFor(userTextField);
        userTextField.setText("System");

        passwordLabel.setRequestFocusEnabled(false);
        passwordLabel.setLabelFor(passwordField);
        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        passwordLabel.setText("Password");
        passwordLabel.setLabelFor(passwordField);
        passwordField.setText("System");

        languageLabel.setLabelFor(languageCombo);
        languageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        languageLabel.setText("Language");
        languageCombo.addActionListener(event -> {
            languageComboChanged();
        });

        setLayout(connectionLayout);
        add(userLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 12, 5, 5), 0, 0));
        add(userTextField, new GridBagConstraints(1, 3, 3, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 12), 0, 0));
        add(passwordLabel, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 12, 5, 5), 0, 0));
        add(passwordField, new GridBagConstraints(1, 4, 3, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5, 12), 0, 0));
        add(languageLabel, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 12, 5, 5), 0, 0));
        add(languageCombo, new GridBagConstraints(1, 5, 3, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 12), 0, 0));

        //languageCombo.setSelectedItem(Ini.getProperty(Ini.P_LANGUAGE));


    }

    private void languageComboChanged() {
        userLabel.setText(res.getString("User"));
        userLabel.setToolTipText(res.getString("EnterUser"));
        passwordLabel.setText(res.getString("Password"));
        passwordLabel.setToolTipText(res.getString("EnterPassword"));
        languageLabel.setText(res.getString("Language"));
        languageLabel.setToolTipText(res.getString("SelectLanguage"));

    }

    public String getUserName() {
        return userTextField.getText();
    }

    public String getPassword() {
        return String.valueOf(passwordField.getPassword());
    }



}
