package cl.ravenhill.database

/**
 * Represents an encrypted database connection.
 *
 * ## Usage:
 * This class extends `DatabaseConnection` to handle encrypted database connections. It overrides the `closeConnection`
 * method to indicate that the connection being closed is encrypted.
 *
 * ### Example 1: Starting and Closing an Encrypted Connection
 * ```kotlin
 * val encryptedDbConnection = EncryptedDatabaseConnection("jdbc:mysql://localhost:3306/mydb")
 * encryptedDbConnection.startConnection()
 * encryptedDbConnection.closeConnection()
 * ```
 * The output will be:
 * ```
 * Connecting to jdbc:mysql://localhost:3306/mydb
 * Closing encrypted connection to jdbc:mysql://localhost:3306/mydb
 * ```
 *
 * @param url The database connection URL, passed to the superclass.
 */
class EncryptedDatabaseConnection(url: String) : DatabaseConnection(url) {
    /**
     * Closes the encrypted connection to the database. Overrides the default behavior of `DatabaseConnection` to
     * indicate that the connection is encrypted.
     */
    override fun closeConnection() = println("Closing encrypted connection to $url")
}
