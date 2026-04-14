package org.example;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class EmployeeRegistrationSystem {

    JFrame frame;
    JTextField nameField, emailField;
    JPasswordField passwordField;
    JComboBox<String> deptBox;
    JCalendar calendar;
    JTree tree;

    JButton submitBtn, clearBtn;

    JPanel formPanel;
    JScrollPane treeScroll;
    JPanel buttonPanel;

    public EmployeeRegistrationSystem() {
        CreateFrame();
    }

    public JFrame CreateFrame() {

        frame = new JFrame("Employee Registration");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        createForm();
        createTree();
        createButtons();

        //add components
        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(treeScroll, BorderLayout.WEST);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
        return frame;
    }

    private void createForm() {
        formPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        nameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();

        String[] departments = {"IT", "Finance", "HR", "Marketing"};
        deptBox = new JComboBox<>(departments);

        calendar = new JCalendar();

        formPanel.add(new JLabel("Full Name:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);

        formPanel.add(new JLabel("Password:"));
        formPanel.add(passwordField);

        formPanel.add(new JLabel("Department:"));
        formPanel.add(deptBox);

        formPanel.add(new JLabel("Date of Birth:"));
        formPanel.add(calendar);
    }

    private void createTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Company");

        DefaultMutableTreeNode it = new DefaultMutableTreeNode("IT");
        it.add(new DefaultMutableTreeNode("Developers"));
        it.add(new DefaultMutableTreeNode("Support"));

        DefaultMutableTreeNode hr = new DefaultMutableTreeNode("HR");
        hr.add(new DefaultMutableTreeNode("Recruitment"));

        root.add(it);
        root.add(hr);

        tree = new JTree(root);
        treeScroll = new JScrollPane(tree);
    }

    private void createButtons() {
        submitBtn = new JButton("Submit");
        clearBtn = new JButton("Clear");

        buttonPanel = new JPanel();
        buttonPanel.add(submitBtn);
        buttonPanel.add(clearBtn);
    }
}