addBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CompNum c1 = new CompNum(input1.getText());
                CompNum c2 = new CompNum(input2.getText());
                output.setText(c1.add(c2).toString());
            }
        });