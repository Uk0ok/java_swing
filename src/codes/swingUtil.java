package codes;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import vo.filesVO;

public class swingUtil extends JFrame implements ActionListener {
	private Vector<String> vector;
	private DefaultTableModel model;
	private JTable table;
	private JButton search;
	private JTextField searchField;
    
    public void viewSwing(String path) {
    	fileUtil fs = new fileUtil();
    	List<filesVO> fList = fs.fileSearch(path);
    	
    	vector = new Vector<String>();
        vector.addElement("파일명");
        vector.addElement("폴더");
        vector.addElement("파일 사이즈 (byte)");
        vector.addElement("수정 날짜");
        
        // 테이블 초기화 후 1열을 제외한 나머지 열을 편집 가능하게 함
        model = new DefaultTableModel(vector, 0) {
            public boolean isCellEditable(int r, int c) {
                return (c != 0) ? true : false;
            }
        };
        
        // 파일 이름과 파일 경로, 파일 사이즈
        for (filesVO data : fList) {
            Vector<Object> v = new Vector<Object>();
            v.add(data.getFileName());
            v.add(data.getFilePath());
            v.add(data.getFileSize());
            v.add(data.getFileDate());
            model.addRow(v);
        }
        
        table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);

		search = new JButton("검색");
		
		searchField = new JTextField(30);

		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(new JLabel("검색어 : "));
        p.add(searchField);
		p.add(search);

		Container c = getContentPane();
		c.add(scroll, "Center");
		c.add(p, "North");

		setBounds(700, 100, 500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		search.addActionListener(this);

		setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search) {
	        String searchText = searchField.getText().trim().toLowerCase();
//	        searchFiles(searchText);
	        JOptionPane.showMessageDialog(this, "입력한 검색어 : " + searchText, "검색어 확인", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
}
