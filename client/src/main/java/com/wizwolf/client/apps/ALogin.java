package com.wizwolf.client.apps;

import com.wizwolf.client.Application;
import com.wizwolf.client.config.SpringUtils;
import com.wizwolf.client.service.LanguageService;
import com.wizwolf.client.service.WindowService;
import com.wizwolf.client.swing.*;
import com.wizwolf.client.util.ComboBoxUtils;
import com.wizwolf.entity.ADClient;
import com.wizwolf.entity.ADOrg;
import com.wizwolf.entity.ADRole;
import com.wizwolf.entity.ADUser;
import com.wizwolf.service.AuthenService;
import com.wizwolf.service.UserService;
import com.wizwolf.client.service.EnvService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class ALogin extends JFrame implements ChangeListener {
    @Autowired
    private AuthenService authenSrv;
    @Autowired
    private UserService userSrv;
    @Autowired
    private EnvService env;
    @Autowired
    private WindowService winSrv;
    @Autowired
    private final LanguageService langSrv;

    //private int	m_WindowNo;
    private Logger log = LoggerFactory.getLogger(ALogin.class);
    private CPanel mainPanel = new CPanel(new BorderLayout());
    private CTabbedPane loginTabPane = new CTabbedPane();


    private CPanel connectionPanel = new CPanel();
    private GridBagLayout connectionLayout = new GridBagLayout();
    private CLabel userLabel = new CLabel();
    private CTextField userTextField = new CTextField();
    private CLabel passwordLabel = new CLabel();
    private JPasswordField passwordField = new JPasswordField();

    private CPanel defaultPanel = new CPanel();
    private GridBagLayout defaultPanelLayout = new GridBagLayout();
    private CLabel roleLabel = new CLabel();
    private JComboBox<ADRole> roleCombo = new JComboBox<>();
    private CLabel clientLabel = new CLabel();
    private JComboBox<ADClient> clientCombo = new JComboBox<>();
    private CLabel orgLabel = new CLabel();
    private final JComboBox<ADOrg> orgCombo = new JComboBox<>();
    private CLabel warehouseLabel = new CLabel();
    private CComboBox warehouseCombo = new CComboBox();
    private CLabel languageLabel = new CLabel();
    private CComboBox languageCombo = new CComboBox();
    //private CLabel dateLabel = new CLabel();
    //private VDate dateField = new VDate(DisplayType.Date);
    //private CLabel printerLabel = new CLabel();
    //private CPrinter printerField = new CPrinter();
    private CLabel copy0Label = new CLabel();
    private CLabel titleLabel = new CLabel();
    private CLabel versionLabel = new CLabel();
    private CLabel copy1Label = new CLabel();
    private CLabel compileDate = new CLabel();

    private CPanel southPanel = new CPanel();
    private BorderLayout southLayout = new BorderLayout();
    private StatusBar statusBar = new StatusBar();
    private CPanel confirmPanel;
    private CButton bCancel;
    private CButton bOK;
    //private ConfirmPanel confirmPanel = new ConfirmPanel(true, false, false, false, false, false, false);




    public ALogin(LanguageService langSrv) {
        super( "Login");
        this.setName("Login");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.langSrv = langSrv;

        languageCombo = new CComboBox(this.langSrv.getNames());

        //m_WindowNo = this.winSrv.createWindowNo(null);
        initConnectionPanel();
        initDefaultPanel();
        initConfirmPanel();
        jbInit();

        //  Focus to OK
        //this.getRootPane().setDefaultButton(confirmPanel.getOKButton());
        //parent.setIconImage(Adempiere.getImage16());
    }

    private void jbInit() {
        //I18nUtil i = I18nUtil.getInstance();
        //System.out.println(i.getMessage("Host"));

        southPanel.setLayout(southLayout);
        southPanel.add(confirmPanel, BorderLayout.NORTH);
        southPanel.add(statusBar, BorderLayout.SOUTH);
        //helpScollPane.getViewport().add(onlineHelp, null);
        //confirmPanel.addActionListener(this);

        loginTabPane.add(connectionPanel, "conn");
        loginTabPane.add(defaultPanel, "Defaults");
        loginTabPane.addChangeListener(this);

        mainPanel.setName("loginMainPanel");
        mainPanel.add(loginTabPane, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        this.getContentPane().add(mainPanel);

        //CButton btnOk = new CButton("ok");

        //this.getContentPane().add(btnOk, BorderLayout.SOUTH);

        this.setVisible(true);

    }

    public void initConnectionPanel() {
        titleLabel.setFont(new java.awt.Font("Serif", 2, 10));
        titleLabel.setForeground(Color.blue);
        titleLabel.setRequestFocusEnabled(false);
        titleLabel.setToolTipText(Application.getInstance().getURL());
        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        titleLabel.setIcon(Application.getInstance().getImageIconLogo());
        titleLabel.setText(Application.getInstance().getSubtitle());
        titleLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        versionLabel.setRequestFocusEnabled(false);
        versionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        versionLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        versionLabel.setText(Application.getInstance().MAIN_VERSION);
        versionLabel.setToolTipText(Application.getInstance().getImplementationVersion());

        copy0Label.setFont(new java.awt.Font("Serif", 2, 10));
        copy0Label.setForeground(Color.blue);
        copy0Label.setRequestFocusEnabled(false);
        copy0Label.setHorizontalAlignment(SwingConstants.RIGHT);
        copy1Label.setRequestFocusEnabled(false);
        copy1Label.setText(Application.getInstance().COPYRIGHT);

        compileDate.setHorizontalAlignment(SwingConstants.RIGHT);
        compileDate.setHorizontalTextPosition(SwingConstants.RIGHT);
        compileDate.setText(Application.getInstance().DATE_VERSION);
        compileDate.setToolTipText(Application.getInstance().getImplementationVendor());


        userLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        userLabel.setText("User");
        userLabel.setLabelFor(userTextField);
        userTextField.setName("userTextField");
        userTextField.setText("System");

        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        passwordLabel.setText("Password");
        passwordLabel.setLabelFor(passwordField);
        passwordField.setName("passwordField");
        passwordField.setText("System");

        languageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        languageLabel.setText("Language");
        languageLabel.setLabelFor(languageCombo);
        languageCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        connectionPanel.setLayout(new GridBagLayout());
        connectionPanel.add(userLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 12, 5, 5), 0, 0));
        connectionPanel.add(userTextField, new GridBagConstraints(1, 3, 3, 1, 1.0, 0.0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 12), 0, 0));
        connectionPanel.add(passwordLabel, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 12, 5, 5), 0, 0));
        connectionPanel.add(passwordField, new GridBagConstraints(1, 4, 3, 1, 1.0, 0.0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5, 12), 0, 0));
        connectionPanel.add(languageLabel, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 12, 5, 5), 0, 0));
        connectionPanel.add(languageCombo, new GridBagConstraints(1, 5, 3, 1, 1.0, 0.0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 12), 0, 0));
        connectionPanel.add(copy0Label, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
        connectionPanel.add(copy1Label, new GridBagConstraints(1, 6, 2, 1, 0.0, 0.0,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 12, 12), 0, 0));
        connectionPanel.add(compileDate, new GridBagConstraints(2, 1, 2, 1, 0.0, 0.0,GridBagConstraints.NORTHEAST, GridBagConstraints.NONE, new Insets(2, 0, 0, 12), 0, 0));
        connectionPanel.add(titleLabel, new GridBagConstraints(0, 0, 2, 2, 0.0, 0.0,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(12, 12, 5, 5), 0, 0));
        connectionPanel.add(versionLabel, new GridBagConstraints(2, 0, 2, 1, 0.0, 0.0,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(12, 5, 0, 12), 0, 0));

    }

    public void initDefaultPanel() {
        roleLabel.setText("Role");
        roleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        roleLabel.setLabelFor(roleCombo);
        //roleCombo.addActionListener((ActionListener) this);

        clientCombo.setName("clientCombo");
        clientLabel.setText("Client");
        clientLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        clientLabel.setLabelFor(clientCombo);
        //clientCombo.addActionListener((ActionListener) this);

        orgCombo.setName("orgCombo");
        orgLabel.setText("Organization");
        orgLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        orgLabel.setLabelFor(orgCombo);
        //orgCombo.addActionListener((ActionListener) this);

        warehouseLabel.setText("Warehouse");
        warehouseLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        warehouseLabel.setLabelFor(warehouseCombo);

        defaultPanel.setLayout(new GridBagLayout());
        defaultPanel.add(roleLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(12, 12, 5, 5), 0, 0));
        defaultPanel.add(roleCombo, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(12, 0, 5, 12), 0, 0));
        defaultPanel.add(clientLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 12, 5, 5), 0, 0));
        defaultPanel.add(clientCombo, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 12), 0, 0));
        defaultPanel.add(orgLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 12, 5, 5), 0, 0));
        defaultPanel.add(orgCombo, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5, 12), 0, 0));
        defaultPanel.add(warehouseLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 12, 5, 5), 0, 0));
        defaultPanel.add(warehouseCombo, new GridBagConstraints(1, 3, 1, 1, 1.0, 0.0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 12), 0, 0));

        //        dateLabel.setText("Date");
