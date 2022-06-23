package Network;

import GooglePlay.JSONArray;
import Model.Author;
import jdk.internal.access.JavaSecurityAccess;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import static javax.swing.text.html.parser.DTDConstants.ID;

public class JSONAPI {
    private static JavaSecurityAccess.ProtectionDomainCache jsonSAuthor;

    public static void main(String[] args) throws IOException {
        String ID;
        String Name;
        String Address;
        String Phone;

        ArrayList<Author> _AuthorTI = new ArrayList<>();
        try {
            Author s = new Author();
            Scanner _input = new Scanner(System.in);
            System.out.println("Masukkan ID : ");
            ID = _input.nextLine();
            System.out.println("Masukkan Name : ");
            Name = _input.nextLine();
            System.out.println("Masukkan Alamat : ");
            Address = _input.nextLine();
            System.out.println(" Masukkan Phone : ");
            Phone = _input.nextLine();

            s.set_nim(ID);
            s.set_name(Name);
            s.set_addres(Address);
            s.set_phone(Phone);
            _AuthorTI.add(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int j=0;j< _AuthorTI.size();j++){
            System.out.println(_AuthorTI.get(j).get_ID() + " _ " +_AuthorTI.get(j).get_name()+
                    " _ " +_AuthorTI.get(j).get_addres() + " _ " + _AuthorTI.get(j).get_phone()+
                    " _ ");
        }
        //mengubah arraylist menjadi json
        JSONArray jsonAuthor = new JSONArray(); //install Library org.json
        JSObject myJObject = new JSONObject();
        myJObject.put("id",_AuthorTI.get(0).get_ID());
        myJObject.put("name",_AuthorTI.get(0).get_name());
        myJObject.put("addres",_AuthorTI.get(0).get_addres());
        myJObject.put("phone",_AuthorTI.get(0).get_phone());
        jsonAuthor.put(myJObject);

        System.out.println(jsonAuthor.toString());

        //send student data dataabase Cloud
        ConnectURI myUriBuilder = new ConnectURI();
        URL myAddress = myUriBuilder.buildURL("https://gplaystore.p.rapidapi.com/applicationDetails");
        myUriBuilder.postJSON(myAddress,jsonAuthor.toString());

    }


    private static class JSONObject extends JSObject {
        @Override
        public Object call(String methodName, Object... args) throws JSException {
            return null;
        }

        @Override
        public Object eval(String s) throws JSException {
            return null;
        }

        @Override
        public Object getMember(String name) throws JSException {
            return null;
        }

        @Override
        public void setMember(String name, Object value) throws JSException {

        }

        @Override
        public void removeMember(String name) throws JSException {

        }

        @Override
        public Object getSlot(int index) throws JSException {
            return null;
        }

        @Override
        public void setSlot(int index, Object value) throws JSException {

        }
    }
}
