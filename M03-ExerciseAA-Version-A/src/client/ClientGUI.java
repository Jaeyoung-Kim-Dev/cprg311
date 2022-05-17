/**
 * 
 */
package client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

import problemdomain.Message;

/**
 * @author nhamnett
 *
 */
public class ClientGUI {
	private JFrame frame;
	
	private DefaultListModel chatListModel;
	private JList chatList;

	private String username;
	
	private Socket socket;

	private ObjectOutputStream objectOutputStream;

	private ObjectInputStream objectInputStream;
	
	public ClientGUI() {
		this.frame = new JFrame("CPRG311 Mod 3 Exercise");
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLayout(new BorderLayout());
		this.frame.setSize(400, 400);
		
		JPanel chatPanel = this.createChatPanel();
		this.frame.add(chatPanel, BorderLayout.CENTER);
		
		JPanel connectionPanel = this.createConnectionPanel();
		this.frame.add(connectionPanel, BorderLayout.SOUTH);
	}
	
	private JPanel createChatPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		
		this.chatListModel = new DefaultListModel();
		this.chatList = new JList(this.chatListModel);
		
		JScrollPane scrollPane = new JScrollPane(this.chatList);
		
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel inputButtonPanel = new JPanel(new BorderLayout());
		
		JTextField textField = new JTextField();
		inputButtonPanel.add(textField, BorderLayout.CENTER);
		
		JButton sendButton = new JButton("Send");
		
		sendButton.addActionListener((ActionEvent evt) -> {
			// Get the text to send from the text field.
			String text = textField.getText();
			
			// Create a Message object.
			Message send = new Message(this.username, text);
			
			try {
				// Send Message to the server.
				this.objectOutputStream.writeObject(send);
				
				// If it's sent successfully, clear the text field.
				textField.setText("");
				
				// If it's sent successfully, add message to chat list.
				this.addMessage(send.toString());
				
				Message receive = (Message) objectInputStream.readObject();
				this.addMessage(receive.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				this.addMessage("Unable to send message.");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		});
		
		inputButtonPanel.add(sendButton, BorderLayout.EAST);
		
		panel.add(inputButtonPanel, BorderLayout.SOUTH);
		
		return panel;
	}
	
	private JPanel createConnectionPanel() {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		
		JButton connectButton = new JButton("Connect");
		
		connectButton.addActionListener((ActionEvent evt) -> {
			String ip = JOptionPane.showInputDialog(this.frame, "Enter ip address or hostname:");
			int port = Integer.parseInt(JOptionPane.showInputDialog(this.frame, "Enter port:"));
			
			try {
				socket = new Socket(ip, port);
				
				this.addMessage("Connected!");
				
				OutputStream outputStream = socket.getOutputStream();
				objectOutputStream = new ObjectOutputStream(outputStream);
				
				InputStream inputStream = socket.getInputStream();
				objectInputStream = new ObjectInputStream(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				this.addMessage("Unable to connect");
			}
			
			
		});
		
		panel.add(connectButton);
		
		JButton disconnectButton = new JButton("Disconnect");
		
		disconnectButton.addActionListener((ActionEvent evt) -> {
			try {
				this.objectInputStream.close();
				this.objectOutputStream.close();
				
				this.socket.close();
				
				this.addMessage("Disconnected");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				this.addMessage("Unable to disconnect");
			}
		});
		
		panel.add(disconnectButton);
		
		return panel;
	}
	
	/**
	 * Add a message to the JList.
	 * @param message
	 */
	private void addMessage(String message) {
		this.chatListModel.addElement(message);
	}
	
	public void display() {
		this.frame.setVisible(true);
		
		this.username = JOptionPane.showInputDialog(this.frame, "Enter username: ");
	}
}
