package au.com.wbd.JConMate;

/**
 * Created by prateeknayak on 10/04/2016.
 */
public class Node {

    private String key;
    private String value;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(String key) {

        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {

        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

}
