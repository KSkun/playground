package moe.ksmeow.ktyaml

import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import java.io.File
import java.util.logging.Logger
import kotlin.properties.Delegates

val log = Logger.getLogger("moe.ksmeow.ktyaml")

class YamlObj {
    var number by Delegates.notNull<Int>()
    lateinit var string: String
    lateinit var list: List<String>
}

fun main(args: Array<String>) {
    log.info("starting moe.ksmeow.ktyaml")
    val inputStream = File("example.yml").inputStream()
    val yaml = Yaml(Constructor(YamlObj::class.java))
    val obj: YamlObj = yaml.load(inputStream)
    log.info(obj.number.toString())
    log.info(obj.string)
    log.info(obj.list.toString())
}
