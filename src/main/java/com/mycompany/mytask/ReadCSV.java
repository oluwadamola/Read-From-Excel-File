/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mytask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author USER
 */
public class ReadCSV {

        static String csvFilePath = "qzAjJo.csv";
	public static void main(String args[]) {
             loadFile(csvFilePath);
	}

        private static void loadFile(String fileName){

          int lineNumber = 0;

          try {
                  BufferedReader input = new BufferedReader(new FileReader(new File(fileName)));
                  try {
                    String line;
                    while ((line = input.readLine()) != null) {
                      List<String> row = new ArrayList<String>();
                      StringTokenizer tokenizer = new StringTokenizer(line, ",");
                      while (tokenizer.hasMoreTokens())  {
                         row.add(tokenizer.nextToken().trim());
                      }

                    System.out.println(row.get(lineNumber));

                    ++lineNumber;
                 }
            }
            finally {
              input.close();
              System.out.println("Read " + fileName + " " + lineNumber + " lines ------------------------");
            }
          }
            catch (IOException e) {
            System.err.println("Error opening " + fileName + ": " + e);
          }
        }
}
