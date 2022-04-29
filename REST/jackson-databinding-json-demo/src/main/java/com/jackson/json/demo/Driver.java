package com.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {

    public static void main(String[] args) {

        try{
            //create object Mapper
            ObjectMapper mapper = new ObjectMapper();

            //read json file and map/convert to JAVA POJO;
            //data/simple-lite.json
            Student myStudent = mapper.readValue(
                    new File("data/sample-full.json"), Student.class);

            //print details fetch from json file
            System.out.println(myStudent);

            //print out the address: street and city
            Address tempAddress = myStudent.getAddress();
            System.out.println(tempAddress);

            System.out.print("Languages: ");
            for(String s: myStudent.getLanguages())
            {
                System.out.print(s + ", ");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
