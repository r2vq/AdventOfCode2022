package me.keane.adventofcode.day7

class Directory(
    override val name: String,
    override val parent: Directory?
) : Node {
    override val size: Long
        get() = children.fold(0L) { acc, node -> acc + node.size }
    override val children = mutableListOf<Node>()

    override fun getChild(name: String): Node? = children.firstOrNull { it.name == name }
    override fun addChild(target: Node): Directory {
        children.add(target)
        return this
    }
}