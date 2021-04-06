package org.academiacodigo.bootcamp55.GamePrototip.Objects;

import org.academiacodigo.bootcamp55.GamePrototip.DynamicArray.DynamicArray;
import org.academiacodigo.bootcamp55.GamePrototip.DynamicArray.SortClass;
import org.academiacodigo.bootcamp55.GamePrototip.Field;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class FileManager {

    Field field;



    public FileManager(Field field){
        this.field = field;
    }

    FileWriter fileWriter;

    {
        try {
            fileWriter = new FileWriter("classpath:saved.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


    public void writing(String c) {
        try {
            bufferedWriter.write(c+",");
        }
        catch (IOException e){
            System.out.println("Cant do.");
        }
    }

    public void closing() {
        try {
            bufferedWriter.flush();

        }
        catch (IOException e){
            System.out.println("Cant do.");
        }

    }

    public void transfer(){
        InputStream is = null;
        OutputStream os = null;
        try {
            try {
                is = new FileInputStream("classpath:saved.txt");
                os = new FileOutputStream("classpath:savedState.txt",true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            byte[] buffer = new byte[1024];
            int length = 0;
            while (true) {
                try {
                    if (!((length = is.read(buffer)) > 0)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    os.write(buffer, 0, length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void reading (){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("classpath:savedState.txt");
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] temp = new String[0];
        try {
            temp = bufferedReader.readLine().split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(temp));

        TreeSet<Integer> sorter = new TreeSet<>();

        if (temp.length < 4) {
            for (int i = 0; i < temp.length; i++) {
                int tempNum = Integer.parseInt(temp[i]);
                sorter.remove(tempNum);
                sorter.add(tempNum);
            }
        } else {
            for (int i = 0; i < temp.length; i++) {
                int tempNum = Integer.parseInt(temp[i]);
                sorter.remove(tempNum);
                sorter.add(tempNum);
            }
        }

        String[] result = new String[0];
        Iterator<Integer> iterate = sorter.iterator();
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.setStringArray(result);

        while (iterate.hasNext() && result.length<4) {
            int tempI = iterate.next();
            String tempS = String.valueOf(tempI);
            result = dynamicArray.addString(tempS);

        }

        System.out.println(Arrays.toString(result));



        if(result.length==1){
            Text text = new Text(736,349,result[0]);
            text.grow(20,30);
            text.draw();
        }
        else if (result.length==2){
            Text text = new Text(736,349,result[0]);
            Text text2 = new Text(736,413,result[1]);
            text.grow(20,30);
            text2.grow(20,30);
            text.draw();
            text2.draw();
        }
        else if(result.length==3){
            Text text = new Text(736,349,result[0]);
            Text text2 = new Text(736,413,result[1]);
            Text text3 = new Text(736,477,result[2]);
            text.grow(20,30);
            text2.grow(20,30);
            text3.grow(20,30);
            text.draw();
            text2.draw();
            text3.draw();
        }
        else if(result.length==4){
            Text text = new Text(736,349,result[0]);
            Text text2 = new Text(736,413,result[1]);
            Text text3 = new Text(736,477,result[2]);
            Text text4 = new Text(736,541,result[3]);
            text.grow(20,30);
            text2.grow(20,30);
            text3.grow(20,30);
            text4.grow(20,30);
            text.draw();
            text2.draw();
            text3.draw();
            text4.draw();

        }

        try {
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
