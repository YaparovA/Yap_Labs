package ru.yaparov.phone;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> book = new HashMap<String, String>();

    public PhoneBook(){}

    public PhoneBook(String name, String phone){
        this.book.put(name, phone);
    }

    public String Add(String name, String phone){
        String oldNumber = "";
        if (book.containsKey(name))
            oldNumber = book.get(name);
        book.put(name, phone);
        return oldNumber;
    }

    public void Delete(String name){
        book.remove(name);
    }

    public String Get(String name){
        return book.get(name);
    }

    public String ToString(){

        String list = "";
        for(Map.Entry<String, String> item : book.entrySet())
            list += item.getKey() + " " + item.getValue() + "\n";
        return list;
    }

    public String ToStringByName(int typeList){

        String list = "";
        for(Map.Entry<String, String> item : book.entrySet())
            list += item.getKey() + "\n";
        return list;
    }

    public String ToStringByPhone(int typeList){

        String list = "";
        for(Map.Entry<String, String> item : book.entrySet())
            list += item.getValue() + "\n";
        return list;
    }

    public boolean ExistName(String name){
        return book.containsKey(name);
    }

    public boolean ExistNumber(String number){
        return book.containsValue(number);
    }

    public int Count(){
        return book.size();
    }

    public String[] Search(String namePeace){
        String[] nameList = new String[0];
        for(Map.Entry<String, String> item : book.entrySet())
            if(item.getKey().contains(namePeace)) {
                nameList = Arrays.copyOf(nameList, nameList.length + 1);
                nameList[nameList.length - 1] = item.getKey();
            }
        return nameList;
    }
}
