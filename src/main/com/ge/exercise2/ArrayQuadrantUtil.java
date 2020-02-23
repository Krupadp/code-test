package com.ge.exercise2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayQuadrantUtil {
    private static final Logger logger = LogManager.getLogger(ArrayQuadrantUtil.class);

    char[][] data;

    public ArrayQuadrantUtil(char[][] data) {
        this.data = data;
    }

    public char[] getQuadrantValues(int row, int column) {
    	char[] subArr = new char[4];
    	int count = 0;
        if(row <= data.length-2 && column <= data[0].length-2){
        	for(int i=0;i<=row+1;i++){
        		for(int j=0;j<=column+1;j++){        			
        			subArr[count] = data[i][j];
        			count++;
        		}
        	}
        	
        }
        return subArr;
    }
    
    public char[] getColumnValues(int column) {
    	char[] subArr = new char[4];
        for(int i=0;i<data.length;i++){
        	subArr[i] = data[i][column];
        }
        return subArr;
    }
    public char[] getRowValues(int row) {
    	char[] subArr = new char[4];
        for(int i=0;i<data[row].length;i++){
        	subArr[i] = data[row][i];
        }
        return subArr;
    }
    
}
