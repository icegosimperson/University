import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

class PrintActionListener implements ActionListener{
   JTable table;
   PrintActionListener(JTable table){
      this.table = table;
   }
   public void actionPerformed(ActionEvent e) {
      TableModel model = table.getModel();
      int rowNum = model.getRowCount();
      int colNum = model.getColumnCount();
      
      for(int col=0; col<colNum; col++) {
         String colName = model.getColumnName(col);
         System.out.println(colName + "\t");
      }
      System.out.println();
      for(int row =0; row<rowNum; row++) {
         for(int col=0; col<colNum; col++) {
            Object obj = model.getValueAt(row, col);
            System.err.println(obj + "\t");
         }
         System.out.println();
      }
      System.out.println();
   }
}
class WindowExample7{
   public static void main(String[] args) {
      JFrame frame = new JFrame("참가자 명단 프로그램");
      frame.setPreferredSize(new Dimension(400, 200));
      frame.setLocation(500, 400);
      
      Container contentPane = frame.getContentPane();
      String colNames[] = {"이름", "나이", "성별"};
      Object data[][] = {{"김철수", 24, "남자"},
            {"이순희", 21, "여"},
            {"박지영", 26, "여"}};
      JTable table = new JTable(data, colNames);
      JScrollPane scrolPane = new JScrollPane(table);
      contentPane.add(scrolPane, BorderLayout.CENTER);
      JButton button = new JButton("출력");
      
      contentPane.add(button, BorderLayout.SOUTH);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
      }
      
}

