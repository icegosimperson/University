import java.awt.*;
import javax.swing.*;

public class WindowExample1 {

  public static void main(String[] args) {
  // TODO Auto-generated method stub
  JFrame frame = new JFrame("Hello Java Program");
  Container contentPane = frame.getContentPane();
  JLabel label = new JLabel("Hello Java");
  contentPane.add(label);
  frame.pack();
  frame.setVisible(true);
  }

}


// 조금 더 크게 나옴
import java.awt.*;
import javax.swing.*;

public class WindowExample1 {

  public static void main(String[] args) {
  // TODO Auto-generated method stub
  JFrame frame = new JFrame("Hello Java Program");
  frame.setLocation(500, 400);
  frame.setPreferredSize(new Dimension(300, 200));
  Container contentPane = frame.getContentPane();
  JTextField text = new JTextField();
  JLabel label = new JLabel("Hello Java");
  contentPane.add(label);
  frame.pack();
  frame.setVisible(true);
  }

}


import java.awt.*;
import javax.swing.*;

public class WindowExample2 {

  public static void main(String[] args) {
  // TODO Auto-generated method stub
  JFrame frame = new JFrame("Hello Java Program");
  frame.setPreferredSize(new Dimension(200, 70));
  frame.setLocation(500, 400);
  Container contentPane = frame.getContentPane();
  JTextField text = new JTextField();
  JButton button = new JButton("확인");
  JLabel label = new JLabel("Hello");
  contentPane.add(text, BorderLayout.CENTER);
  contentPane.add(button, BorderLayout.EAST);
  contentPane.add(label, BorderLayout.SOUTH);
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.pack();
  frame.setVisible(true);
  }
}

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class WindowExample2 {

  public static void main(String[] args) {
  // TODO Auto-generated method stub
  JFrame frame = new JFrame("Hello Java Program");
  frame.setPreferredSize(new Dimension(200, 70));
  frame.setLocation(500, 400);
  Container contentPane = frame.getContentPane();
  JTextField text = new JTextField();
  JButton button = new JButton("확인");
  JLabel label = new JLabel("Hello");
  contentPane.add(text, BorderLayout.CENTER);
  contentPane.add(button, BorderLayout.EAST);
  contentPane.add(label, BorderLayout.SOUTH);
  
  ActionListener listener = new ConfirmButtonActionListener(text, label);
  button.addActionListener(listener);
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.pack();
  frame.setVisible(true);
  }
}

// 확인 버튼 이벤트 처리
class ConfirmButtonActionListener implements ActionListener{
  JTextField text;
  JLabel label;
  ConfirmButtonActionListener(JTextField text, JLabel label){
  this.text = text;
  this.label = label;
}
  public void actionPerformed(ActionEvent e) {
  String name = text.getText();
  label.setText("Hello,"+name);
  }
}


import java.awt.*;
import javax.swing.*;

public class WindowExample3 {

public static void main(String[] args) {
  // TODO Auto-generated method stub
  JFrame frame = new JFrame("Zoo Program");
  
  frame.setLocation(500, 400);
  Container contentPane = frame.getContentPane();
  GridLayout layout = new GridLayout(3, 2);
  contentPane.setLayout(layout);
  contentPane.add(new JButton("얼룩말"));
  contentPane.add(new JButton("사자"));
  contentPane.add(new JButton("코끼리"));
  contentPane.add(new JButton("코뿔소"));
  contentPane.add(new JButton("펭귄"));
  contentPane.add(new JButton("하이에나"));
  
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.pack();
  frame.setVisible(true);
  
  }
}

import java.awt.*;
import javax.swing.*;

public class WindowExample4 {

public static void main(String[] args) {
  // TODO Auto-generated method stub
  JFrame frame = new JFrame("Zoo Program");
  
  frame.setLocation(500, 400);
  Container contentPane = frame.getContentPane();
  GridLayout layout = new GridLayout();
  contentPane.setLayout(layout);
  contentPane.add(new JButton("얼룩말"));
  contentPane.add(new JButton("사자"));
  contentPane.add(new JButton("코끼리"));
  contentPane.add(new JButton("코뿔소"));
  contentPane.add(new JButton("펭귄"));
  contentPane.add(new JButton("하이에나"));
  
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.pack();
  frame.setVisible(true);
  }
}


import java.awt.*;
import javax.swing.*;

public class WindowExample5 {

public static void main(String[] args) {
  // TODO Auto-generated method stub
  JFrame frame = new JFrame("Zoo Program");
  
  frame.setLocation(500, 400);
  Container contentPane = frame.getContentPane();
  BoxLayout layout = new BoxLayout(contentPane, BoxLayout.X_AXIS);
  contentPane.setLayout(layout);
  contentPane.add(new JButton("얼룩말"));
  contentPane.add(new JButton("사자"));
  contentPane.add(new JButton("코끼리"));
  contentPane.add(new JButton("코뿔소"));
  contentPane.add(new JButton("펭귄"));
  contentPane.add(new JButton("하이에나"));
  
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.pack();
  frame.setVisible(true);
  }
}

