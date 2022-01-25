import okio.ByteString.Companion.encodeUtf8

fun main() = run {
    println("hello, world".encodeUtf8().md5().hex())

}
