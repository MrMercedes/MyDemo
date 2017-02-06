package mydemo.kotlin

/**
 * Created by hp0331 on 2017/2/4.
 */
fun main(args: Array<String>) {
    println("hello ");
    Persion().printname("ÄãºÃ");

    val firstName: String = "XiaoYang"
    val lastName: String? = "Zhang"

    println("my name is ${getName(firstName, lastName)}")
    println(hasEmpty("Zhang"))
    println(checkName("zhangxiaoyang"));
}
fun hasEmpty(vararg strArray: String?): Boolean {
    for (str in strArray) {
        str ?: return true
    }
    return false
}

fun getName(firstName: String?, lastName: String? = "unknow"): String {
    if (hasEmpty(firstName, lastName)) {
        lastName?.let { return@getName "${checkName(firstName)} $lastName" }
        firstName?.let { return@getName "$firstName ${checkName(lastName)}" }
    }
    return "$firstName $lastName"
}

fun checkName(name: String?): String = name ?: "unknow"