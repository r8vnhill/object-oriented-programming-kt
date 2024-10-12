package cl.ravenhill.database

/**
 * Represents a basic database connection.
 *
 * ## Usage:
 * This class provides methods to manage the lifecycle of a database connection, including starting and closing the
 * connection. Subclasses can override the `closeConnection` method to provide custom behavior when closing the
 * connection.
 *
 * ### Example 1: Starting and Closing a Connection
 * ```kotlin
 * val dbConnection = DatabaseConnection("jdbc:mysql://localhost:3306/mydb")
 * dbConnection.startConnection()
 * dbConnection.closeConnection()
 * ```
 * The output will be:
 * ```
 * Connecting to jdbc:mysql://localhost:3306/mydb
 * Closing connection to jdbc:mysql://localhost:3306/mydb
 * ```
 *
 * @property url The database connection URL. This value is protected and is available to subclasses.
 */
open class DatabaseConnection(protected val url: String) {
    /**
     * Starts the connection to the database.
     */
    fun startConnection() = println("Connecting to $url")

    /**
     * Closes the connection to the database. Subclasses can override this method to provide custom closure behavior.
     */
    open fun closeConnection() = println("Closing connection to $url")
}
