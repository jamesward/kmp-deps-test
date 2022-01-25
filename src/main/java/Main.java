import okio.ByteString;

public class Main {

    public static void main(String[] args) {
        var hello = ByteString.encodeUtf8("hello, world");
        System.out.println(hello.md5().hex());
    }

}
