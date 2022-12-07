package me.keane.adventofcode.day7

import me.keane.adventofcode.util.fold
import java.io.File

interface Node {
    val name: String
    val size: Long
    val parent: Directory?
    val children: List<Node>
    fun getChild(name: String): Node?
    fun addChild(target: Node): Node

    val root: Directory
        get() {
            var current = this
            var parent = current.parent
            while (parent != null) {
                current = parent
                parent = current.parent
            }
            return current as Directory
        }
}

fun Node.getDirectories(): List<Directory> = children
    .filterIsInstance(Directory::class.java)
    .plus(children.flatMap { it.getDirectories() })

fun File.createNodes(): Node = fold(Directory("/", null)) { current, cmd ->
    when {
        cmd == "$ ls" -> current
        cmd == "$ cd /" -> current.root
        cmd == "$ cd .." -> current.parent ?: current
        cmd.startsWith("$ cd ") -> cmd
            .substring(5)
            .let { name ->
                current.getChild(name) as? Directory ?: Directory(name, current).also { current.addChild(it) }
            }
        cmd.startsWith("dir") -> current.addChild(Directory(cmd.split(" ").last(), current))
        else -> cmd
            .split(" ")
            .let { (size, name) -> current.addChild(FileNode(name, size.toLong(), current)) }
    }
}.root