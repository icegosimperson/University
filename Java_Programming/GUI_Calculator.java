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


조금 더 크게 나옴
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


// <계산 클래스 만들기>
// 1. 액션리스너를 상속받은 계산 클래스 정의
// 2. 생성장를 이용해서 컨트롤이 필요한 컴포넌트 레퍼런스 전달
// 3. 액션퍼퓸 오버라이딩 

// txt1, txt2에서 데이터(String)를 읽어오기 ex)
// 읽어온 데이터를 정수로 변환 ex) Integer.parsInt(txt1.getText()); int n2 = Integer.parseInt(txt2.getText()); 
// 계산하기
// 계산된 결과를 String으로 변환 ex) String t = 5+""; //자동으로 문자로 바뀜
// 계산된 결과를 txt3에 쓰기 
//확인 버튼 이벤트 처리



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class Caculator implements ActionListener{
JTextField txt1, txt2, txt3;
Caculator(JTextField txt1, JTextField txt2, JTextField txt3){
this.txt1 = txt1;
this.txt2 = txt2;
this.txt3 = txt3;
}


public void actionPerformed(ActionEvent e) {
int n1 = Integer.parseInt(txt1.getText());
int n2 = Integer.parseInt(txt2.getText());
int n3 = n1 + n2;
String result = n3 + "";
txt3.setText(result);
}
}


public class WindowExample6 {

public static void main(String[] args) {
// TODO Auto-generated method stub
JFrame frame = new JFrame("Hello Java Program");

// cp 2x1 세팅
frame.setLocation(500, 400);
frame.setPreferredSize(new Dimension(300, 100));

Container cp = frame.getContentPane();
cp.setLayout(new GridLayout(2, 1));

// panel 생성 
JPanel pan1 = new JPanel(); // pan1
JPanel pan2 = new JPanel(); // pan2

// JPanel panel = new JPanel();
pan1.setLayout(new GridLayout(1, 5)); // pan1
pan2.setLayout(new GridLayout(1, 2)); // pan2

JTextField txt1 = new JTextField();
JTextField txt2 = new JTextField();
JTextField txt3 = new JTextField();
JButton bt1 = new JButton("실행");
JButton bt2 = new JButton("취소");


// pan1에 필요한 정보 올리기
pan1.add(txt1);
pan1.add(new JLabel("+", SwingConstants.CENTER));
pan1.add(txt2);
pan1.add(new JLabel("=", SwingConstants.CENTER));
pan1.add(txt3);

// pan2에 필요한 정보 올리기 
pan2.add(bt1);
pan2.add(bt2);


cp.add(pan1); cp.add(pan2);

Caculator calAc = new Caculator(txt1, txt2, txt3);
bt1.addActionListener(calAc);

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.pack();
frame.setVisible(true);

}

}
