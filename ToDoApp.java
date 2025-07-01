import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoApp extends JFrame {
	
	private JTextField taskInput;
	private JButton addButton, deleteButton;
	private JList<String> taskList;
	private DefaultListModel<String> taskListModel;
	private JScrollPane scrollPane;
	private JPanel inputPanel;
	
	public ToDoApp() {

		setTitle("ToDo List App");
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		inputPanel = new JPanel(new BorderLayout());
        	taskInput = new JTextField();
        	addButton = new JButton("Add Task");
		deleteButton = new JButton("Delete Selected Task");
		
		taskListModel = new DefaultListModel<>();
        	taskList = new JList<>(taskListModel);
                scrollPane = new JScrollPane(taskList);
		
        	inputPanel.add(taskInput, BorderLayout.CENTER);
        	inputPanel.add(addButton, BorderLayout.EAST);

                add(inputPanel, BorderLayout.NORTH);
        	add(scrollPane, BorderLayout.CENTER);
        	add(deleteButton, BorderLayout.SOUTH);

         	addButton.addActionListener(e -> {
            	String task = taskInput.getText().trim();
            	if (!task.isEmpty()) {
                	taskListModel.addElement(task);
                	taskInput.setText("");
            		}
        	});

        	deleteButton.addActionListener(e -> {
            	int selectedIndex = taskList.getSelectedIndex();
            	if (selectedIndex != -1) {
                	taskListModel.remove(selectedIndex);
            		}
        	});

        	setVisible(true);
    	}

	public static void main(String[] args) {
        	new ToDoApp();
    	}
}