package me.keane.adventofcode.day7

class FileNode(
    override val name: String,
    override val size: Long,
    override val parent: Directory?
) : Node {
    override val children: List<Node> = emptyList()
    override fun getChild(name: String): Node? = null
    override fun addChild(target: Node): Node = this
}