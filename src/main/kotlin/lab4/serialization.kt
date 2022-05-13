package lab4

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

object ModelSerialization {
    private val json = Json

    private fun serialization(maze: MutableList<MutableList<Cell>>) = json.encodeToString(maze)

    private fun deserialization(stringToDecoder: String) =
        json.decodeFromString<MutableList<MutableList<Cell>>>(stringToDecoder)

    fun serializationToFile(maze: MutableList<MutableList<Cell>>, fileName: String) {
        File(fileName).writeText(serialization(maze))
    }

    fun deserializationFromFile(fileName: String): MutableList<MutableList<Cell>> {
        val file = File(fileName)
        if (!file.exists())
            throw IllegalArgumentException("File can't be found")
        return deserialization(file.readText())
    }
}