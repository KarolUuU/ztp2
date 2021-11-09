package com.company;
import java.util.LinkedList;
import java.util.List;

interface imailbox{
    void send(String a);
    String read();
}

public class mailbox implements imailbox{
    List<String> box = new LinkedList<String>();
    int i = 0;
    @Override
    public void send(String a){
        box.add(a);
    }
    @Override
    public String read(){
        i++;
        return box.get(i-1);
    }
}

abstract class dekorator implements imailbox{
    protected imailbox mess;
    public dekorator(imailbox message){
        this.mess = message;
    }
    public void send(String a){mess.send(a);}
    public String read(){return mess.read();}
}

class adds extends dekorator{
    public adds(imailbox message){
        super(message);
    }
    public void send(String a){
        super.send(addstatus(a));
    }
    public String read(){
        return super.read();
    }
    public String addstatus(String a){
        java.util.Date date = new java.util.Date();

        String b=a+" wyslano "+ date;
        return b;
    }
}
class reads extends dekorator{
    public reads(imailbox message){
        super(message);
    }
    public void send(String a){
        super.send(addstatus(a));
    }
    public String read(){
        return super.read();
    }
    public String addstatus(String a){
        java.util.Date date = new java.util.Date();

        String b=a+ " odebrano "+ date;
        return b;
    }
}
class index extends dekorator{
    public index(imailbox message){
        super(message);
    }
    public void send(String a){
        super.send(addindex(a));
    }
    public String read(){
        return super.read();
    }
    public String addindex(String a){
        int i=1;
        String c = Integer.toString(i);
        String b=c+":"+a;
        i++;
        return b;
    }
}
