package enekes.abel.musicevents.mock

import com.orm.SugarRecord

/**
 * Repository pattern to encapsulate access to the database using SugarORM objects
 */
interface SugarRepository<T : SugarRecord<T>> {
    @Throws(Exception::class)
    fun create(type: Class<T>): T

    fun save(t: T)

    fun delete(t: T)

    fun findById(type: Class<T>, id: Long): T?

    fun getAll(type: Class<T>): List<T>

    fun query(type: Class<T>, whereClause: String, vararg whereArgs: String): List<T>?
}