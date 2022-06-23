package GooglePlay;

public class Content {
    public String getName() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }

    public String getPluName() {
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    public int getPluQty() {
        return fileSize;
    }

    public void setPluQty(int fileSize) {
        this.fileSize = fileSize;
    }

    public int getPluPrice() {
        return opratingSysytem;
    }

    public void setPluPrice(int opratingSysytem) {
        this.opratingSysytem = opratingSysytem;
    }

    private String name;//nama aplikasi
    private String author;//auturo
    private int fileSize;// size
    private int opratingSysytem;;//op
}
