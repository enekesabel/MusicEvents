package enekes.abel.musicevents.mock

import com.orm.SugarRecord

import org.mockito.Mockito

import org.mockito.Mockito.doReturn
import java.lang.reflect.InvocationTargetException

abstract class MockSugarRepository<T : SugarRecord<T>> : SugarRepository<T> {
    private val records = ArrayList<T>()

    private var nextId: Long = 1

    protected fun getRecords(): List<T> {
        return records
    }

    @Throws(Exception::class)
    override fun create(type: Class<T>): T {
        val t = Mockito.mock(type)
        doReturn(nextId++).`when`(t).id
        return t
    }

    override fun save(t: T) {
        t.save()
        records.add(t)
    }

    override fun delete(t: T) {
        t.delete()
        records.remove(t)
    }

    override fun findById(type: Class<T>, id: Long): T? {
        for (t in records) {
            if (t.id == id) {
                return t
            }
        }
        return null
    }

    override fun getAll(type: Class<T>): List<T> {
        val result = ArrayList<T>()
        result.addAll(this.records)
        return result
    }

    override fun query(type: Class<T>, whereClause: String, vararg whereArgs: String): List<T> {
        val results: MutableList<T> = ArrayList()
        try {
            val getName = type.getMethod("getName")
            for (t in records) {
                if (whereClause.startsWith("name")) {
                    val name = getName.invoke(t) as String
                    if (name.equals(whereArgs[0], ignoreCase = true)) {
                        results.add(t)
                    }
                }
            }
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }

        return results
    }
}