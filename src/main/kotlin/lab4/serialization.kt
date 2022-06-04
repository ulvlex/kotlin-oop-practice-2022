package lab4

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

object ModelSerialization {
    private val json = Json

    private fun serialization(maze: List<List<Cell>>) = json.encodeToString(maze)

    private fun deserialization(stringToDecoder: String) =
        json.decodeFromString<List<List<Cell>>>(stringToDecoder)

    fun serializationToFile(maze: List<List<Cell>>, fileName: String) {
        File(fileName).writeText(serialization(maze))
    }

    fun deserializationFromFile(fileName: String): Model {
        val file = File(fileName)
        if (!file.exists())
            throw IllegalArgumentException("File can't be found")

        return Model(deserialization(file.readText()) as MutableList<MutableList<Cell>>)
    }
}