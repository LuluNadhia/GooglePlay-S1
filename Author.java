package Model;

public class Author {
    private String _ID;
    private String _name;
    private String _addres;
    private String _phone;


    public String get_ID() {
        return _ID;
    }

    public void set_nim(String _ID) {
        this._ID = get_ID();
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }


    public String get_addres() {
        return _addres;
    }

    public void set_addres(String _addres) {
        this._addres = _addres;
    }

    public String get_phone() {
        return _phone;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }


    public Author(String _ID, String _name, String _addres, String _phone){
        this._ID = _ID;
        this._name = _name;
        this._addres = _addres;
        this._phone = _phone;

    }
    public Author() {

    }
    //ikutilah langkah-langkan di vidio tutorial, kita akan membuat getter dan setter
}