//        dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//        dateLabel.setLabelFor(dateField);
//        defaultPanel.add(dateLabel,       new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 12, 5, 5), 0, 0));
//        defaultPanel.add(dateField,        new GridBagConstraints(1, 4, 1, 1, 1.0, 0.0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 12), 0, 0));
        //

    }
    
    public void initConfirmPanel() {
        this.confirmPanel = new CPanel();
        this.confirmPanel.setLayout(new BorderLayout());
        this.confirmPanel.setName("confirmPanel");

        CPanel okCancel = new CPanel(new FlowLayout(FlowLayout.RIGHT));
        okCancel.setOpaque(false);
        //bCancel = createCancelButton(withText);
        this.bCancel = new CButton("Cancel");
        okCancel.add(bCancel);
        //bOK = createOKButton(withText);
        this.bOK = new CButton("OK");
        bOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loginTabPane.getSelectedIndex() == 0) {
                    login(userTextField.getText(), String.valueOf(passwordField.getPassword()));
                }else{

                }

            }
        });
        okCancel.add(bOK);
        //setCancelVisible(withCancelButton);
        this.confirmPanel.add(okCancel, BorderLayout.EAST);

    }


    public void login(String name, String password) {
        Optional<ADUser> o = authenSrv.login(name, password);
        o.ifPresent(user -> {
            if (authenSrv.isAuthenticated()) {
                loginTabPane.setSelectedIndex(1);
                Set<ADRole> rs = user.getRoles();
                ComboBoxUtils.bindComboBox(roleCombo, rs, "name");
                ADRole role = (ADRole) roleCombo.getSelectedItem();

                Set<ADClient> clients = new HashSet<>();
                Set<ADOrg> orgs = new HashSet<>();
                rs.forEach(r -> {
                    if (r.getClient().getIsActive()) {
                        clients.add(r.getClient());
                    }
                    if (r.getOrg().getIsActive()) {
                        orgs.add(r.getOrg());
                    }
                });
                ComboBoxUtils.bindComboBox(clientCombo, clients, "name");
                ComboBoxUtils.bindComboBox(orgCombo, orgs, "name");
                System.out.println(role);

            }
        });
    }

    @Transactional
    public String getB() {
//        Optional<User> u = user.findById(0);
//        u.ifPresent(System.out::println);
//        u.ifPresent(user -> {
//            System.out.println(user.getDescription());
//        });
        //Optional<User> o = user.findUserByName("System");
        //System.out.println(o.get().isAuthen());
        Optional<ADUser> o = userSrv.login("System", "System");
        o.ifPresent(u -> {
            System.out.println(u);
            System.out.println(u.getRoles());
        });





        return SpringUtils.getMessage("Defaults");
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    public CTabbedPane getLoginTabPane() {
        return loginTabPane;
    }
}
